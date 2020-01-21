package jbr.springmvc;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.controller.LoginController;
import jbr.springmvc.controller.RegistrationController;
import jbr.springmvc.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:jbr/config/user-beans.xml" })
public class RegistrationTest {
	
    
	RegistrationController registrationController = new RegistrationController();
	User user = new User();

	@Test
	public void testShowRegister() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		ModelAndView model = registrationController.showRegister(request, response);
		assertEquals("register", model.getViewName());
	}

	@Test
	public void testAddUser() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		user.setFirstname("Sushmita");
		ModelAndView model = registrationController.addUser(request, response,user);
		assertEquals("welcome", model.getViewName());
	}

}
