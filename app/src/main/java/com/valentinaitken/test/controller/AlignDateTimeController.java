package com.valentinaitken.test.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.valentinaitken.test.dto.AlignDateTimeDTO;
import com.valentinaitken.test.service.AlignDateTimeService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/int/alignDateTime", produces = APPLICATION_JSON_VALUE)
@Api(tags = {"100. AlignDateTime"})
@SuppressWarnings("checkstyle:MagicNumber")
public class AlignDateTimeController {
  
  @Autowired
  private AlignDateTimeService alignDataTimeService;

  @PostMapping("/now")
  @ResponseBody
  @ResponseStatus(code = CREATED)
  public AlignDateTimeDTO createNow() {
    return alignDataTimeService.createNow();
  }

  @PostMapping
  @ResponseBody
  @ResponseStatus(code = CREATED)
  public AlignDateTimeDTO create(@Valid @RequestBody final AlignDateTimeDTO alignDataTimeDTO) {
    return alignDataTimeService.create(alignDataTimeDTO);
  }

  @GetMapping("/{id}")
  @ResponseBody
  @ResponseStatus(code = OK)
  public AlignDateTimeDTO findById(@PathVariable final Long id) {
    return alignDataTimeService.findById(id);
  }

  @GetMapping
  @ResponseBody
  @ResponseStatus(code = OK)
  public List<AlignDateTimeDTO> findAll() {
    return alignDataTimeService.findAll();
  }

}
