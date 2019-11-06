package com.offcn.cust.mapper;

import com.offcn.cust.bean.Customer;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerMapper {

    List<Customer> getAllCust();

    void add(Customer customer);

    Customer getCustomer(Integer id);

    Customer edit1(Integer id);

    void edit(Customer customer);

    void delete(List list);

    List<Customer> selectByComname(String key);
    List<Customer> selectByComname1(String key);

    List<Customer> selectAll(String keyword);
}
