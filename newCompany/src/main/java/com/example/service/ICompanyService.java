package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Company;
import com.example.dto.CompanyQueryDTO;
import java.util.List;

public interface ICompanyService extends IService<Company> {
    boolean saveCompany(Company company);

    boolean updateCompany(Company company);
    // 自定义业务方法
    List<Company> queryByCondition(CompanyQueryDTO queryDTO);
    IPage<Company> queryByConditionWithPage(CompanyQueryDTO queryDTO);


}
