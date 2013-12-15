package com.debertz.dao;

import com.mongodb.*;

import java.util.Random;
import java.util.Set;

/**
 * Created by eluppol on 15.12.13.
 */
public class Users {
    private static DBCollection collection = ConnectionPull.getConnection().getDB("debertz").getCollection("users");
    public static synchronized boolean addUser(String name, String password) {
        if (!validateUser(name))
            return false;
        collection.insert(new BasicDBObject("name", name).append("password", password));
        return true;
    }
    public static synchronized String generateSID(String name, String password) {
        if (!validatePassword(name, password)) return "";
        Random rand = new Random(System.currentTimeMillis());
        String sid = new Integer(new Integer(rand.nextInt(1000000)).hashCode()).toString();
        collection.update(new BasicDBObject("name", name), new BasicDBObject("$set", new BasicDBObject("sid", sid)));
        return sid;
    }

    private static synchronized  boolean validateUser(String user) {
        DBCursor cursor = collection.find(new BasicDBObject("name", user));
        if (cursor.count() > 0)
            return false;
        return  true;
    }

    private static synchronized  boolean validatePassword(String user, String pass) {
        DBCursor cursor = collection.find(new BasicDBObject("name", user).append("password", pass));
        if (cursor.count() == 0)
            return false;
        return  true;
    }
    private static synchronized  boolean validateSid(String user, String sid) {
        DBCursor cursor = collection.find(new BasicDBObject("name", user).append("password", sid));
        if (cursor.count() == 0)
            return false;
        return  true;
    }
}
