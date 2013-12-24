package com.debertz.servlet;

import com.debertz.logic.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sholtun on 22.12.13.
 */
public class TableListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(long tableId: TablePool.getAll()){
            Table table = TablePool.get(tableId);
            req.setAttribute("tableId", table.get_id());
            req.setAttribute("users", table.toString());
            req.setAttribute("params", table.getParams().toString());
            getServletContext().getRequestDispatcher("/templates/tableRow.jsp").include(req, resp);
        }
    }
}
