package com.tyz.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionState implements BaseEnum{

    Transacting(0, "交易中"),
    NOT_Transacting(1, "已撤销");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    TransactionState(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
