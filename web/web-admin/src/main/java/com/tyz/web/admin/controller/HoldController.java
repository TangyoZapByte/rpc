package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Hold;
import com.tyz.web.admin.service.HoldService;
import com.tyz.web.admin.vo.HoldVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hold")
public class HoldController {

    @Autowired
    private HoldService holdService;

    @GetMapping("/query")
    public Result<Hold> queryFundShare(@RequestParam Long accountId, @RequestParam Long fundId){
        HoldVo holdVo = new HoldVo();
        holdVo.setAccountId(accountId);
        holdVo.setFundId(fundId);
        Hold hold = holdService.selectFundShareByAccountAndFundId(holdVo);
        if (hold == null) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "未找到该账户的持有份额信息");
        }
        return Result.ok(hold);
    }

    @PostMapping("/update")
    public Result updateInformation(@RequestBody Hold hold){
        holdService.saveOrUpdate(hold);
        return Result.ok();
    }

}
