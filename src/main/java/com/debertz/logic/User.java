package com.debertz.logic;

import com.mongodb.ReflectionDBObject;

/**
 * Created by eluppol on 17.12.13.
 */
public class User extends ReflectionDBObject {
    private String name;

    private Table table;

    public User(String name) {
        this.name = name;
    }

    public Table getTable() {
        return table;
    }

    public boolean leave() {
        if (table != null) {
            boolean result = table.leave(this);
            if (result) {
                table = null;
            }
            return result;
        }
        return false;
    }

    public boolean join(Table newTable) {
        if (table == null) {
            boolean result = newTable.join(this);
            if (result) {
                table = newTable;
            }
            return result;
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
     return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return this.name == ((User)obj).getName();
    }
}
