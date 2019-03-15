package com.valentinaitken.test.dto;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonAutoDetect(fieldVisibility = ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@Accessors(fluent = true)
@ToString
@SuppressWarnings("checkstyle:MagicNumber")
public class AlignDateTimeDTO {
  
  private Long id;
  private LocalDateTime localDateTime;
  private ZonedDateTime zonedDateTime;
  private ZonedDateTime zonedDateTimeWithTz;
  private Date utilDate;

  private Instant instant;
  private Instant instantWithTz;

}
