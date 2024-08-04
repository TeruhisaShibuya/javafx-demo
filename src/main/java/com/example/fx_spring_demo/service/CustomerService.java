package com.example.fx_spring_demo.service;

import com.example.fx_spring_demo.domain.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 会員 サービス
 */
public interface CustomerService {

    public List<Customer> findAll();

    public Optional<Customer> findById();

    public List<Customer> findByName();

    public Customer entry(Customer customer);

}
