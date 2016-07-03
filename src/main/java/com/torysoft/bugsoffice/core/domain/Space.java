package com.torysoft.bugsoffice.core.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.torysoft.bugsoffice.common.domain.DefaultDomain;
import com.torysoft.bugsoffice.common.utils.IdGenerator;
import com.torysoft.bugsoffice.core.code.SpaceType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Space extends DefaultDomain{

	@Id
	@GeneratedValue(generator = "spaceId")
	@GenericGenerator(name = "spaceId", strategy = "com.torysoft.bugsoffice.common.utils.IdGenerator", parameters = {
			@Parameter(name = IdGenerator.PREFIX, value = "SPACE") })
	private String spaceId;
	private String spaceName;
	private String spaceDesc;
	
	@Enumerated(EnumType.STRING)
	private SpaceType spaceType;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uuid")
	private User spaceOwner;
	
	@OneToMany(mappedBy = "space", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Project> projects;
	
	@OneToMany(mappedBy ="space", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Member> members;
}
