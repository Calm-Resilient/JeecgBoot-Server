package com.base.skip.hbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.skip.hbc.entity.BuildingInfo;
import com.base.skip.hbc.mapper.BuildingInfoMapper;
import com.base.skip.hbc.service.BuildingInfoService;
import org.springframework.stereotype.Service;

@Service
public class BuildingInfoServiceImpl extends ServiceImpl<BuildingInfoMapper, BuildingInfo> implements BuildingInfoService {

}
