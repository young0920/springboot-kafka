package com.young.springbootkafka.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.young.springbootkafka.constant.CodeEnum;
import com.young.springbootkafka.constant.ResultBody;
import org.apache.commons.codec.CharEncoding;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by echisan on 2018/6/24
 *
 * @author young
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(CharEncoding.UTF_8);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ResultBody<String> error = ResultBody.error(CodeEnum.AUTHOR_ERROR.getResultCode(), authException.getMessage());
        response.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }

}
