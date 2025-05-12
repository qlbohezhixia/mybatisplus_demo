package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface CompanyMapper extends BaseMapper<Company> {

    @Select("SELECT * FROM company WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Company> selectByName(String name);
}