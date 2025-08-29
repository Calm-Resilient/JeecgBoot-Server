package com.base.skip.hbc.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.base.skip.hbc.entity.BuildingLayer;
import com.base.skip.hbc.service.BuildingLayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jeecg.common.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 建筑进度表(building_layer)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/skip/buildingLayer")
@Tag(name = "楼层信息", description = "楼层信息")
public class BuildingLayerController {
    /**
     * 服务对象
     */
    @Autowired
    private BuildingLayerService buildingLayerService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @Operation(summary = "根据楼栋查询所拥有层级(不传参查询所有层数)")
    @GetMapping("/listByBulid")
    public Result listByBulid(@RequestParam(required = false) Integer buildingType) {

        List<BuildingLayer> list = buildingLayerService.list(Wrappers.<BuildingLayer>lambdaQuery()
                .eq(ObjectUtils.isNotNull(buildingType), BuildingLayer::getBuildingType, buildingType));

        return Result.ok(list);

    }

}
