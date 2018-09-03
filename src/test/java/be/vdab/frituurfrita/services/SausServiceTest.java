package be.vdab.frituurfrita.services;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.frituurfrita.entities.Saus;
import be.vdab.frituurfrita.repositories.SausRepository;

@RunWith(MockitoJUnitRunner.class)
public class SausServiceTest {

	private DefaultSausService sausService;
	@Mock
	private SausRepository dummySausRepository;
	
	@Before
	public void before() {
		List<Saus> sauzen = Arrays.asList(
				new Saus(1L,"Mayonaise", Arrays.asList("olie","mosterd", "azijn")),
				new Saus(2L,"Cocktail", Arrays.asList("mayonaise","Whisky", "Cocktail"))
		);
		when(dummySausRepository.findAll()).thenReturn(sauzen);
		sausService = new DefaultSausService(new SausRepository[] {dummySausRepository});
	}
	@Test
	public void findAll() {
		assertTrue(sausService.findAll().stream()
				.map(s -> s.getNaam())
				.filter(naam -> naam.equalsIgnoreCase("mayonaise"))
				.findFirst()
				.isPresent()
		);
		verify(dummySausRepository).findAll();
	}

}
