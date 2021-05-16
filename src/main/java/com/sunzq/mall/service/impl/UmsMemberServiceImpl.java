package com.sunzq.mall.service.impl;

import com.sunzq.mall.common.CommonResult;
import com.sunzq.mall.service.RedisService;
import com.sunzq.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 会员管理service
 * @author Q
 * @data 2021/5/16 20:44
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Override
    public CommonResult getAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString());
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String value = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
        boolean result = authCode.equals(value);
        if(result){
            return CommonResult.success(null,"验证码正确");
        }else{
            return CommonResult.failed("验证码错误");
        }

    }
}
