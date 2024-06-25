package com.example.dimartinoweek6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
        import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize Firebase
        initializeFirebase();

        // Other initialization code...

        // Add file upload button to the registration form
        Button uploadButton = new Button("Upload Profile Picture");
        uploadButton.setOnAction(e -> uploadProfilePicture(primaryStage));
        // Add this button to your form
    }

    private void initializeFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("your-bucket-name.appspot.com")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void uploadProfilePicture(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                String blobString = "profile_pictures/" + file.getName();
                StorageClient.getInstance().bucket().create(blobString, new FileInputStream(file), "image/jpeg");
                System.out.println("Uploaded to: " + blobString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}