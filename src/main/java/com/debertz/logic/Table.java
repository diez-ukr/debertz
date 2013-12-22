package com.debertz.logic;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by eluppol on 17.12.13.
 */
public class Table {
    private TableParams params;
    private User creator;
    private long id;
    private CopyOnWriteArrayList<User> players;

    public TableParams getParams() {
        return params;
    }
    public long getId() {
        return id;
    }

    public Table(TableParams params, User creator, long id) {
        this.id = id;

        this.creator = creator;
        this.params = params;
        this.players = new CopyOnWriteArrayList<User>();
    }

    public User getCreator() {
        return creator;
    }

    public synchronized boolean join(User player) {
        if (players.size() < params.getPlayersCount()) {
            return players.add(player);
        }
        return false;
    }
    public synchronized boolean leave(User player) {
        if (players.contains(player)) {
            return players.remove(player);
        }
        return false;
    }

    public synchronized boolean ready() {
        return params.getPlayersCount() == players.size();
    }

    public synchronized Game startGame() {
        return new Game(players, params);
    }

    public void swapDown(User user) {
        int index = players.indexOf(user);
        if (index < players.size() - 1) {
            User tmp = players.get(index);
            players.set(index, players.get(index));
            players.set(index + 1, tmp);
        }
    }
    public User getUser(int index) {
        return players.get(index);
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
        return this.id == ((Table)obj).getId();
    }
}
