package com.base.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.base.biz.entity.TestEmployee;
import com.base.biz.mapper.TestEmployeeMapper;
import com.base.biz.service.ITestEmployeeService;
import org.jeecg.common.aspect.annotation.PermissionData;
import org.jeecg.common.system.query.QueryGenerator;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 测试员工表
 * @Author: jeecg-boot
 * @Date:   2025-08-26
 * @Version: V1.0
 */
@Service
public class TestEmployeeServiceImpl extends ServiceImpl<TestEmployeeMapper, TestEmployee> implements ITestEmployeeService {

    @Override
    public List<TestEmployee>  getOneTest() {
        QueryWrapper<TestEmployee> queryWrapper = QueryGenerator.initQueryWrapper(new TestEmployee());
        queryWrapper.lambda().ge(TestEmployee::getAge,22);
        List<TestEmployee> list = this.list(queryWrapper);
        return list;
    }
}
