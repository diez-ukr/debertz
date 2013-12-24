package com.debertz.servlet;

import com.debertz.logic.Table;
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
public class PlayerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userCurrent = (User)req.getSession().getAttribute(AttributeNames.USER_PARAM);
        Table tableCurrent = TablePool.get(userCurrent);
        for(User user: tableCurrent.getPlayers()){
            req.setAttribute(AttributeNames.NAME_PARAM, user.getName());
            getServletContext().getRequestDispatcher("/templates/tablePlayer.jsp").include(req, resp);
        }
    }
}
