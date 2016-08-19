package com.github.yuriy27.lib.beans;

/**
 * Created by Юра on 14.08.2016.
 */
public class Genre {

    private String name;
    private long id;

    public Genre(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
