package com.tyrone.tigerstep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    @RequestMapping("/req/{method}") // ajax请求
    @ResponseBody
    private static String reqManager(@PathVariable String method, HttpServletRequest request, HttpServletResponse response) throws Exception{
        return null;
    }


}
