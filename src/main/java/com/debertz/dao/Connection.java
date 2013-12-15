package com.debertz.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by eluppol on 15.12.13.
 */
public class Connection {
    private MongoClient client;
    private String user;
    private String password;

    public Connection(String address, int port, String user, String password)
    {
        try {
            client = new MongoClient(address, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.user = user;
        this.password = password;
    }
    public DB getDB(String name) {
        DB tmp =  client.getDB(name);
        tmp.authenticate(user, password.toCharArray());
        return tmp;
    }
}
