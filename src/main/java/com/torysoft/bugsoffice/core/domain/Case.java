package com.torysoft.bugsoffice.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.torysoft.bugsoffice.common.utils.IdGenerator;
import com.torysoft.bugsoffice.core.code.TestResultType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Case extends Default{
	
	@Id
	@GeneratedValue(generator = "caseId")
	@GenericGenerator(name = "caseId", strategy = "com.torysoft.bugsoffice.common.utils.IdGenerator", parameters = {
			@Parameter(name = IdGenerator.PREFIX, value = "CASEID") })
	private String caseId;
	
	private String caseName;
	private String preCondition;
	private String caseContent;
	private String expectResult;
	
	@Lob
	private String resultComment;
	
	@Enumerated(EnumType.STRING)
	private TestResultType result;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "testerId")
	private Tester tester;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "releaseId")
	private Release release;

}
