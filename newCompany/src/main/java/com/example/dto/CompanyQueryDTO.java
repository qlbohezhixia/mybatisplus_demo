package com.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyQueryDTO {


    private String name;
    private Double minMoney;
    private Double maxMoney;
    @ApiModelProperty(value = "当前页码", example = "1")
    private Integer current = 1;

    @ApiModelProperty(value = "每页显示数量", example = "10")
    private Integer size = 100;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(Double minMoney) {
        this.minMoney = minMoney;
    }

    public Double getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(Double maxMoney) {
        this.maxMoney = maxMoney;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
