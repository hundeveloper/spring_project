package com.customer.dao;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerDAO {
    CustomerVO selectCustomer(int id);
    List<CustomerVO> selectAllCustomer();
    void insertCustomer(CustomerVO customer);
}
