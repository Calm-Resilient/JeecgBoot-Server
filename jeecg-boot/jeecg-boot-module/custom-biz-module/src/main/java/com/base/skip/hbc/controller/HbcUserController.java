package com.base.skip.hbc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * (sys_user)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/sysUser")
@Tag(name = "用户接口",description = "用户信息")
public class HbcUserController {
    /**
//     * 服务对象
//     */
//    @Autowired
//    private sysusers sysUserService;
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param
//     * @return 单条数据
//     */
//    @GetMapping("queryByUsername")
//    public R queryByUsername(@RequestParam(name = "username") String username) {
//        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery()
//                .eq(SysUser::getUsername, username));
//        return ResultUtils.success(sysUser);
//    }

}
