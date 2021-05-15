package ru.otus.h2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "GENRES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class H2Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private long id;

  @Column(name = "EXT_ID")
  private String extId;

  @Column(name = "NAME")
  private String name;
}
