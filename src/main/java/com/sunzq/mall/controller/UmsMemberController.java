package com.sunzq.mall.controller;

import com.sunzq.mall.common.CommonResult;
import com.sunzq.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理controller
 * @author Q
 * @data 2021/5/16 20:33
 */
@Api(tags = "会员登录注册管理controller")
@Controller
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone){
        return umsMemberService.getAuthCode(telephone);
    }

    @ApiOperation("校验验证码")
    @PostMapping("/verifyAuthCode")
    @ResponseBody
    public CommonResult verifyAuthCode(String telephone,String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }

}
