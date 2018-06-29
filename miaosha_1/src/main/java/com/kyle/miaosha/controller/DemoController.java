package com.kyle.miaosha.controller;

import com.kyle.miaosha.domain.User;
import com.kyle.miaosha.result.CodeMsg;
import com.kyle.miaosha.result.Result;
import com.kyle.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("hello")
    @ResponseBody
    public Result<String> hello(){
        //return new Result<String>(0,"success","欢迎你");
        return Result.success("欢迎你");
    }

    @RequestMapping("helloError")
    @ResponseBody
    public Result<String> helloError(){
        //return new Result<String>(50010,"error",null);
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","Kyle");
        return "hello";

    }

    @Autowired
    UserService userService;

    @RequestMapping("db/get")
    @ResponseBody
    public Result<User> db(){
        return Result.success(userService.getById(1));
    }

    @RequestMapping("db/tx")
    @ResponseBody
    public Result<Boolean> tx(){
        userService.insert();
        return Result.success(true);
    }
}

