package org.cafeop.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class Logger implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(req, res);

        // Request logging
        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        headerNames.asIterator().forEachRemaining(headerKey -> {
            var headerValue = req.getHeader(headerKey);
            // [headerKey : headerValue]
            headerValues.append("[").append(headerKey).append(" : ").append(headerValue).append("]");
        });
        var requestBody = new String(req.getContentAsByteArray());
        var uri = req.getRequestURI();
        var method = req.getMethod();

        log.info("uri : {}, method : {}, header : {}, body : {}", uri, method, headerValues, requestBody);
        // TODO : Logging 별도 DB에 저장

        // Response logging
        var responseHeaderValues = new StringBuilder();

        res.getHeaderNames().forEach(headerKey -> {
            var headerValue = res.getHeader(headerKey);

            responseHeaderValues.append("[").append(headerKey).append(" : ").append(headerValue).append("]");
        });
        var resposneBody = new String(res.getContentAsByteArray());

        log.info("uri : {}, method : {}, header : {}, body : {}", uri, method, headerValues, resposneBody);
        // TODO : Logging 별도 DB에 저장

        // Response 값이 Filter에서 읽어 삭제됨을 방지
        res.copyBodyToResponse();

    }
}
