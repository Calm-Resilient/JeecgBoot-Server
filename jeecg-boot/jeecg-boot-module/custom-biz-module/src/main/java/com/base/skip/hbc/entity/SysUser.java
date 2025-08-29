package com.base.skip.hbc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema
@Data
@TableName(value = "sys_user")
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @TableField(value = "id")
    @Schema(description="主键")
    private String id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @Schema(description="用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @Schema(description="密码")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "nick")
    @Schema(description="昵称")
    private String nick;

    private static final long serialVersionUID = 1L;
}