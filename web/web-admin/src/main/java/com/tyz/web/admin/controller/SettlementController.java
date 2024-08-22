package com.tyz.web.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyz.common.result.Result;
import com.tyz.model.entity.Settlement;
import com.tyz.web.admin.service.SettlementService;
import com.tyz.web.admin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settlement")
public class SettlementController {

    @Autowired
    private TransactionService transactionService;


    //申购或赎回订单
    @GetMapping("/order")
    public Result<IPage<Settlement>> settlementSubscriptionOrRedemption(@RequestParam long current, @RequestParam long size,Long id){
        IPage<Settlement> page = new Page<>(current,size);
        IPage<Settlement> result = transactionService.settlementSubscriptionOrRedemption(page,id);
        return Result.ok(result);
    }
}
