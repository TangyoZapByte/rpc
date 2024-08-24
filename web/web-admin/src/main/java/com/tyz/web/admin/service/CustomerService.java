package com.tyz.web.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Customer;
import com.tyz.web.admin.vo.CustomerInfoVo;

public interface CustomerService extends IService<Customer> {
    Customer getOneByIdCard(Long customerIdCard);

    void selectOneByIdCardAndPhone(Customer customer);

    IPage<Customer> pageCustomerByQuery(IPage<Customer> page, Customer findCustomer);

    CustomerInfoVo getCustomerByAccountId(Integer accountId);
}
