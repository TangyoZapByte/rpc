package com.tyz.web.admin.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionVo {
    private Long TransactionId;

    private Long CustomerId;

    private Long CustomerIdCard;

    private Long AccountId;

    private Long FundId;

    private Long TransactionType;

    private Long TransactionState;

    private Date TransactionDate;
}
