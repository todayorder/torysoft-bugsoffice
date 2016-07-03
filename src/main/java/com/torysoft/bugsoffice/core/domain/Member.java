package com.torysoft.bugsoffice.core.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.torysoft.bugsoffice.core.code.MemberRole;
import com.torysoft.bugsoffice.core.domain.util.IdGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Member extends Default{
	
	@Id
	@GeneratedValue(generator = "memberId")
	@GenericGenerator(name = "memberId", strategy = "com.torysoft.bugsoffice.core.domain.util.IdGenerator", parameters = {
			@Parameter(name = IdGenerator.PREFIX, value = "MEMBER") })
	private String memberId;
	
	@Enumerated(EnumType.STRING)
	private MemberRole memberRole;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uuid")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "spaceId")
	private Space space;
	
}
