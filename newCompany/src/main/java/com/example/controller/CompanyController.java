package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.R;
import com.example.dto.CompanyQueryDTO;
import com.example.entity.Company;
import com.example.service.ICompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "企业管理接口")
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    @ApiOperation("新增企业")
    @PostMapping
    public R<Boolean> save(@RequestBody Company company) {
        return R.success(companyService.saveCompany(company));
    }

    @ApiOperation("根据ID查询")
    @GetMapping("/{id}")
    public R<Company> getById(@PathVariable Integer id) {
        return R.success(companyService.getById(id));
    }

    @ApiOperation("条件查询")
    @GetMapping("/query")
    public R<List<Company>> query(CompanyQueryDTO queryDTO) {
        return R.success(companyService.queryByCondition(queryDTO));
    }

    @ApiOperation("条件分页查询")
    @GetMapping("/page")
    public R<IPage<Company>> queryPage(CompanyQueryDTO queryDTO) {
        return R.success(companyService.queryByConditionWithPage(queryDTO));
    }

    @ApiOperation("更新企业信息")
    @PutMapping
    public R<Boolean> update(@RequestBody Company company) {
        return R.success(companyService.updateCompany(company));
    }

    @ApiOperation("删除企业")
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        return R.success(companyService.removeById(id));
    }
}
