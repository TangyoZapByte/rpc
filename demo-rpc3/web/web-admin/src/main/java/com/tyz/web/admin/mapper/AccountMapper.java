package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyz.model.entity.Account;

public interface AccountMapper extends BaseMapper<Account> {
    IPage<Account> pageAccountByCustomerId(IPage<Account> page, Long customerId);
}
