package com.sunzq.mall.service;

/**
 * @author Q
 * @data 2021/5/16 20:20
 */
public interface RedisService {
    void set(String key, String value);

    String get(String key);

    boolean expire(String key, long expire);

    void remove(String key);

    long increment(String key, long delta);
}
