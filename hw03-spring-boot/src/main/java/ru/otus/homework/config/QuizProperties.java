package ru.otus.homework.config;

import java.util.Locale;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "quiz")
@Data
public class QuizProperties {

  int questionCount;
  int passPercent;
  Locale locale;
}
