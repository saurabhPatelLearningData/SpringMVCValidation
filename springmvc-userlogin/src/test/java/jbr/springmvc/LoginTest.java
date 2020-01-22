package jbr.springmvc;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.controller.LoginController;
import jbr.springmvc.model.Login;
import jbr.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:jbr/config/user-beans.xml" })
public class LoginTest {
	

	@Autowired
	private UserService userService;
	
	LoginController loginController = new LoginController();

	@Test
	public void testShowLogin() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		ModelAndView model = loginController.showLogin(request, response);
		assertEquals("login", model.getViewName());
	}

	@Test
	public void testLoginProcess() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		Login login = new Login();
		login.setUsername("sushmita");
		login.setPassword("sushmita");
		ModelAndView model = loginController.loginProcess(request, response, login);
		assertEquals("welcome", model.getViewName());
		
	}

}
