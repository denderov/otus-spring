package ru.otus.atheneum.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.TestHelper;
import ru.otus.common.IOService;

@SpringBootTest
@DisplayName("Класс AtheneumServiceImpl")
public class AtheneumServiceImplTest {

  @MockBean
  private IOService ioService;

  @MockBean
  private BookService bookService;

  @Autowired
  private AtheneumService atheneumService;

  @DisplayName("печатает список книг")
  @Test
  void shouldPrintAllBooks() {
    when(bookService.getAll()).thenReturn(TestHelper.BOOKS);
    atheneumService.printAllBooks();
    verify(ioService).println(
        "1. Book(id=1, title=Test_book_1, author=Author(id=101, fullName=Test_author_1), genre=Genre(id=201, name=Test_genre_1))\n"
            + "2. Book(id=2, title=Test_book_2, author=Author(id=102, fullName=Test_author_2), genre=Genre(id=202, name=Test_genre_2))");
  }

  @DisplayName("печатает список авторов")
  @Test
  void shouldPrintAllAuthors() {
    atheneumService.printAllAuthors();
    verify(ioService).println("1. Author(id=101, fullName=Test_author_1)\n"
        + "2. Author(id=102, fullName=Test_author_2)\n"
        + "3. Author(id=103, fullName=Test_author_3)");
  }

  @DisplayName("печатает список жанров")
  @Test
  void shouldPrintAllGenre() {
    atheneumService.printAllGenres();
    verify(ioService).println("1. Genre(id=201, name=Test_genre_1)\n"
        + "2. Genre(id=202, name=Test_genre_2)\n"
        + "3. Genre(id=203, name=Test_genre_3)");
  }

  @DisplayName("работает с полями встроенного в BookServiceImpl билдера книг")
  @Test
  void shouldSetBookBuilderFields() {
    atheneumService.setBookTitle(TestHelper.BOOK_TITLE_1);
    atheneumService.setBookAuthor(TestHelper.AUTHOR_1);
    atheneumService.setBookGenre(TestHelper.GENRE_1);
    assertAll(() -> verify(bookService).setTitle(TestHelper.BOOK_TITLE_1),
        () -> verify(bookService).setAuthor(TestHelper.AUTHOR_1),
        () -> verify(bookService).setGenre(TestHelper.GENRE_1));
  }

  @DisplayName("сохраняет книгу через фабрику")
  @Test
  void shouldSaveBook() {
    atheneumService.saveBook();
    verify(bookService).createBook();
  }
}
