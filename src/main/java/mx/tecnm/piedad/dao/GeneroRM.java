package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.piedad.models.Generos;

public class GeneroRM implements RowMapper<Generos> {

	@Override
	public Generos mapRow(ResultSet rs, int rowNum) throws SQLException{
		Generos generos=new Generos();
	generos.setId(rs.getInt("id"));
	generos.setNombre(rs.getString("nombre"));
		
	
	return generos;
	}
}
