package com.young.springbootkafka.controller;

import com.young.springbootkafka.constant.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileController
 *
 * @author yangbing
 * @date 2020/10/21 2:58 下午
 */
@RestController
@RequestMapping("file")
@CrossOrigin//解决跨域
@Slf4j
public class FileController {

    @PostMapping("upload")
    public ResultBody<String> uploadWork(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        String fileName = "";
        if (!file.isEmpty()) {
            fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
        }

        return ResultBody.success(fileName);
    }
}
