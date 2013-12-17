package com.debertz.core;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by eluppol on 17.12.13.
 */
public class TablePool {
    private static CopyOnWriteArrayList<Table> tables = new CopyOnWriteArrayList<Table>();
    public static Table add(int playersCount) {
        Table table = new Table(playersCount);
        tables.add(table);
        return table;
    }
    public static boolean remove(Table table) {
        return tables.remove(table);
    }
}
