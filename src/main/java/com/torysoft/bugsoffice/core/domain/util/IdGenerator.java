package com.torysoft.bugsoffice.core.domain.util;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class IdGenerator implements IdentifierGenerator, Configurable{
	
	String prifix = "DEFAULT";
	
	public static final String PREFIX = "PREFIX"; 

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		
		return prifix + DateFormatUtils.format(new Date(), "yyMMddHH") + RandomStringUtils.randomNumeric(3);
	}

	@Override
	public void configure(Type type, Properties params, Dialect d) throws MappingException {
		prifix = (String) params.get(PREFIX);
	}
}
