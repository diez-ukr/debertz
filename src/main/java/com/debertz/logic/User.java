package com.debertz.logic;

import com.mongodb.ReflectionDBObject;

/**
 * Created by eluppol on 17.12.13.
 */
public class User extends ReflectionDBObject {
    private String name;


    public User(String name) {
        this.name = name;
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
