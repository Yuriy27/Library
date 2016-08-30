package com.github.yuriy27.lib.servlets;

import com.github.yuriy27.lib.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/bookpdf")
public class ShowPdf extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        ArrayList<Book> list = (ArrayList<Book>) request.getSession(false).getAttribute("currentBookList");
        int index = Integer.valueOf(request.getParameter("index"));
        Book book = list.get(index);
        book.loadContent();
        byte[] content = book.getContent();
        response.setContentLength(content.length);
        out.write(content);
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
