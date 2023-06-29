/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.professor.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class ConectDB {
    private static final String CONNECTION_STRING = "mongodb+srv://yeshua:yeshua@cluster0.zwf1ijm.mongodb.net/";

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    static MongoCollection<Document> collection;
    private static Gson gson;
    private static GsonBuilder gsonBuilder;
    private static Scanner scanner;
    
    public static void connectToDatabase() {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("University");
        collection = database.getCollection("Professors");
    }
}
