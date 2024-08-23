package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Dailyfundnav;
import com.tyz.web.admin.service.DailyfundnavService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/queryPreviousDayNav")
    public Result<List<Dailyfundnav>> queryPreviousDayNav(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        Date previousDay = cal.getTime();
        List<Dailyfundnav> list = dailyfundnavService.listByDate(previousDay);
        return Result.ok(list);
    }

    @PostMapping("/updateFundNav")
    public Result updateFundNav(@RequestBody List<Dailyfundnav> dailyfundnavs){
        for(Dailyfundnav dailyfundnav:dailyfundnavs){
            dailyfundnavService.saveOrUpdate(dailyfundnav);
        }
        return Result.ok();
    }
}
