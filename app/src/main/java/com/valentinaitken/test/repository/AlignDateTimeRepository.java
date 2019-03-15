package com.valentinaitken.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valentinaitken.test.domain.AlignDateTime;


public interface AlignDateTimeRepository extends JpaRepository<AlignDateTime, Long> {

}
