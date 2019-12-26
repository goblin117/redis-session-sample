package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class Test{
    @RequestMapping(value="/getSessionId")
    @ResponseBody
    public String getSessionId(HttpServletRequest request){

        Object o = request.getSession().getAttribute("springboot");
        if(o == null){
            o = "spring boot 牛逼了!!!有端口"+request.getLocalPort()+"生成";
            request.getSession().setAttribute("springboot", o);
        }

        return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
    }
    @RequestMapping(value="/setSessionId")
    @ResponseBody
    public String setSessionId(HttpServletRequest request){

        request.getSession().setAttribute("url", request.getRequestURL());
        HashMap<String,Object> map = new HashMap<>();
        map.put("url", request.getRequestURL());
        return map.toString();
    }
}
