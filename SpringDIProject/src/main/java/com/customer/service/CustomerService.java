package com.customer.service;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerService {
    CustomerVO getCustomerInfo(int id);
    List<CustomerVO> getAllCustomerList();
    void insertCustomer(CustomerVO customer);
}
