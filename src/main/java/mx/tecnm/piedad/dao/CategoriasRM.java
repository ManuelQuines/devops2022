package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.piedad.models.Categorias;

public class CategoriasRM implements RowMapper<Categorias>{
	@Override
	public Categorias mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categorias categorias= new Categorias();
		
		categorias.setId(rs.getInt("id"));
		categorias.setClasificacion(rs.getString("clasificacion"));
		categorias.setDescripcion(rs.getString("descripcion"));

		return categorias;
}
	
}
