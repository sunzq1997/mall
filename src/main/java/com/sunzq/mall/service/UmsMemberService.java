package com.sunzq.mall.service;

import com.sunzq.mall.common.CommonResult;

/**
 * @author Q
 * @data 2021/5/16 20:42
 */
public interface UmsMemberService {
    CommonResult getAuthCode(String telephone);
    CommonResult verifyAuthCode(String telephone,String authCode);
}
