package com.debertz.dao;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by eluppol on 15.12.13.
 */
public class ConnectionPool {
    CopyOnWriteArrayList<Connection> connections;
    private static Connection connection = new Connection("ds039507.mongolab.com", 39507, "worker", "qwerty12345");
    public static Connection getConnection() {
        return connection;
    }
}
