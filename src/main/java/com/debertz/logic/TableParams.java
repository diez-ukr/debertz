package com.debertz.logic;

import com.mongodb.ReflectionDBObject;

/**
 * Created by eluppol on 22.12.13.
 */
public class TableParams extends ReflectionDBObject {
    private int playersCount;
    private int maxPoints;

    public TableParams(int playersCount, int maxPoints) {
        this.playersCount = playersCount;
        this.maxPoints = maxPoints;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    @Override
    public String toString() {
        return "Count of players: " + playersCount + "; Maximum points: " + maxPoints;
    }
}
