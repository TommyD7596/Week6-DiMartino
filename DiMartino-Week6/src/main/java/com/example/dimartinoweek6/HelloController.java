package com.example.dimartinoweek6;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class SplashScreenApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Splash Screen
        Stage splashStage = new Stage();
        splashStage.initStyle(StageStyle.UNDECORATED);

        StackPane splashLayout = new StackPane();
        splashLayout.getChildren().add(new Label("Welcome to MyApp!"));
        Scene splashScene = new Scene(splashLayout, 400, 300);
        splashStage.setScene(splashScene);
        splashStage.show();

        // Pause and then load the main application
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            splashStage.hide();
            showMainStage();
        });
        pause.play();
    }

    private void showMainStage() {
        Stage mainStage = new Stage();
        BorderPane root = new BorderPane();

        // Create MenuBar
        MenuBar menuBar = createMenuBar(mainStage);

        root.setTop(menuBar);

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        mainStage.setTitle("JavaFX Application");
        mainStage.setScene(scene);
        mainStage.show();
    }

    private MenuBar createMenuBar(Stage mainStage) {
        Menu fileMenu = new Menu("File");
        MenuItem signInItem = new MenuItem("Sign In");
        MenuItem registerItem = new MenuItem("Register");

        signInItem.setOnAction(e -> showSignInForm(mainStage));
        registerItem.setOnAction(e -> showRegisterForm(mainStage));

        fileMenu.getItems().addAll(signInItem, registerItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

        return menuBar;
    }

    private void showSignInForm(Stage mainStage) {
        Stage signInStage = new Stage();
        signInStage.setTitle("Sign In");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Form elements
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Button signInButton = new Button("Sign In");

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(signInButton, 1, 2);

        signInButton.setOnAction(e -> {
            // Handle sign in logic
            signInStage.close();
        });

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        signInStage.setScene(scene);
        signInStage.show();
    }

    private void showRegisterForm(Stage mainStage) {
        Stage registerStage = new Stage();
        registerStage.setTitle("Register");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Form elements
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Button registerButton = new Button("Register");

        grid.add(userLabel, 0, 0);
        grid.add(userField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(registerButton, 1, 3);

        registerButton.setOnAction(e -> {
            // Handle registration logic
            registerStage.close();
        });

        Scene scene = new Scene(grid, 300, 250);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        registerStage.setScene(scene);
        registerStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}