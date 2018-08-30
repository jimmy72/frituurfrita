package be.vdab.frituurfrita.web;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class SausControllerTest {
	
	private SausController controller;
	
	@Before
	public void before() {
		controller = new SausController();
	}
	@Test
	public void sauzenWerktSamenMetJSPSauzen() {
		ModelAndView modelAndView = controller.sauzen();
		assertEquals("sauzen", modelAndView.getViewName());
	}
	
	@Test
	public void sauzenGeeftListDoorMetNaamSauzen() {
		ModelAndView modelAndView = controller.sauzen();
		assertTrue(modelAndView.getModel().containsKey("sauzen"));
	}

}
