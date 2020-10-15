package com.young.springbootkafka.service.authservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.springbootkafka.constant.CodeEnum;
import com.young.springbootkafka.constant.ResultBody;
import org.apache.commons.codec.CharEncoding;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一处理权限异常
 *
 * @author young
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(CharEncoding.UTF_8);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ResultBody<String> error = ResultBody.error(CodeEnum.AUTHOR_ERROR.getResultCode(), authException.getMessage());
        response.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }

}
