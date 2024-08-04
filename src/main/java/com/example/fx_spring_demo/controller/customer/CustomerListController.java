package com.example.fx_spring_demo.controller.customer;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class CustomerListController {

    @FXML
    private ListView<String> customerListView;

    @FXML
    private TextField searchTextField;

    @FXML
    public void initialize() {
        // 初期化処理（例：リストビューの初期データを設定）
        customerListView.getItems().addAll("John Doe", "Jane Doe", "Alice Smith");
    }

    @FXML
    private void handleSearch() {
        // 検索ボタンのアクション
        String query = searchTextField.getText();
        System.out.println("Searching for: " + query);
        // 検索ロジックを実装
    }
}
