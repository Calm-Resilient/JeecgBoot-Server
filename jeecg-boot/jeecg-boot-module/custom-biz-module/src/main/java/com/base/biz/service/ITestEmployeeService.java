package com.base.biz.service;

import com.base.biz.entity.TestEmployee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.common.aspect.annotation.PermissionData;

import java.util.List;

/**
 * @Description: 测试员工表
 * @Author: jeecg-boot
 * @Date:   2025-08-26
 * @Version: V1.0
 */
public interface ITestEmployeeService extends IService<TestEmployee> {
    List<TestEmployee> getOneTest();
}
