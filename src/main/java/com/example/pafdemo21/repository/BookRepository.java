package com.example.pafdemo21.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.pafdemo21.model.Book;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate template;

    // public void findBooksByTitle(String keyword) {

    //     String toSearch = "%" + keyword + "%";

    //     SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_TITLE, toSearch, 10, 0);
    //     while (rs.next()) {
    //         String book_id = rs.getString("book_id");
    //         String title = rs.getString("title");
    //         Float rating = rs.getFloat("rating");
    //         int pages = rs.getInt("pages");
    //         System.out.printf("%s: %s, pages: %d, rating: %.3f\n", book_id, title, pages, rating);
    //     }

    //     System.out.println("Query completed");
    // }

    // public void findBooksByRating(String keyword, int rate) {

    //     SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_FORMAT_AND_RATING, keyword, rate);
    //     while (rs.next()) {
    //         String book_id = rs.getString("book_id");
    //         String title = rs.getString("title");
    //         Float rating = rs.getFloat("rating");
    //         int pages = rs.getInt("pages");
    //         System.out.printf("%s: %s, pages: %d, rating: %.3f\n", book_id, title, pages, rating);
    //     }

    //     System.out.println("Query completed");
    // }

    public List<Book> getAllBooks() {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_ALL_BOOKS);
        List<Book> books = new ArrayList<>();

        while (rs.next()) {
            books.add(new Book(
                    rs.getString("book_id"),
                    rs.getString("title"),
                    rs.getString("authors"),
                    rs.getString("description"),
                    rs.getString("format"),
                    rs.getInt("pages"),
                    rs.getFloat("rating"),
                    rs.getString("genres"),
                    rs.getString("image_url")));
        }

        return books;
    }

    public Book findBookById(String id) {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_ID, id);

        if (rs.next()) {
            return new Book(
                    rs.getString("book_id"),
                    rs.getString("title"),
                    rs.getString("authors"),
                    rs.getString("description"),
                    rs.getString("format"),
                    rs.getInt("pages"),
                    rs.getFloat("rating"),
                    rs.getString("genres"),
                    rs.getString("image_url"));
        }

        return null;
    }

    public Integer getCount() {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_TOTAL_COUNT);
        rs.next();
        return rs.getInt("total");
    }

    public List<Book> getBooksByPage(Integer page) {

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_PAGE, page);
        List<Book> books = new ArrayList<>();

        while (rs.next()) {
            books.add(new Book(
                    rs.getString("book_id"),
                    rs.getString("title"),
                    rs.getString("authors"),
                    rs.getString("description"),
                    rs.getString("format"),
                    rs.getInt("pages"),
                    rs.getFloat("rating"),
                    rs.getString("genres"),
                    rs.getString("image_url")));
        }

        return books;
    }
}
