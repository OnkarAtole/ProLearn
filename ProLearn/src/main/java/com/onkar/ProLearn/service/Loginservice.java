package com.onkar.ProLearn.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.onkar.ProLearn.model.Data;

@Service
public class Loginservice {
    
	public String createData(Data data) throws InterruptedException, ExecutionException {
        Firestore dbFireStore=FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture=dbFireStore.collection("User").document(data.getName()).set(data);
        return collectionsApiFuture.get().getUpdateTime().toString();   }

    public Data getData(String Name) throws InterruptedException, ExecutionException {
    	Firestore dbFireStore=FirestoreClient.getFirestore();
    	DocumentReference documentReference=dbFireStore.collection("User").document(Name);
    	ApiFuture<DocumentSnapshot> future=documentReference.get();
    	DocumentSnapshot document=future.get();
    	Data data;
    	if(document.exists()) {
    		data=document.toObject(Data.class);
    		return data;
    	}
        return null; // Replace with actual retrieval logic
    }

    public String updateData(Data data) {
        return "Data updated successfully";
    }

    public String deleteData(String Name) {
    	Firestore dbFireStore=FirestoreClient.getFirestore();
    	ApiFuture<WriteResult> writeResult=dbFireStore.collection("User").document(Name).delete();
        return "Data deleted successfully "+Name;
    }

}
