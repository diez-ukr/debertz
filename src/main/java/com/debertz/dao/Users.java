package com.debertz.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.util.Random;

/**
 * Created by eluppol on 15.12.13.
 */
public class Users {
    private static DBCollection collection = ConnectionPool.getConnection().getDB("debertz").getCollection("users");
    public static synchronized boolean addUser(String name, String password) {
        if (!validateUser(name))
            return false;
        collection.insert(new BasicDBObject("name", name).append("password", password));
        return true;
    }
    public static synchronized String generateSID(String name, String password) {
        if (!validatePassword(name, password)) return "";
        Random rand = new Random(System.currentTimeMillis());
        String sid = Integer.toString(new Integer(rand.nextInt(1000000)).hashCode());
        collection.update(new BasicDBObject("name", name), new BasicDBObject("$set", new BasicDBObject("sid", sid)));
        return sid;
    }

    private static synchronized  boolean validateUser(String user) {
        DBCursor cursor = collection.find(new BasicDBObject("name", user));
	    return cursor.count() <= 0;
    }

    private static synchronized  boolean validatePassword(String user, String pass) {
        DBCursor cursor = collection.find(new BasicDBObject("name", user).append("password", pass));
	    return cursor.count() != 0;
    }
    public static synchronized  boolean validateSid(String user, String sid) {
        DBCursor cursor = collection.find(new BasicDBObject("name", user).append("password", sid));
	    return cursor.count() != 0;
    }
}
