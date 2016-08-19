package com.github.yuriy27.lib.servlets;

import com.github.yuriy27.lib.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Юра on 19.08.2016.
 */
@WebServlet(name = "ShowImage")
public class ShowImage extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        try {
            int index = Integer.valueOf(request.getParameter("index"));
            ArrayList<Book> books = (ArrayList<Book>) request.getSession(false).getAttribute("currentBookList");
            Book book = books.get(index);
            byte[] image = book.getImage();
            response.setContentLength(image.length);
            out.write(image);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
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
