package com.baidu.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baidu.shop.base.BaseApiService;
import com.baidu.shop.base.Result;
import com.baidu.shop.entity.CategoryEntity;
import com.baidu.shop.mapper.CategoryMapper;
import com.baidu.shop.service.CategoryService;
import com.baidu.shop.status.HTTPStatus;
import com.baidu.shop.utils.ObjectUtil;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<CategoryEntity>list = categoryMapper.CategoryByBrandId(brandId);
        return this.setResultSuccess(list);
    }

    @Override
    public Result<List<CategoryEntity>> getCategoryByPid(Integer pid) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setParentId(pid);
        List<CategoryEntity>list = categoryMapper.select(categoryEntity);
        return this.setResultSuccess(list);
    }

    @Transactional
    @Override
    public Result<JSONObject> deleteCategoryById(Integer id) {
        if (ObjectUtil.isNull(id) || id <=0)return this.setResultError(HTTPStatus.OPERATION_ERROR,"id不合法");
        CategoryEntity categoryEntity = categoryMapper.selectByPrimaryKey(id);
        if(ObjectUtil.isNull(categoryEntity)) return this.setResultError(HTTPStatus.OPERATION_ERROR,"数据不存在");
        if(categoryEntity.getIsParent() == 1) return this.setResultError(HTTPStatus.OPERATION_ERROR,"当前节点为父节点");
        Example example  = new Example(CategoryEntity.class);
        example.createCriteria().andEqualTo("parentId",categoryEntity.getParentId());
        List<CategoryEntity> categoryEntityList = categoryMapper.selectByExample(example);
        if (categoryEntityList.size()<=1){
            CategoryEntity updateCategoryEntity = new CategoryEntity();
            updateCategoryEntity.setIsParent(0);
            updateCategoryEntity.setId(categoryEntity.getParentId());
            categoryMapper.updateByPrimaryKeySelective(updateCategoryEntity);
        }
        categoryMapper.deleteByPrimaryKey(id);
        return this.setResultSuccess();
    }

    @Transactional
    @Override
    public Result<JSONObject> editCategoryById(CategoryEntity categoryEntity) {
        categoryMapper.updateByPrimaryKeySelective(categoryEntity);
        return this.setResultSuccess();
    }

    @Transactional
    @Override
    public Result<JsonObject> addCategoryById(CategoryEntity categoryEntity) {
        CategoryEntity parentCategoryEntity = new CategoryEntity();
        parentCategoryEntity.setId(categoryEntity.getParentId());
        parentCategoryEntity.setIsParent(1);
        categoryMapper.updateByPrimaryKeySelective(parentCategoryEntity);
        categoryMapper.insertSelective(categoryEntity);
        return this.setResultSuccess();
    }
}
