package com.sunzq.mall;

import com.sunzq.mall.mbg.mapper.PmsBrandMapper;
import com.sunzq.mall.mbg.model.PmsBrandExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallApplicationTests {
    @Autowired
    private PmsBrandMapper brandMapper;
    @Test
    void listBrand(){
        System.out.println(brandMapper.selectByExample(new PmsBrandExample())+"test");
    }

}
