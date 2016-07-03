package com.torysoft.bugsoffice.core.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.torysoft.bugsoffice.common.utils.IdGenerator;
import com.torysoft.bugsoffice.core.code.TesterRole;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Tester extends Default{

	@Id
	@GeneratedValue(generator = "testerId")
	@GenericGenerator(name = "testerId", strategy = "com.torysoft.bugsoffice.common.utils.IdGenerator", parameters = {
			@Parameter(name = IdGenerator.PREFIX, value = "TESTER") })
	private String testerId;
	
	@Enumerated(EnumType.STRING)
	private TesterRole testerRole;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uuid")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "projectId")
	private Project project;
}
