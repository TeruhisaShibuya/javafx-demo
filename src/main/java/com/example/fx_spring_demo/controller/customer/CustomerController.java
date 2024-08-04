package com.example.fx_spring_demo.controller.customer;


import com.example.fx_spring_demo.domain.Customer;
import com.example.fx_spring_demo.service.CustomerService;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX仕様のコントローラークラス
 * entry.fxml ファイルに対応
 *
 * FXのコントローラーを記述するときはViewファイルから書いてしまったほうが記述しやすい
 *
 */
public class CustomerController {

    /** 画面表示に必要な部品 (fx:id) 要素をフィールドとして用意する */

    /** 記述形式 Viewラベル名 値; */
    @FXML
    private TextField nameField;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, Long> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;


    // --

    /**
     * 会員データ格納に必要なオブジェクト
     */
    private final CustomerService customerService;
    private final ObservableList<Customer> customerList;


    /**
     * コンストラクタ
     *
     * @param customerService 会員サービス
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        this.customerList = FXCollections.observableArrayList();
    }


    /**
     * 画面表示の際に実行されるメソッド
     *
     */
    @FXML
    public void initialize() {

        // テーブルの値をセットする
        idColumn.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getId()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        customerTable.setItems(customerList);

        // ボタン類にアクションをセット
        addButton.setOnAction(e -> addPerson());
        updateButton.setOnAction(e -> updatePerson());
        deleteButton.setOnAction(e -> deletePerson());

        this.loadCustomer();
    }


    /**
     * 会員情報を全て取得
     */
    private void loadCustomer() {
        List<Customer> customers = customerService.findAll();
        customerList.setAll(customers);
    }


    /**
     * 会員情報の登録処理
     * 登録ボタン押下時に実行される処理
     */
    private void addPerson() {
        // フォームの入力値を取得する
        String name = nameField.getText();

        // エンティティをインスタンス化 entryメソッドの引数に渡す
        // CustomerFormクラスを用意しても良いかもしれない...
        Customer customer = new Customer();
        customer.setName(name);
        customerService.entry(customer);

        // 画面遷移処理は `FXMLLoader` クラスを使用する
        Stage stage = (Stage) addButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/customer/entry.fxml"));

        // 変数loaderを使用して画面遷移する
        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updatePerson() {
        // フォームの入力値を取得する
//        String name = nameField.getText();
//
//        // エンティティをインスタンス化 entryメソッドの引数に渡す
//        // CustomerFormクラスを用意しても良いかもしれない...
//        Customer customer = new Customer();
//        customer.setName(name);
//        customerService.entry(customer);
    }

    private void deletePerson() {
        // フォームの入力値を取得する
//        String name = nameField.getText();
//
//        // エンティティをインスタンス化 entryメソッドの引数に渡す
//        // CustomerFormクラスを用意しても良いかもしれない...
//        Customer customer = new Customer();
//        customer.setName(name);
//        customerService.entry(customer);

    }
}