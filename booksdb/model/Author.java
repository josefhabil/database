package com.example.databas_lab1.booksdb.model;

import java.util.Date;

public class Author {

    private final String name;
    private int authorID;
    private Date birthDate;

    public Author(String name, int authourID, Date birthDate) {
        this.name = name;
        this.authorID = authourID;
        this.birthDate = birthDate;
    }

    public int getAuthorID() {
        return authorID;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id:  " + authorID + " name: " + this.name + " Birth date: " + this.birthDate;
    }
}
