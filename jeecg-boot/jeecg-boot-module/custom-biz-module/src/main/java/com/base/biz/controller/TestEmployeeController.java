package com.base.biz.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.PermissionData;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import com.base.biz.entity.TestEmployee;
import com.base.biz.service.ITestEmployeeService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import retrofit2.http.GET;

/**
 * @Description: 测试员工表
 * @Author: jeecg-boot
 * @Date:   2025-08-26
 * @Version: V1.0
 */
@Tag(name="测试员工表")
@RestController
@RequestMapping("/biz/testEmployee")
@Slf4j
public class TestEmployeeController extends JeecgController<TestEmployee, ITestEmployeeService> {
	@Autowired
	private ITestEmployeeService testEmployeeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param testEmployee
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "测试员工表-分页列表查询")
	@Operation(summary="测试员工表-分页列表查询")
	@GetMapping(value = "/list")
	@PermissionData
	public Result<IPage<TestEmployee>> queryPageList( TestEmployee testEmployee,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {

		QueryWrapper<TestEmployee> queryWrapper = QueryGenerator.initQueryWrapper(testEmployee, req.getParameterMap());
		Page<TestEmployee> page = new Page<TestEmployee>(pageNo, pageSize);
		IPage<TestEmployee> pageList = testEmployeeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param testEmployee
	 * @return
	 */
	@AutoLog(value = "测试员工表-添加")
	@Operation(summary="测试员工表-添加")
	@RequiresPermissions("biz:test_employee:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody TestEmployee testEmployee) {
		testEmployeeService.save(testEmployee);

		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param testEmployee
	 * @return
	 */
	@AutoLog(value = "测试员工表-编辑")
	@Operation(summary="测试员工表-编辑")
	@RequiresPermissions("biz:test_employee:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody TestEmployee testEmployee) {
		testEmployeeService.updateById(testEmployee);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "测试员工表-通过id删除")
	@Operation(summary="测试员工表-通过id删除")
	@RequiresPermissions("biz:test_employee:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		testEmployeeService.removeById(id);
		return Result.OK("删除成功!");
	}


	 @AutoLog(value = "测试权限")
	 @Operation(summary="测试权限")
	 @GetMapping(value = "/test")
	 @PermissionData(pageComponent = "biz/TestEmployeeList")

	 public Result<List<TestEmployee> > getOne() {
		 LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
		 log.info("当前用户部门: {}", sysUser.getOrgCode());
		 List<TestEmployee>  oneTest = testEmployeeService.getOneTest();
		 return Result.OK(oneTest);
	 }
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "测试员工表-批量删除")
	@Operation(summary="测试员工表-批量删除")
	@RequiresPermissions("biz:test_employee:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.testEmployeeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "测试员工表-通过id查询")
	@Operation(summary="测试员工表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<TestEmployee> queryById(@RequestParam(name="id",required=true) String id) {
		TestEmployee testEmployee = testEmployeeService.getById(id);
		if(testEmployee==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(testEmployee);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param testEmployee
    */
    @RequiresPermissions("biz:test_employee:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, TestEmployee testEmployee) {
        return super.exportXls(request, testEmployee, TestEmployee.class, "测试员工表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("biz:test_employee:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, TestEmployee.class);
    }

}
