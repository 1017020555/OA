package com.offcn.cust.service;

import com.offcn.cust.bean.Customer;
import com.offcn.cust.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper mapper;

    public List<Customer> getAllCust() {
        return mapper.getAllCust();
    }

    public void add(Customer customer) {
        customer.setAddtime(new Date());
        mapper.add(customer);
    }

    public Customer getCustomer(Integer integer) {
        return mapper.getCustomer(integer);
    }

    public Customer edit1(Integer integer) {
        return mapper.edit1(integer);
    }

    public void edit(Customer customer) {
        mapper.edit(customer);
    }

    public void delete(String ids) {
        String[] id = ids.split(",");
        List<String> list = Arrays.asList(id);

        mapper.delete(list);
    }

    public List<Customer> search(Integer cid, String keyword, Integer orderby) {

      List<Customer> lists=null;
        if (cid==0){
            lists=mapper.selectAll("%"+keyword+"%");
        }else if (cid==1){
            if (orderby==0){
                lists=mapper.selectByComname1("%"+keyword+"%");
            }
            if (orderby==1){
                lists=mapper.selectByComname("%"+keyword+"%");
            }
        }

        return lists;
    }
}
