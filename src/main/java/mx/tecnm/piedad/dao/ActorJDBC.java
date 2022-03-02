package mx.tecnm.piedad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Actores;

@Repository
public class ActorJDBC {
	
	@Autowired
	private JdbcTemplate conexion;
	
	public void AgregarActor ( Actores nuevo_actor) {
	String sql="INSERT INTO actores (nombre_completo) VALUES  (?)";
	conexion.update(sql, nuevo_actor.getNombre_completo());
	}
	
	public void ModificaActor(Actores actor, int actorid) {
	String sql="UPDATE actores SET nombre_completo= ? WHERE id= ? ";
	conexion.update(sql, actor.getNombre_completo(), actorid );
	}
	
	public void EliminaActor(int actorid) {
	String sql="DELETE FROM actores WHERE id= ?";
	conexion.update(sql, actorid);
	}
	
	public void ConsultaActor(int actorid) {
	String sql="SELECT * FROM actores WHERE id= ?";
	conexion.update(sql, actorid);
	}
	
	

}
