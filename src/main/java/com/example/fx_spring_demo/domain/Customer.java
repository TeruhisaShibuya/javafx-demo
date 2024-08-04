package com.example.fx_spring_demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 会員エンティティ
 *
 * CRUDテスト用の簡易的なエンティティ
 */
@Entity
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Customer {

    /** IDは自動生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /** テスト用に名前カラムを用意 */
    String name;
}
