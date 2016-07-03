package com.torysoft.bugsoffice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.torysoft.bugsoffice.core.domain.Case;

public interface CaseRepository extends JpaRepository<Case, String>, QueryDslPredicateExecutor<Case> {

}
