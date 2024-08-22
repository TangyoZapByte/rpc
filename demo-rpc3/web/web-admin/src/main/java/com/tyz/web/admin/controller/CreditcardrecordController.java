package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Creditcardrecord;
import com.tyz.web.admin.service.CreditcardrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creditcardrecord")
public class CreditcardrecordController {
    @Autowired
    private CreditcardrecordService creditcardrecordService;

    @PostMapping("/update")
    public Result updateCreditcardrecord(@RequestBody Creditcardrecord creditcardrecord){
        creditcardrecordService.saveOrUpdate(creditcardrecord);
        return Result.ok();
    }

}
