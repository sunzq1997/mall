package com.sunzq.mall.controller;

import com.sunzq.mall.common.CommonResult;
import com.sunzq.mall.mbg.model.PmsBrand;
import com.sunzq.mall.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "PmsBrandController")
@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation("获取所有品牌列表")
    @GetMapping("/listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> listAllBrand(){
        List<PmsBrand> listAllBrand = brandService.listAllBrand();
        return CommonResult.success(listAllBrand);
    }

    @ApiOperation("通过id查询品牌")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<PmsBrand> getBrandById(@PathVariable long id){
        PmsBrand brand = brandService.getBrandById(id);
        return CommonResult.success(brand);
    }

    @ApiOperation("更新品牌")
    @PostMapping("/update")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody PmsBrand brand){
        int count = brandService.updateBrand(brand);
        if (count==1) {
            return CommonResult.success(brand);
        }else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("删除品牌")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public CommonResult delete(@PathVariable long id){
        int count = brandService.deleteBrand(id);
        if (count==1) {
            return CommonResult.success(id);
        }else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("获取品牌分页列表")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<PmsBrand>> list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        List<PmsBrand> listBrand = brandService.listBrand(pageNum,pageSize);
        return CommonResult.success(listBrand);
    }
}
