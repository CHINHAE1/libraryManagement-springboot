package com.chinhae.librarymanagement.controller;

import com.chinhae.librarymanagement.entity.Result;
import com.chinhae.librarymanagement.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 这个类是：基础控制器
 *
 * @author: CHINHAE
 * @date: 2024/7/8 14:29
 * @version: 1.0
 */
public abstract class BaseController {
    /**
     * 当前账号常量
     */
    private static final String USER = "user";

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public User getUser() {
        HttpSession session = getRequest().getSession();
        return (User) session.getAttribute(USER);
    }

    public void setUser(User user) {
        HttpSession session = getRequest().getSession();
        if (user != null){
            session.setAttribute(USER, user);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }
}
