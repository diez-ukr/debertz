package com.debertz.servlet;

import com.debertz.logic.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Sholtun on 23.12.13.
 */
public class TableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userCurrent = (User) session.getAttribute(AttributeNames.USER_PARAM);
        Table tableCurrent = TablePool.get(userCurrent);

        if (req.getParameter("join") != null) {
            if (tableCurrent != null){
                tableCurrent.leave(userCurrent);
                resp.sendRedirect("/main");
                return;
            }
            String tableID = req.getParameter(AttributeNames.TABLE_PARAM);
            Table tableSelected = TablePool.get(Integer.parseInt(tableID));
            tableSelected.join(userCurrent);
            resp.sendRedirect("/table");
        } else if (req.getParameter("startGame") != null) {
            try {
                tableCurrent.startGame().nextRound();
            } catch (PlayersCountException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("/game");
        } else if (req.getParameter("gameStatus") != null){
            if (tableCurrent.getCurrentGame() != null){
                resp.getWriter().append('1');
            }
            else{
                resp.getWriter().append('0');
            }
            return;
        } else {
            if (tableCurrent == null){
                getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
                return;
            }
            req.setAttribute(tableCurrent.getParams().toString(),
                    userCurrent.getName());
            getServletContext().getRequestDispatcher("/table.jsp").forward(req, resp);
        }
    }
}