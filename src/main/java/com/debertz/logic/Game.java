package com.debertz.logic;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by eluppol on 17.12.13.
 */
public class Game {
    private CopyOnWriteArrayList<User> users;
    private CopyOnWriteArrayList<Team> teams;
    private TableParams params;
    private DebertzGameRound currentRound;
    private ArrayList<DebertzGameRound> rounds = new ArrayList<DebertzGameRound>();

    public Game(CopyOnWriteArrayList<User> players, TableParams params) {
        this.params = params;
        this.users = players;
        if (players.size() == 4) {
            teams.add(new Team(players.get(0), players.get(2)));
            teams.add(new Team(players.get(1), players.get(3)));
        } else {
            for (User player : players) {
                teams.add(new Team(player));
            }
        }
    }

    public DebertzGameRound nextRound() throws PlayersCountException, PlayerWithoutTeamException {
        DebertzGamePlayer[] players = new DebertzGamePlayer[users.size()];
        for (int i=0; i<players.length;i++) {
            players[i] = new DebertzGamePlayer(users.get(i), getUserTeam(users.get(i)));
        }
        currentRound = new DebertzGameRound(players);
        return currentRound;
    }

    public DebertzGameRound getCurrentRound() {
        return currentRound;
    }

    public Team getUserTeam(User user) throws PlayerWithoutTeamException {
        for (Team team : teams) {
            if (team.contains(user)) {
                return team;
            }
        }
        throw new PlayerWithoutTeamException("Player " + user + " doesn't belong to any team");
    }
    public boolean finishRound(DebertzGameRound round) {
        for (DebertzGamePlayer player : round.debertzGamePlayers) {
            player.getTeam().addPoints(player.getScore(round.getTrumpSuit()));
        }
        return rounds.add(round);
    }
    public Team getWinner() {
        Team winner = null;
        for (Team team : teams) {
            if (team.getPoints() >= params.getMaxPoints() && (!(winner == null) || team.getPoints() > winner.getPoints())) {
                winner = team;
            }
        }
        return winner;
    }

    public boolean gameFinished() {
        return getWinner() != null;
    }
}
