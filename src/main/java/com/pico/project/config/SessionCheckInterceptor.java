package com.pico.project.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUrl = request.getRequestURI();
        // AJAX 요청을 제외하기 위한 헤더 검사
        String requestedWith = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestedWith)) {
            // AJAX 요청은 세션 체크를 수행하지 않음
            return true;
        }

        // 정적 리소스 요청을 제외하기 위한 조건
        if (requestUrl.startsWith("/css/") || requestUrl.startsWith("/js/")) {
            return true;
        }

        HttpSession session = request.getSession(false); // 세션이 없으면 null을 반환

        // 로그인 페이지로 리디렉션 (세션이 없거나 유저 정보가 없는 경우)
        if (session == null || session.getAttribute("userDto") == null) {
            // 리디렉션할 URL을 제외한 모든 요청에서 리디렉션을 수행
            if (!requestUrl.equals("/login") && !requestUrl.equals("/") && !requestUrl.equals("/user/userJoin")) {
                response.sendRedirect("/login");
                return false; // 요청 처리를 중단합니다.
            }
            return true; // 로그인 페이지 요청은 계속 처리합니다.
        }

        // 세션이 존재하고 요청 URL이 "/"인 경우 메인 페이지로 리디렉션
        if (requestUrl.equals("/")) {
            response.sendRedirect("/fr_main");
            return false; // 요청 처리를 중단합니다.
        }

        // 세션이 존재하고 요청 URL이 "/user/"로 시작하는 경우 메인 페이지로 리디렉션
        if (requestUrl.startsWith("/user/")) {
            // 현재 요청 URL이 리디렉션 URL과 같은 경우 리디렉션을 수행하지 않음
            if (!requestUrl.equals("/fr_main")) {
                response.sendRedirect("/fr_main");
                return false; // 요청 처리를 중단합니다.
            }
        }

        // 세션이 유효하면 요청을 계속 처리합니다.
        return true;
    }
}