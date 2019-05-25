package com.selune.luckymoney.controller;

import com.selune.luckymoney.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Controller + @ResponseBody = @RestController
 * @RequestMapping = @Get + @Post
 * @Author: Selune
 * @Date: 2019/5/23 14:33
 */

@Component
@RestController
//@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping({"/say", "/hi"})
    @ResponseBody
    public String say() {
        return "description= " + limitConfig.getDescription();
    }

//    @GetMapping("/say2")
    @PostMapping("/say2")
//    @RequestMapping("say2")
    public String say2() {
        return "index";
    }

    @GetMapping("/say3")
    public String say3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id= " + id;
    }
}
