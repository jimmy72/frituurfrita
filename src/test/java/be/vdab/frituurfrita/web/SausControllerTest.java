package be.vdab.frituurfrita.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrita.services.SausService;

@RunWith(MockitoJUnitRunner.class)
public class SausControllerTest {
	
	private SausController controller;
	@Mock
	private SausService sausService;
	
	@Before
	public void before() {
		controller = new SausController(sausService);
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
	
	@Test
	public void sauzenGeeftJuisteDataAanJSP() {
		assertTrue(controller.sauzen().getModel().containsKey("sauzen"));
		verify(sausService).findAll();
	}

}
