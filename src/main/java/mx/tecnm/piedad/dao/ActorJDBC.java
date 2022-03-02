package mx.tecnm.piedad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.tecnm.piedad.models.Actores;

public class ActorJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	public void AgregarActor (int actorid, Actores nuevo_actor) {
	String sql="insert into actores (nombre_completo) values = ?";
	conexion.update(sql, nuevo_actor.getNombre_completo(), actorid);
			
	
	}
	
	public void ModificaActor(String nombre) {
		
	}
	
	public void EliminaActor(int id) {
		
	}
	
	public void ConsultaActor(int id) {
		
	}
	
	

}
