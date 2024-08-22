package com.tyz.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Dailyfundnav;

/**
* @author tangyizuo
* @description 针对表【dailyfundnav】的数据库操作Service
* @createDate 2024-08-19 17:41:55
*/
public interface DailyfundnavService extends IService<Dailyfundnav> {

    Dailyfundnav getDailynav(Dailyfundnav dailyfundnav);
}
