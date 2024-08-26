package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Creditcard;
import com.tyz.web.admin.service.CreditcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditcard")
public class CreditcardController {
    @Autowired
    private CreditcardService creditcardService;

    @GetMapping("/balance")
    public Result<Creditcard> balance(
            @RequestParam("account_id") String accountId,
            @RequestParam("card_number") String cardNumber) {
        Creditcard creditcard = new Creditcard();
        creditcard.setAccountId(Integer.valueOf(accountId));
        creditcard.setCreditcardId(cardNumber);
        Creditcard creditcard1 = creditcardService.getOneByCardNumberAndAccountId(creditcard);
        if (creditcard1 != null) {
            return Result.ok(creditcard1);
        } else {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "找不到银行卡");
        }
    }

    @PostMapping("/update")
    public Result updateCreditcard(@RequestBody Creditcard creditcard){
        creditcardService.saveOrUpdate(creditcard);
        return Result.ok();
    }
}
