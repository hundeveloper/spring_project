package com.customer.service;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public CustomerVO getCustomerInfo(int id) {
        return customerDAO.selectCustomer(id);
    }

    @Override
    public List<CustomerVO> getAllCustomerList() {
        return customerDAO.selectAllCustomer();
    }

    @Override
    public void insertCustomer(CustomerVO customer) {
        customerDAO.insertCustomer(customer);
    }
}
