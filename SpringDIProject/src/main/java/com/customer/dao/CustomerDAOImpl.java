package com.customer.dao;

import mylab.customer.vo.CustomerVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SqlSessionTemplate session;

    @Override
    public CustomerVO selectCustomer(int id) {
        return session.selectOne("customer.selectCustomer", id);
    }

    @Override
    public List<CustomerVO> selectAllCustomer() {
        return session.selectList("customer.selectAllCustomer");
    }

    @Override
    public void insertCustomer(CustomerVO customer) {
        session.insert("customer.insertCustomer", customer);
    }
}
