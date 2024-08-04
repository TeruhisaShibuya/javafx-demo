package com.example.fx_spring_demo.service;

import com.example.fx_spring_demo.domain.Customer;
import com.example.fx_spring_demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 会員サービス 実装
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById() {
        return Optional.empty();
    }

    @Override
    public List<Customer> findByName() {
        return null;
    }

    /**
     * 会員情報の登録
     *
     * @param customer 会員情報
     * @return 登録された会員情報
     */
    @Override
    @Transactional
    public Customer entry(Customer customer) {

        // 新規登録処理を実行
        customer = customerRepository.save(customer);

        logger.info("会員情報登録完了 ID: `{}`, お名前: `{}` ",
                customer.getId(), customer.getName());

        return customer;
    }
}
