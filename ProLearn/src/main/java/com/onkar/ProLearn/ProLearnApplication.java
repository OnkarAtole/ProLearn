  package com.onkar.ProLearn;

  import java.io.IOException;
  import java.io.InputStream;
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import com.google.auth.oauth2.GoogleCredentials;
  import com.google.firebase.FirebaseApp;
  import com.google.firebase.FirebaseOptions;
  import org.springframework.core.io.ClassPathResource;
  import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//  @SpringBootApplication
  @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
  public class ProLearnApplication {

      public static void main(String[] args) {
          SpringApplication.run(ProLearnApplication.class, args);
          initializeFirebase();
      }

      private static void initializeFirebase() {
          try {
              // Load the service account key JSON file from the classpath
              InputStream serviceAccount = new ClassPathResource("serviceAccountKey.json").getInputStream();

              // Initialize Firebase options
              FirebaseOptions options = FirebaseOptions.builder()
                  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                  .setDatabaseUrl("https://prolearn-5c636-default-rtdb.firebaseio.com")
                  .build();

              // Initialize the default Firebase app
              if (FirebaseApp.getApps().isEmpty()) {
                  FirebaseApp.initializeApp(options);
                  System.out.println("Firebase has been initialized successfully.");
              } else {
                  System.out.println("Firebase is already initialized.");
              }
          } catch (IOException e) {
              System.err.println("Failed to initialize Firebase: " + e.getMessage());
          }
      }
  }
