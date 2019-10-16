package pe.edu.upeu.ventas.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upeu.ventas.dao.CategoriaDao;
import pe.edu.upeu.ventas.entity.Categoria;
@Transactional
@Repository
public class CategoriaDaoImp implements CategoriaDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Categoria cat) {
		return  jdbcTemplate.update("call crearCategoria(?)",cat.getNom_cat());
	}

	@Override
	public int edtit(Categoria cat) {
		return jdbcTemplate.update("call modificarCategoria(?,?)",cat.getNom_cat(), cat.getIdcategoria());
	}

	@Override
	public Categoria read(int id) {
        Categoria cat = jdbcTemplate.queryForObject("call categoriaId(?)",new Object[]{id},new BeanPropertyRowMapper<>(Categoria.class));
		return cat;
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("call deleteCategoria(?)", id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		//jdbcTemplate.queryForList("call listarcategoria()");
		return jdbcTemplate.queryForList("select *from categoria");
	}

	@Override
	public List<Map<String, Object>> readAll(int id) {
		return jdbcTemplate.queryForList("call listarcategoria(?)",id);
	}

}
