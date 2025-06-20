package com.onkar.ProLearn.service;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthService {
    public String registerUser(String email, String password) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);
        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        return userRecord.getUid();
    }

    public String loginUser(String email, String password) {
        // Firebase Authentication does not provide password validation on the backend.
        // Instead, it should be handled on the frontend using Firebase SDK.
        return "Login should be handled in the frontend using Firebase SDK.";
    }
}
