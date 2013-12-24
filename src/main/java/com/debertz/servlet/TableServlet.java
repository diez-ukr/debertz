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
    private static final String CMD_EXIT = "exit";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tableId = req.getParameter(AttributeNames.TABLE_PARAM);
        Table table = TablePool.get(Integer.parseInt(tableId));
        HttpSession session = req.getSession();
        req.setAttribute(AttributeNames.TABLE_PARAM,
                session.getAttribute(AttributeNames.USER_PARAM));
        getServletContext().getRequestDispatcher("/table.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Table tableCurrent = (Table)session.getAttribute(AttributeNames.TABLE_PARAM);
        User userCurrent = (User)session.getAttribute(AttributeNames.USER_PARAM);

        if (req.getParameter("leave") != null){
            if (tableCurrent == null) return;
            tableCurrent.leave(userCurrent);
            resp.sendRedirect("/main");
        }
        else if (req.getParameter("join") != null){
            if (tableCurrent != null) return;
            String tableID = req.getParameter(AttributeNames.TABLE_PARAM);
            Table tableSelected = TablePool.get(Integer.parseInt(tableID));
            tableSelected.join(userCurrent);
            session.setAttribute(AttributeNames.TABLE_PARAM, tableSelected);
        }
        else if (req.getParameter("startGame") != null){

        }
        else {
            resp.sendRedirect("/main");
        }
    }
}
