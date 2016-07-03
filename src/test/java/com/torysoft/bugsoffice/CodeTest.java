package com.torysoft.bugsoffice;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.torysoft.bugsoffice.core.code.domain.Code;
import com.torysoft.bugsoffice.core.code.repository.CodeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class CodeTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CodeTest.class);

	@Autowired
	CodeRepository codeRepository;
	
	@Before
	public void before() {
		Code code = new Code();
		code.setCategory("category1");
		code.setCodeKey("codeKey");
		code.setCodeValue("codevalue");
		codeRepository.save(code);
	}
	
	@Test
	public void findCodeList() {
		List<Code> codeList = codeRepository.findAll();
		LOGGER.debug("code list: {}", codeList);
	}
}
