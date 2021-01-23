package com.baidu.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.baidu.shop.base.Result;
import com.baidu.shop.dto.BrandDTO;
import com.baidu.shop.entity.BrandEntity;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "品牌接口")
public interface BrandService {
    @ApiOperation(value = "查询品牌列表")
    @GetMapping(value = "brand/list")
    Result<PageInfo<BrandEntity>>getBrandInfo(BrandDTO brandDTO);

    @GetMapping(value = "brand/getBrandInfoByCategoryId")
    @ApiOperation(value = "通过分类id查询品牌")
    Result<List<BrandEntity>>getBrandInfoByCategoryId(Integer cid);

    @ApiOperation(value = "新增品牌")
    @PostMapping(value = "brand/save")
    Result<JSONObject>saveBrandInfo(@RequestBody BrandDTO brandDTO);

    @ApiOperation(value = "更新品牌")
    @PutMapping(value = "brand/save")
    Result<JSONObject>editBrandInfo(@RequestBody BrandDTO brandDTO);

    @DeleteMapping(value = "brand/delete")
    @ApiOperation(value = "删除品牌")
    Result<JSONObject>deleteBrandInfo(Integer id);
}