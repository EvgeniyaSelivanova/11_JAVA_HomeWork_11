package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class FilmItem {
  private int id;
  private int filmId;
  private String filmName;
  private String genre;
  private String filmImage;
}
