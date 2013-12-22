package com.debertz.logic;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by eluppol on 21.12.13.
 */
public class Team {
    private CopyOnWriteArrayList<User> players = new CopyOnWriteArrayList<User>();
    private int points = 0;

    public Team(User... players) {
        for (User player : players) {
            this.players.add(player);
        }
    }
    public boolean contains(User user) {
        return players.contains(user);
    }
    public void addPoints(int amount) {
        points += amount;
    }

    public int getPoints() {
        return points;
    }

    public int size() {
        return players.size();
    }

    @Override
    public String toString() {
        String str = "";
        String before = "";
        for (User user : players) {
            str += before + user.getName();
            before = ", ";
        }
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Team other = (Team)obj;
        if (other.size() != size()) {
            return false;
        }

        for (int i=0; i < players.size();i++) {
            if (!players.get(i).equals(other.players.get(i))) {
                return false;
            }
        }
        return true;
    }
}
