package com.base.biz.service.impl;

import com.base.biz.entity.TestEmployee;
import com.base.biz.mapper.TestEmployeeMapper;
import com.base.biz.service.ITestEmployeeService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 测试员工表
 * @Author: jeecg-boot
 * @Date:   2025-08-28
 * @Version: V1.0
 */
@Service
public class TestEmployeeServiceImpl extends ServiceImpl<TestEmployeeMapper, TestEmployee> implements ITestEmployeeService {

}
