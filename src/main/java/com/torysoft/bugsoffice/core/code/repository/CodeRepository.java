package com.torysoft.bugsoffice.core.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.torysoft.bugsoffice.core.code.domain.Code;

public interface CodeRepository extends JpaRepository<Code, String>, QueryDslPredicateExecutor<Code> {

}
