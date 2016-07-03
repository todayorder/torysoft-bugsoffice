package com.torysoft.bugsoffice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.torysoft.bugsoffice.core.domain.Code;

public interface CodeRepository extends JpaRepository<Code, String>, QueryDslPredicateExecutor<Code> {

}
