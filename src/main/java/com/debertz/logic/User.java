package com.debertz.logic;

/**
 * Created by eluppol on 17.12.13.
 */
public class User {
    private String name;

    public User(String name) {
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
