package com.example.pafdemo21.repository;

public class Queries {

    // public static final String SQL_SELECT_BOOK_BY_TITLE = """
    // select book_id, title, authors, description, pages, rating, image_url
    // from book2018
    // where title like ?
    // limit ?
    // offset ?
    // """;

    // public static final String SQL_SELECT_BOOK_BY_FORMAT_AND_RATING = """
    // select book_id, title, authors, description, pages, rating, image_url
    // from book2018
    // where format like ? and rating > ?
    // """;

    public static final String SQL_SELECT_ALL_BOOKS = """
            select *
            from book2018
            """;

    public static final String SQL_SELECT_BOOK_BY_ID = """
            select *
            from book2018
            where book_id = ?
            """;

    public static final String SQL_GET_TOTAL_COUNT = """
            select count(*)
            as total
            from book2018
            """;
}
