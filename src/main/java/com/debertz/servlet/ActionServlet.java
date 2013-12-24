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
public class ActionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User)req.getSession().getAttribute(AttributeNames.USER_PARAM);
        DebertzGameRound round = TablePool.get(user).getCurrentGame().getCurrentRound();
        String action = (String)req.getAttribute("action");
        if (round.getTurn().getPlayerName().equals(user.getName())) {
            if (action.equals("next")) {
                round.next();
            } else if (action.equals("stop")) {
                round.stop();
            }
        }
        getServletContext().getRequestDispatcher("/gameround.jsp");
    }
}
