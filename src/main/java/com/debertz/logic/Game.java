package com.debertz.logic;

import com.debertz.dao.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by eluppol on 17.12.13.
 */
public class Game {
    private CopyOnWriteArrayList<User> users;
    private HashMap<User, Integer> points;
    private TableParams params;
    private DebertzGameRound currentRound;
    private ArrayList<DebertzGameRound> rounds = new ArrayList<DebertzGameRound>();

    public Game(CopyOnWriteArrayList<User> players, TableParams params) {
        this.params = params;
        this.users = players;
        for (User user : players) {
            points.put(user, 0);
        }
    }

    public DebertzGameRound nextRound() throws PlayersCountException {
        DebertzGamePlayer[] players = new DebertzGamePlayer[users.size()];
        for (int i=0; i<players.length;i++) {
            players[i] = new DebertzGamePlayer(users.get(i));
        }
        currentRound = new DebertzGameRound(players);
        return currentRound;
    }

    public DebertzGameRound getCurrentRound() {
        return currentRound;
    }

    public boolean finishRound(DebertzGameRound round) {
        for (DebertzGamePlayer player : round.debertzGamePlayers) {
            User user = Users.getUser(player.getPlayerName());
            points.put(user, points.get(user) + player.getScore());
        }
        return rounds.add(round);
    }
    public User getWinner() {
        User winner = null;
        for (User user : users) {
            if (points.get(user) >= params.getMaxPoints() && (!(winner == null) || points.get(user) > points.get(winner))) {
                winner = user;
            }
        }
        return winner;
    }

    public boolean gameFinished() {
        return getWinner() != null;
    }
}
