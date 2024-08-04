package com.example.fx_spring_demo.repository;

import com.example.fx_spring_demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 会員 リポジトリ
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    public List<Customer> findAll();

    @Override
    public Optional<Customer> findById(Long id);

    public List<Customer> findByName(String name);

}
