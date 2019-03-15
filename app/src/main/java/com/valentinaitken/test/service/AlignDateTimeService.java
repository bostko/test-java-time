package com.valentinaitken.test.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.valentinaitken.test.domain.AlignDateTime;
import com.valentinaitken.test.dto.AlignDateTimeDTO;
import com.valentinaitken.test.repository.AlignDateTimeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AlignDateTimeService {
  
  @Autowired
  private ModelMapper modelMapper;
  
  @Autowired
  private AlignDateTimeRepository alignDataTimeRepository;
  
  public AlignDateTimeDTO createNow() {
    AlignDateTime alignDataTime = new AlignDateTime();
    alignDataTime.instantWithTz(Instant.now());
    alignDataTime.instant(Instant.now());
    alignDataTime.localDateTime(LocalDateTime.now());
    alignDataTime.utilDate(new Date());
    alignDataTime.zonedDateTime(ZonedDateTime.now());
    alignDataTime.zonedDateTimeWithTz(ZonedDateTime.now());
    alignDataTimeRepository.save(alignDataTime);
    return modelMapper.map(alignDataTime, AlignDateTimeDTO.class);
  }

  public AlignDateTimeDTO create(final AlignDateTimeDTO alignDataTimeDTO) {
    AlignDateTime alignDataTime = modelMapper.map(alignDataTimeDTO, AlignDateTime.class);
    alignDataTimeRepository.save(alignDataTime);
    return modelMapper.map(alignDataTime, AlignDateTimeDTO.class);
  }

  @Transactional(readOnly = true)
  public AlignDateTimeDTO findById(final Long id) {
    final AlignDateTime alignDataTime = alignDataTimeRepository.findById(id).orElse(null);
    return modelMapper.map(alignDataTime, AlignDateTimeDTO.class);
  }

  public List<AlignDateTimeDTO> findAll() {
    return alignDataTimeRepository.findAll().stream().map(a -> modelMapper.map(a, AlignDateTimeDTO.class)).collect(Collectors.toList());
  }
}
