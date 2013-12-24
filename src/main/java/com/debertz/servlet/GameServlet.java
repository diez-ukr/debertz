package com.debertz.servlet;

import com.debertz.logic.DebertzGameRound;
import com.debertz.logic.TablePool;
import com.debertz.logic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sholtun on 24.12.13.
 */
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("more") != null){

        }
        else if (req.getParameter("enough") != null){

        }
        else {

            User user = (User)req.getSession().getAttribute(AttributeNames.USER_PARAM);
            DebertzGameRound round = TablePool.get(user).getCurrentGame().getCurrentRound();
            String action = (String)req.getAttribute("action");
            if (round.getTurn().getPlayerName().equals(user.getName())) {
                if (action.equals("more")) {
                    round.next();
                } else if (action.equals("enough")) {
                    round.stop();
                }
            }

            req.setAttribute("cards", round.getPlayersHand(user.getName()));
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
    }
}
