package com.valentinaitken.test.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Table
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@Accessors(fluent = true)
public class AlignDateTime implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GenericGenerator(name = "AlignDataTime",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
      @Parameter(name = "sequence_name", value = "align_data_time_seq"),
      @Parameter(name = "initial_value", value = "1"),
      @Parameter(name = "increment_size", value = "1")
    })
  @GeneratedValue(strategy = SEQUENCE, generator = "AlignDataTime")
  @Column(name = "id")
  private Long id;
  
  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private LocalDateTime localDateTime;
  
  @Column
  private ZonedDateTime zonedDateTime;

  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private ZonedDateTime zonedDateTimeWithTz;
  
  @Column
  private Date utilDate;

  @Column
  private Instant instant;

  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private Instant instantWithTz;

  @Version
  private Long version;
  
  @CreatedDate
  @Column
  protected Date createdDate;

  @LastModifiedDate
  @Column
  protected Date lastModifiedDate;
}
