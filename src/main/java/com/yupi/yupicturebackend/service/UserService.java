package com.yupi.yupicturebackend.service;

import com.yupi.yupicturebackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupicturebackend.model.vo.LoginUserVo;

import javax.servlet.http.HttpServletRequest;

/**
* @author a1234
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-04-15 22:43:45
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    Long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @param httpServletRequest
     * @return
     */
    LoginUserVo userLogin(String userAccount, String userPassword, HttpServletRequest httpServletRequest);

    /**
     * 获取加密之后的密码
     * @param userPassword
     * @return
     * @throws Exception
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取脱敏之后的用户信息
     * @param user
     * @return
     */
    LoginUserVo getLoginUserVo(User user);

    /**
     * 获取当前登录用户
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);
}
