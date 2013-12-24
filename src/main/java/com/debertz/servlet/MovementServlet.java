package com.debertz.servlet;

import com.debertz.authorization.Authorization;
import com.debertz.logic.DebertzGameRound;
import com.debertz.logic.TablePool;
import com.debertz.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eluppol on 24.12.13.
 */
public class MovementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User)req.getSession().getAttribute(AttributeNames.USER_PARAM);
        int cardIndex = (Integer)req.getAttribute("index");
        DebertzGameRound round = TablePool.get(user).getCurrentGame().getCurrentRound();
        if (round.getTurn().getPlayerName().equals(user.getName())) {
            round.putCard(user.getName(), round.getTurn().hand.get(cardIndex));
        }
        getServletContext().getRequestDispatcher("/gameround.jsp");
    }
}
