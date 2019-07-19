package com.allinpay.controller;

import com.allinpay.core.common.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sso")
@Slf4j
public class LoginController {

    /**
     * @Description: 用户登录
     * @Param: session, captcha, username, password
     * @Return: ResponseData
     */
    @RequestMapping("login")
    @ResponseBody
    public ResponseData login(HttpSession session, HttpServletResponse response, String service,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        String status = (String) session.getAttribute("status");
        if (!"success".equals(status)) {
            //登录逻辑处理
            session.setAttribute("status", "success");
        }
        //生成ticket
        String ticket = "123456";
        //cookie
        Cookie cookie = new Cookie("name", "TG");
        cookie.setDomain("dev.allinpay.cn");
        cookie.setPath("/sso");
        response.addCookie(cookie);
        //页面跳转
        if (StringUtils.isBlank(service)) {
            //直接登录sso系统
            return ResponseData.success().setData("/sso/index");
        } else {
            //访问其他应用，非sso系统
            return ResponseData.success().setData(service + "?ticket=" + ticket);
        }
    }

    /**
     * @Description: 退出
     * @Param:
     * @Return: ResponseData
     */
    @RequestMapping("validate")
    @ResponseBody
    public ResponseData validate(String ticket, String service) {
        System.out.println(ticket);
        System.out.println(service);
        return ResponseData.success().setData(null);
    }

    @GetMapping({"/", "loginpage"})
    public ModelAndView loginPage(HttpSession session, String service) {
        System.out.println("请求服务器名称：" + service);
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.getModel().put("service", service);
        modelAndView.getModel().put("status", session.getAttribute("status"));
        //已登录，生成票据
        if ("success".equals(session.getAttribute("status"))) {
            modelAndView.getModel().put("ticket", "123456");
        }
        modelAndView.getModel().put("status", session.getAttribute("status"));
        return modelAndView;
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
