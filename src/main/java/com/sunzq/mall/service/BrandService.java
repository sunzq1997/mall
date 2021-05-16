package com.sunzq.mall.service;

import com.sunzq.mall.mbg.model.PmsBrand;

import java.util.List;

public interface BrandService {
    List<PmsBrand> listAllBrand();
    PmsBrand getBrandById(long id);
    int createBrand(PmsBrand brand);
    int updateBrand(PmsBrand brand);
    int deleteBrand(long id);
    List<PmsBrand> listBrand(int pageNum,int pageSize);
}
