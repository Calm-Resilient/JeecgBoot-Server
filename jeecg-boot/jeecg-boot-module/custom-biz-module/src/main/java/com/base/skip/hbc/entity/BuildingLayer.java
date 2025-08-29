package com.base.skip.hbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
    * 建筑进度表
    */
@Schema(description="建筑进度表")
@Data
@TableName(value = "biz_hbc_building_layer")
public class BuildingLayer implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @Schema(description="主键ID")
    private String id;

    /**
     * 楼层
     */
    @TableField(value = "`count`")
    @Schema(description="楼层")
    private Integer count;

    /**
     * 状态: 未建造、正在建造、待装修、正在装修、已装修
     */
    @TableField(value = "`state`")
    @Schema(description="状态: 未建造、正在建造、待装修、正在装修、已装修")
    private Integer state;

    /**
     * 计划开始时间
     */
    @TableField(value = "plan_start_time")
    @Schema(description="计划开始时间")
    private String planStartTime;

    /**
     * 计划结束时间
     */
    @TableField(value = "plan_end_time")
    @Schema(description="计划结束时间")
    private String planEndTime;

    /**
     * 实际开始时间
     */
    @TableField(value = "build_start_time")
    @Schema(description="实际开始时间")
    private String buildStartTime;

    /**
     * 实际结束时间
     */
    @TableField(value = "build_end_time")
    @Schema(description="实际结束时间")
    private String buildEndTime;

    /**
     * 装修开始时间
     */
    @TableField(value = "fitment_start_time")
    @Schema(description="装修开始时间")
    private String fitmentStartTime;

    /**
     * 装修结束时间
     */
    @TableField(value = "fitment_end_time")
    @Schema(description="装修结束时间")
    private String fitmentEndTime;

    /**
     * 楼栋编号,关联楼栋表
     */
    @TableField(value = "building_type")
    @Schema(description="楼栋编号,关联楼栋表")
    private Integer buildingType;

    private static final long serialVersionUID = 1L;
}