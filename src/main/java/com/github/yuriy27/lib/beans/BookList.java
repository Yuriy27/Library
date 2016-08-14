package com.github.yuriy27.lib.beans;

import java.util.ArrayList;

/**
 * Created by Юра on 14.08.2016.
 */
public class BookList {

    private ArrayList<Book> bookList;

    private static BookList instance;

    private BookList() {
        bookList = new ArrayList<Book>();
    }

    public static BookList getInstance() {
        if (instance == null)
            instance = new BookList();
        return instance;
    }



}
