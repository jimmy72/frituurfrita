package be.vdab.frituurfrita.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.frituurfrita.entities.Snack;
import be.vdab.frituurfrita.exceptions.SnackNotFoundException;

@Repository
public class JdbcSnackRepository implements SnackRepository {

	private final NamedParameterJdbcTemplate TEMPLATE;
	private final SimpleJdbcInsert INSERT;
	private final RowMapper<Snack> SNACK_ROW_MAPPER = (resultSet, rowNumber) -> new Snack(resultSet.getLong("id"),
			resultSet.getString("naam"), resultSet.getBigDecimal("prijs"));
	private final static String READ_SNACK = "select id, naam, prijs from snacks where id= :id";
	private final static String UPDATE_SNACK = "update snacks set naam=:naam, prijs=:prijs where id=:id";
	private final static String SELECT_BEGIN_NAAM = "select id, naam, prijs from snacks where naam like :beginNaam order by naam";
	private final static String SELECT_ALL = "select id, naam, prijs from snacks order by id";
	
	public JdbcSnackRepository(NamedParameterJdbcTemplate template, DataSource dataSource) {
		this.TEMPLATE = template;
		this.INSERT = new SimpleJdbcInsert(dataSource);
		this.INSERT.withTableName("snacks"); 
		this.INSERT.usingGeneratedKeyColumns("id");
	}

	@Override
	public Optional<Snack> read(long id) {
		try {
			return Optional.of(this.TEMPLATE.queryForObject(READ_SNACK, Collections.singletonMap("id", id), SNACK_ROW_MAPPER));
		}catch(IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}

	@Override
	public void update(Snack snack) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("naam", snack.getNaam());
		parameters.put("prijs", snack.getPrijs());
		parameters.put("id", snack.getId());
		if(TEMPLATE.update(UPDATE_SNACK, parameters) == 0) {
			throw new SnackNotFoundException();
		}
		
	}

	@Override
	public List<Snack> findByBeginNaam(String beginNaam) {
		return this.TEMPLATE.query(SELECT_BEGIN_NAAM, Collections.singletonMap("beginNaam", beginNaam + '%'), SNACK_ROW_MAPPER);
	}

	@Override
	public List<Snack> findAll() {
		return this.TEMPLATE.query(SELECT_ALL, SNACK_ROW_MAPPER);
	}

}
