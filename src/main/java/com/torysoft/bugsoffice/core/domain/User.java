package com.torysoft.bugsoffice.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.torysoft.bugsoffice.common.domain.DefaultDomain;
import com.torysoft.bugsoffice.common.utils.IdGenerator;
import com.torysoft.bugsoffice.core.code.UserType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends DefaultDomain {

	@Id
	@GeneratedValue(generator = "user-uuid")
	@GenericGenerator(name = "user-uuid", strategy = "com.torysoft.bugsoffice.common.utils.IdGenerator", parameters = {
			@Parameter(name = IdGenerator.PREFIX, value = "UUID") })
	private String uuid;
	private String userId;
	private String userName;
	private String password;
	private String email;
	private String gender;
	private Date birthday;
	private String photoUrl;
	@Enumerated(EnumType.STRING)
	private UserType userType;
	private String cellPhone;
	private String tel;
	private String postCode;
	private String addrMain;
	private String addrDetail;
}
