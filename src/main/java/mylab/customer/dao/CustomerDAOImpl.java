package mylab.customer.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mylab.customer.vo.CustomerVO;

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
