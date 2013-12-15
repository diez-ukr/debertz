package com.debertz.dao;

import java.util.concurrent.BlockingDeque;

/**
 * Created by eluppol on 15.12.13.
 */
public class ConnectionPool {
    BlockingDeque<Connection> connections;
    private static Connection connection = new Connection("ds039507.mongolab.com", 39507, "worker", "qwerty12345");
    public static Connection getConnection() {
        return connection;
    }
}
