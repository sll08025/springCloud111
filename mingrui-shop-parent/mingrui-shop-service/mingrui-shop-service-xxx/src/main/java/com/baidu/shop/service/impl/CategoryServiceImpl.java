package com.baidu.shop.service.impl;

import com.baidu.shop.base.BaseApiService;
import com.baidu.shop.base.Result;
import com.baidu.shop.entity.CategoryEntity;
import com.baidu.shop.mapper.CategoryMapper;
import com.baidu.shop.service.CategoryService;
import com.baidu.shop.status.HTTPStatus;
import com.baidu.shop.utils.ObjectUtil;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;


import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2021/1/18
 * @Version V1.0
 **/
@RestController
public class CategoryServiceImpl extends BaseApiService implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Result<List<CategoryEntity>> CategoryByBrandId(Integer brandId) {
        List<CategoryEntity> categoryEntityList = categoryMapper.CategoryByBrandId(brandId);
        return this.setResultSuccess(categoryEntityList);
    }

    @Override
    public Result<List<CategoryEntity>> getCategoryByPid(Integer pid) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setParentId(pid);
        List<CategoryEntity> entityList = categoryMapper.select(categoryEntity);
        return this.setResultSuccess(entityList);
    }

    @Transactional
    @Override
    public Result<JsonObject> editCategoryById(CategoryEntity categoryEntity) {
        categoryMapper.updateByPrimaryKeySelective(categoryEntity);
        return this.setResultSuccess();
    }

    @Transactional
    @Override
    public Result<JsonObject> addCategoryById(CategoryEntity categoryEntity) {
        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setId(categoryEntity.getParentId());
        categoryEntity1.setIsParent(1);
        categoryMapper.updateByPrimaryKeySelective(categoryEntity1);
        categoryMapper.insertSelective(categoryEntity);
        return this.setResultSuccess();
    }

    @Transactional
    @Override
    public Result<JsonObject> deleteCategoryById(Integer id) {
        //判断id是否合法
        if (ObjectUtil.isNull(id) || id <= 0)return this.setResultError(HTTPStatus.OPERATION_ERROR,"id不合法");
        CategoryEntity categoryEntity = categoryMapper.selectByPrimaryKey(id);
        //判断数据是否存在
        if (ObjectUtil.isNull(categoryEntity))return this.setResultError(HTTPStatus.OPERATION_ERROR,"数据不存在");
        //当前节点是否父节点
        if (categoryEntity.getIsParent()==1)return this.setResultError(HTTPStatus.OPERATION_ERROR,"当前节点为父节点");
        //当前父节点下是否还有其他 子节点
        Example example = new Example(CategoryEntity.class);
        example.createCriteria().andEqualTo("parentId",categoryEntity.getParentId());
        List<CategoryEntity> categoryEntityList = categoryMapper.selectByExample(example);
        //如果没有子节点就吧父节点改成子节点
        if (categoryEntityList.size()<=1){
            CategoryEntity categoryEntity1 = new CategoryEntity();
            categoryEntity1.setId(categoryEntity.getParentId());
            categoryEntity1.setIsParent(0);
            categoryMapper.updateByPrimaryKeySelective(categoryEntity1);
        }
        categoryMapper.deleteByPrimaryKey(id);

        return this.setResultSuccess();
    }
}
