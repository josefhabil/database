package com.example.databas_lab1.booksdb.model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Representation of a book.
 *
 * @author anderslm@kth.se
 */
public class Book {

    private int bookId;
    private String isbn; // should check format
    private String title;
    private Date published;
    private String storyLine = "";
    private ArrayList<Author> authors;
    // TODO:
    // Add authors, as a separate class(!), and corresponding methods, to your implementation
    // as well, i.e. "private ArrayList<Author> authors;"

    public Book(int bookId, String isbn, String title, Date published) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.published = published;
        authors = new ArrayList<>();
    }

    public Book(String isbn, String title, Date published) {
        this(-1, isbn, title, published);
    }

    public int getBookId() { return bookId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public Date getPublished() { return published; }
    public String getStoryLine() { return storyLine; }


    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

    @Override
    public String toString() {
        return title + ", " + isbn + ", " + published.toString();
    }
}