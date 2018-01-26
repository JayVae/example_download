package com.example.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Jay
 * @Date: Created in 21:55 2018/1/25
 * @Modified By:
 */


@Controller
public class myController {
    @RequestMapping("/")
    public String index(){return "index";}

    @RequestMapping("/testHttpMessageDown")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        File file = new File("\\C:\\Users\\dell\\Desktop\\tmp\\3.png");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }



}
