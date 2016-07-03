package com.torysoft.bugsoffice;

import java.util.Date;
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

import com.torysoft.bugsoffice.core.domain.User;
import com.torysoft.bugsoffice.core.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class UserTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);
	
	@Autowired
	UserRepository userRepository;
	
	
	@Before
	public void before() {
		
		User saveUser = new User();
		saveUser.setUserName("saveUser");
		saveUser = userRepository.save(saveUser);
		
		User updateUser = new User();
		updateUser.setUserName("updateUser");
		updateUser = userRepository.save(updateUser);
		
		for(int i=0; i < 5; i++){
			User user = new User();
//			user.setUserId("id");
//			user.setEmail("sdfd@naver.com");
			user.setUserName("user["+i+"]");
			user.setSaveUser(saveUser);
			user.setUpdateTime(new Date());
			user.setUpdateUser(updateUser);
			userRepository.save(user);
		}
		
	}
	
	@Test
	public void test() {
		List<User> userList = userRepository.findAll();
		LOGGER.debug("user list: {}", userList);
		
	}

}
