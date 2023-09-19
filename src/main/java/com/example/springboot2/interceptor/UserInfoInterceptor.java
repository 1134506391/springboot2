package com.example.springboot2.interceptor;



import com.example.springboot2.exception.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader("userId");
        String userToken = request.getHeader("userToken");

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userToken)) {
            log.error("用户校验不通过，信息不完整");
            GraceException.display("用户校验不通过，信息不完整");
            return false;
        }

        // 假设真实的用户id是1001，用户token是abcxyz
        if (!userId.equalsIgnoreCase("1001")
                || !userToken.equalsIgnoreCase("abc")) {
            log.error("用户权限不通过");
            GraceException.display("用户权限不通过");
            return false;
        }

        /**
         * false: 请求被拦截
         * true: 请求放行，可以继续访问后面的controller
         */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
