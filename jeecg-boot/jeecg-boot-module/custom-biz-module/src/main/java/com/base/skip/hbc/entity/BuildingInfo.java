package com.base.skip.hbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema
@Data
@TableName(value = "biz_hbc_building_info")
public class BuildingInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @Schema(description="主键")
    private String id;

    /**
     * 楼号
     */
    @TableField(value = "building_type")
    @Schema(description="楼号")
    private String buildingType;

    /**
     * 总层数
     */
    @TableField(value = "total_layer")
    @Schema(description="总层数")
    private Integer totalLayer;

    /**
     * 当前层数
     */
    @TableField(value = "built_layer")
    @Schema(description="当前层数")
    private Integer builtLayer;

    private static final long serialVersionUID = 1L;
}