package com.debertz.logic;

import com.debertz.dao.Users;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by eluppol on 17.12.13.
 */
public class TablePool {
//    private static Table deftable = makeTestTable();
//    private static Table makeTestTable() {
//        Table table = new Table(new TableParams(4, 1001), Users.getUser("eluppol"), -1);
//        table.join(Users.getUser("dima"));
//        table.join(Users.getUser("dimon"));
//        table.join(Users.getUser("diez"));
//        try {
//            table.getCurrentGame().nextRound();
//        } catch (PlayersCountException e) {
//            e.printStackTrace();
//        }
//        return table;
//    }

//    public static Table getTestTable() {
//        return deftable;
//    }

    private static CopyOnWriteArrayList<Table> tables = new CopyOnWriteArrayList<Table>();
    private static AtomicLong lastid = new AtomicLong(0);

    public static Table add(TableParams params, User creator) {
        Table table = new Table(params, creator, lastid.incrementAndGet());
        tables.add(table);
        return table;
    }
    public static boolean remove(Table table) {
        return tables.remove(table);
    }

    public static boolean remove(int id) {
        return tables.remove(tables.get(id));
    }

    public static Table get(long id) {
//        if (id == -1) {
//            return deftable;
//        }
        for (Table table : tables) {
            if (table.getId() == id) {
                return table;
            }
        }
        return null;
    }

    public static Table get(User user) {
        for (Table table : tables) {
            if (table.getPlayers().contains(user)) {
                return table;
            }
        }
        return null;
    }

    public static long[] getAll() {
        synchronized (tables) {
            long[] result = new long[tables.size()];
            for (int i=0; i < result.length; i++) {
                result[i] = tables.get(i).getId();
            }
            return result;
        }
    }
}
