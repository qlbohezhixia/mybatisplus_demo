package com.example.dto;

import lombok.Data;

@Data
public class CompanyDTO {
    private Integer id;
    private String companyName;
    private String address;
    private Double money;
}