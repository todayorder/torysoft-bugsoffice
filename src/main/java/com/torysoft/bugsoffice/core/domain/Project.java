package com.torysoft.bugsoffice.core.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.torysoft.bugsoffice.core.domain.util.IdGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Project {
	
	@Id
	@GeneratedValue(generator = "projectId")
	@GenericGenerator(name = "projectId", strategy = "com.torysoft.bugsoffice.core.domain.util.IdGenerator", parameters = {
			@Parameter(name = IdGenerator.PREFIX, value = "PJT") })
	private String projectId;
	private String projectName;
	private String projectDesc;
	
	@OneToOne
	@JoinColumn(name = "uuid")
	private User projectOwner;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "spaceId")
	private Space space;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Tester> testers;

}
