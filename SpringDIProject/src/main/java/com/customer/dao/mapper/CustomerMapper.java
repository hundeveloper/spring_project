package com.customer.dao.mapper;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerMapper {
    CustomerVO selectCustomer(int id);
    List<CustomerVO> selectAllCustomer();
    void insertCustomer(CustomerVO customer);
}
