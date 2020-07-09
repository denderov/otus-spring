package ru.otus.atheneum.service;

import java.util.List;
import java.util.Optional;
import ru.otus.domain.Author;
import ru.otus.domain.Book;
import ru.otus.domain.Genre;

public interface BookService {

  List<Book> getAll();

  Optional<Book> save(String title, Author author, Genre genre);

  BookService initBook();

  BookService setTitle(String bookTitle);

  BookService setAuthor(Author author);

  BookService setGenre(Genre genre);

  Optional<Book> createBook();
}
