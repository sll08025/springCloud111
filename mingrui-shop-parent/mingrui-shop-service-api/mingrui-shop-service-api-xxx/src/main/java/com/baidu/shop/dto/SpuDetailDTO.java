package com.baidu.shop.dto;

import com.baidu.shop.validate.group.MingruiOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName SpuDetailDTO
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2021/1/25
 * @Version V1.0
 **/

@ApiModel(value = "spu大字段数据传输类")
@Data
public class SpuDetailDTO {
    @ApiModelProperty(value = "spu主键",example = "1")
    @NotNull(message = "spu主键不可为空",groups = {MingruiOperation.Update.class})
    private Integer spuId;

    @ApiModelProperty(value = "商品描述信息")
    private String description;

    @ApiModelProperty(value = "通用规格参数")
    private String genericSpec;


}
