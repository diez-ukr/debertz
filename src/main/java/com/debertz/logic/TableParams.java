package com.debertz.logic;

/**
 * Created by eluppol on 22.12.13.
 */
public class TableParams {
    private int playersCount;

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

    private int maxPoints;
}
