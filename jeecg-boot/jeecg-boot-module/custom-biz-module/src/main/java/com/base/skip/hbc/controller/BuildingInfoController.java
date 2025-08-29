package com.base.skip.hbc.controller;


import com.base.skip.hbc.entity.BuildingInfo;
import com.base.skip.hbc.service.BuildingInfoService;
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
 * (building_info)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/skip/buildingInfo")
@Tag(name = "楼栋信息", description = "楼栋信息")
public class BuildingInfoController {

    @Autowired
    private BuildingInfoService buildingInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @Operation(summary = "查询所有楼栋")
    @GetMapping("/list")
    public Result queryList() {

        List<BuildingInfo> list = buildingInfoService.list();

        return Result.OK(list);


    }
}
