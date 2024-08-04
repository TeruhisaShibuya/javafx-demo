package com.example.fx_spring_demo;

import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
//public class FxSpringDemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(FxSpringDemoApplication.class, args);
//	}
//}

@SpringBootApplication
public class FxSpringDemoApplication extends Application {

	private ConfigurableApplicationContext springContext;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		springContext = SpringApplication.run(FxSpringDemoApplication.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/customer/list.fxml"));
		loader.setControllerFactory(springContext::getBean);
		Parent root = loader.load();

		primaryStage.setTitle("Customer List");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	@Override
	public void stop() {
		springContext.close();
	}

}



// 以下 java-FXのウィンドウを、起動時に開くケースの記述
//public class FxSpringDemoApplication extends Application {

	//private static ApplicationContext context;

	//public static void main(String[] args) {
//		context = new SpringApplicationBuilder(Application.class).run(args);
//		launch(args);

//	}

//	@Override
//	public void start(Stage stage) throws Exception {
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/person_view.fxml"));
//		fxmlLoader.setControllerFactory(context::getBean);
//		Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//		stage.setTitle("JavaFX and Spring Boot");
//		stage.setScene(scene);
//		stage.show();
//	}
//}
