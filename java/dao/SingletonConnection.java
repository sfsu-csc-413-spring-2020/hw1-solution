package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class SingletonConnection {
    public static MongoClient mongoClient = new MongoClient("localhost", 27017);

}

