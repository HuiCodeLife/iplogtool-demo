package com.github.ithuidev.Interceptor;

import com.github.ithuidev.service.IpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : ithuidev
 * @create : 2022/11/21
 */
public class IpLogInterceptor implements HandlerInterceptor {
    @Autowired
    private IpLogService ipLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipLogService.logCount();
        return true;
    }
}
