package com.ruoyi.wangyuan.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.wangyuan.Config.TimeJsonSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 管理员对象 fa_admin
 * 
 * @author li
 * @date 2020-07-24
 */
public class FaAdmin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 密码盐 */
    @Excel(name = "密码盐")
    private String salt;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 失败次数 */
    @Excel(name = "失败次数")
    private Integer loginfailure;

    /** 登录时间 */
    @Excel(name = "登录时间")
    @JsonSerialize(using = TimeJsonSerializer.class)
    private Integer logintime;

    /** Session标识 */
    @Excel(name = "Session标识")
    private String token;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    @Excel(name = "创建时间")
    @JsonSerialize(using = TimeJsonSerializer.class)
    private Integer createtime;

    @Excel(name = "更新时间")
    @JsonSerialize(using = TimeJsonSerializer.class)
    private Integer updatetime;

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setSalt(String salt) 
    {
        this.salt = salt;
    }

    public String getSalt() 
    {
        return salt;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setLoginfailure(Integer loginfailure) 
    {
        this.loginfailure = loginfailure;
    }

    public Integer getLoginfailure() 
    {
        return loginfailure;
    }
    public void setLogintime(Integer logintime) 
    {
        this.logintime = logintime;
    }

    public Integer getLogintime() 
    {
        return logintime;
    }
    public void setToken(String token) 
    {
        this.token = token;
    }

    public String getToken() 
    {
        return token;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("nickname", getNickname())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("avatar", getAvatar())
            .append("email", getEmail())
            .append("loginfailure", getLoginfailure())
            .append("logintime", getLogintime())
            .append("createtime", getCreatetime())
            .append("updatetime", getUpdatetime())
            .append("token", getToken())
            .append("status", getStatus())
            .toString();
    }
}
