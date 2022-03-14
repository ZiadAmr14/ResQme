package com.example.ResQmeAdmin.Repository;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class Firebase {
    @PostConstruct
    public void initialize() throws IOException {
        ClassLoader classLoader = Firebase.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("service-account-file.json")).getFile());
        FileInputStream serviceAccount =
                new FileInputStream(file.getAbsolutePath());

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://resqme-60664-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("restricted_access/secret_document");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object document = dataSnapshot.getValue();
                System.out.println(document);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

}
