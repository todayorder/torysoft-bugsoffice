package com.torysoft.bugsoffice.common.domain;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.torysoft.bugsoffice.common.code.YON;
import com.torysoft.bugsoffice.core.user.domain.User;

import lombok.Data;

@MappedSuperclass
@Data
public class DefaultDomain{
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date saveTime;
	
	@OneToOne
	@JoinColumn(name = "saveUser")
	private User saveUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	
	@OneToOne
	@JoinColumn(name = "updateUser")
	private User updateUser;
	
	@Enumerated(EnumType.STRING)
	private YON isDeleted;
}
