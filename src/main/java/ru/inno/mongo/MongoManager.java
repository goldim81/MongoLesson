package ru.inno.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

public class MongoManager {
    private static MongoClient client;
    private static MongoDatabase db;

    public static void init() throws UnknownHostException {
        //соединение с аутентификацией
//        MongoCredential credential = MongoCredential.createCredential("admin", "testDB", "admin".toCharArray());
//        client = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));

        //соединение по умолчанию localhost:27017
        client = new MongoClient();
        db = client.getDatabase("testDB");
    }

    public static void insert() {
        MongoCollection dbCollection = db.getCollection("testc");
        Document dbObject = new Document();
        dbObject.put("name", "Sara Conor");
        dbObject.put("age", 30);
        dbCollection.insertOne(dbObject);
    }

    public static void update(String name, int age) {
        MongoCollection dbCollection = db.getCollection("testc");
        Document query = new Document();
        query.put("name", name);

        Document newValue = new Document();
        newValue.put("age", age);

        Document updateQuery = new Document();
        updateQuery.put("$set", newValue);

        dbCollection.updateOne(query, updateQuery);
    }

    public static void find(String name) {
        MongoCollection dbCollection = db.getCollection("testc");
        Document query = new Document();
        query.put("name", name);

        Collection<Document> cursor = dbCollection.find(query).into(new ArrayList<Document>());
        for (Document doc : cursor) {
            System.out.println(doc);
        }
    }

    public static void delete(String name) {
        MongoCollection dbCollection = db.getCollection("testc");
        Document query = new Document();
        query.put("name", name);
        dbCollection.deleteOne(query);
    }
}
