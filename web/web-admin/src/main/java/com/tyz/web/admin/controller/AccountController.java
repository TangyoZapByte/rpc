package com.tyz.web.admin.controller;


import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Account;
import com.tyz.web.admin.service.AccountService;
import com.tyz.web.admin.vo.CreateAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;



    @GetMapping("/query")
    public Result<List<String>> queryAccount(@RequestParam Integer accountId){
        List<String> cardNumbers = accountService.getCardNumbersByAccountId(accountId);
        if (cardNumbers == null || cardNumbers.isEmpty()) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "没有找到银行卡号");
        }
        return Result.ok(cardNumbers);
    }
}
