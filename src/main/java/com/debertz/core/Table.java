package com.debertz.core;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by eluppol on 17.12.13.
 */
public class Table {
    private int playersCount;
    private CopyOnWriteArrayList<User> players;
    public Table(int playersCount) {
        this.playersCount = playersCount;
        this.players = new CopyOnWriteArrayList<User>();
    }
    public synchronized boolean join(User player) {
        if (players.size() < playersCount) {
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
    public synchronized Game startGame() {
        return new Game(players);
    }
}
