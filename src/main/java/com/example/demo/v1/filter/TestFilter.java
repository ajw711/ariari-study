package com.example.demo.v1.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        //log.info("→ [Filter] doFilter 호출됨");

        // 다음 필터 or 컨트롤러로 요청 전달
        filterChain.doFilter(request, response);

        //log.info("← [Filter] 응답 후처리 수행");
    }
}
