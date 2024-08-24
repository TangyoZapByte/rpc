package com.tyz.web.admin.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyz.common.result.Result;
import com.tyz.model.entity.Settlement;
import com.tyz.model.entity.Transaction;
import com.tyz.web.admin.service.SettlementService;
import com.tyz.web.admin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/settlement")
public class SettlementController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private SettlementService settlementService;


    //申购或赎回订单
    @GetMapping("/order")
    public Result<IPage<Settlement>> settlementSubscriptionOrRedemption(@RequestParam long current, @RequestParam long size,Long id){
        IPage<Settlement> page = new Page<>(current,size);
        IPage<Settlement> result = transactionService.settlementSubscriptionOrRedemption(page,id);
        return Result.ok(result);
    }

    @PostMapping("/updateTransactionStateById")
    public Result updateTransactionStateById(List<Long> ids){
        for(Long id : ids){
            Long status = 1L;
            LambdaUpdateWrapper<Transaction> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(Transaction::getTransactionId,id);
            updateWrapper.set(Transaction::getTransactionState,status);
            transactionService.update(updateWrapper);
        }
        return Result.ok();
    }

    @GetMapping("/getSettlementInformation")
    public Result<List<Settlement>> getSettlementInformation(Date date){
        List<Settlement> list = settlementService.listSettlementByDate(date);
        return Result.ok(list);
    }
}
