package be.vdab.frituurfrita.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.frituurfrita.entities.Snack;


@RunWith(SpringRunner.class)
@JdbcTest 
@AutoConfigureTestDatabase(replace = Replace.NONE) 
@Import(JdbcSnackRepository.class) 
@Sql("/insertSnack.sql")
public class JdbcSnackRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private JdbcSnackRepository repository;
	
	@Test
	public void read() {
		assertEquals("test", repository.read(getIdVanTestSnack()).get().getNaam());
	}
	
	private long getIdVanTestSnack() {
		return super.jdbcTemplate.queryForObject("select id from snacks where naam='test'",
				Long.class);
	}
	
	@Test
	public void update() {
		long id = getIdVanTestSnack();
		Snack snack = new Snack(id,"test",BigDecimal.ONE);
		repository.update(snack);
		assertEquals(0, BigDecimal.ONE.compareTo(
				super.jdbcTemplate.queryForObject("select prijs from snacks where id=?",
						BigDecimal.class, id)));
	}
	@Test
	public void findByBeginNaam() {
		List<Snack> snacks = repository.findByBeginNaam("Kip");
		for (Snack snack : snacks) {
			assertNotEquals("Bamischijf", snack.getNaam());
			assertEquals("kip", snack.getNaam().substring(0, 3).toLowerCase());
			assertTrue("Bamischijf".compareTo(snack.getNaam()) < 0);
		}
		long aantalSnacks = super.jdbcTemplate.queryForObject(
				"select count(*) from snacks where naam like 'kip%'", Long.class);
				assertEquals(aantalSnacks, snacks.size());
	}

}
