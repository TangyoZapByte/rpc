package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Dailyfundnav;
import com.tyz.web.admin.service.DailyfundnavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dailyfundnav")
public class DailyfundnavController {
    @Autowired
    private DailyfundnavService dailyfundnavService;

    @GetMapping("/get_dailynav")
    public Result<Dailyfundnav> getDailynav(@RequestParam Dailyfundnav dailyfundnav){
        Dailyfundnav dailyfundnav1 =  dailyfundnavService.getDailynav(dailyfundnav);
        return Result.ok(dailyfundnav1);
    }
}
