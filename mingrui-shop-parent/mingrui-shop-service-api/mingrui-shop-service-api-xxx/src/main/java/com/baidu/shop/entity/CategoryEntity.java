package com.baidu.shop.entity;

import com.baidu.shop.validate.group.MingruiOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName CategoryEntity
 * @Description: TODO
 * @Author shenyaqi
 * @Date 2021/1/19
 * @Version V1.0
 **/
@ApiModel(value = "分类实体类")
@Data
@Table(name = "tb_category")
public class CategoryEntity {

    @Id //声明主键
    @ApiModelProperty(value = "类目id",example = "1")
    @NotNull(message = "id不能为空", groups = {MingruiOperation.Update.class})
    private Integer id;

    @ApiModelProperty(value = "分类名字")
    @NotEmpty(message = "分类名字不可为空",groups = {MingruiOperation.Add.class,MingruiOperation.Update.class})
    private String name;

    @ApiModelProperty(value = "类目父id",example = "1")
    @NotNull(message = "父id不能为空", groups = {MingruiOperation.Add.class})
    private Integer parentId;

    @ApiModelProperty(value = "是否为父节点",example = "1")
    @NotNull(message = "父节点不可为空",groups = {MingruiOperation.Add.class})
    private Integer isParent;

    @ApiModelProperty(value = "是否为排序字段",example = "1")
    @NotNull(message = "排序字段不可为空",groups = {MingruiOperation.Add.class})
    private Integer sort;

}
