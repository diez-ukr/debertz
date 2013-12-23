package com.debertz.dao;

import com.debertz.logic.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eluppol on 22.12.13.
 */
public class Tables {
    private static DBCollection collection = ConnectionPool.getConnection().getDB("debertz").getCollection("tables");
    public static void add(Table table) {
        //collection.insert(table);
        List players = new ArrayList();
        List users = table.getPlayers();
        for (int i=0;i<users.size();i++) {
            players.add(new BasicDBObject("name", users.get(i)));
        }
        collection.insert(new BasicDBObject("_id", table.getId()).append("players", players).
                append("creator", table.getCreator().getName()).
                append("params", new BasicDBObject("playersCount", table.getParams().getPlayersCount()).
                        append("maxPoints", table.getParams().getMaxPoints())));
    }

    public static Table get(long id) {
        List<DBObject> results = collection.find(new BasicDBObject("Id", id)).toArray();
        return (Table)results.get(0);
    }

    public static void foo() {
    }
}
