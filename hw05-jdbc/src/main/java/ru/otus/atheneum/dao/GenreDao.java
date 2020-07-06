package ru.otus.atheneum.dao;

import java.util.List;
import java.util.Optional;
import ru.otus.domain.Genre;

public interface GenreDao {

  Optional<Genre> getById(long id);

  List<Genre> getAll();

  void insert(Genre genre);

  void deleteById(long id);

  List<Genre> getByNamePart(String genreName);

  Optional<Genre> insert(String name);
}
