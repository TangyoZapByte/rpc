package com.tyz.web.admin.controller;


import com.tyz.common.result.Result;
import com.tyz.model.entity.Sharerecord;
import com.tyz.web.admin.service.SharerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sharerecord")
public class SharerecordController {
    @Autowired
    private SharerecordService sharerecordService;

    @PostMapping("/update")
    public Result updateSharerecord(@RequestBody Sharerecord sharerecord){
        sharerecordService.saveOrUpdate(sharerecord);
        return Result.ok();
    }

}
