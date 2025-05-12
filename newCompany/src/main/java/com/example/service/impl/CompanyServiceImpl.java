package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dto.CompanyQueryDTO;
import com.example.entity.Company;
import com.example.mapper.CompanyMapper;
import com.example.service.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Override
    public boolean saveCompany(Company company) {
        return save(company);
    }

    @Override
    public boolean updateCompany(Company company) {
        return updateById(company);
    }

    @Override
    public List<Company> queryByCondition(CompanyQueryDTO queryDTO) {
        LambdaQueryWrapper<Company> wrapper = buildQueryWrapper(queryDTO);
        return list(wrapper);
    }

    @Override
    public IPage<Company> queryByConditionWithPage(CompanyQueryDTO queryDTO) {
        Page<Company> page = new Page<>(queryDTO.getCurrent(), queryDTO.getSize());
        LambdaQueryWrapper<Company> wrapper = buildQueryWrapper(queryDTO);
        return page(page, wrapper);
    }

    private LambdaQueryWrapper<Company> buildQueryWrapper(CompanyQueryDTO queryDTO) {
        LambdaQueryWrapper<Company> wrapper = new LambdaQueryWrapper<>();

        // 企业名称模糊查询
        if (StringUtils.isNotBlank(queryDTO.getName())) {
            wrapper.like(Company::getCompanyName, queryDTO.getName());
        }

        // 资金范围查询
        if (queryDTO.getMinMoney() != null) {
            wrapper.ge(Company::getMoney, queryDTO.getMinMoney());
        }
        if (queryDTO.getMaxMoney() != null) {
            wrapper.le(Company::getMoney, queryDTO.getMaxMoney());
        }

        // 可以添加更多条件...

        return wrapper;
    }

}