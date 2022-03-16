package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Generos;


//jdbcsxcz
@Repository
public class GenerosJDBC {
	
	@Autowired
	
	private JdbcTemplate conexion;
	
	public void AgregarGenero ( Generos nuevo_genero) {
	String sql="INSERT INTO generos (nombre, creado) VALUES  (?, now())";
	conexion.update(sql, nuevo_genero.getNombre());
	}
	
	public void ModificaGenero(Generos  genero, int generoid) {
	String sql="UPDATE generos SET nombre= ?, modificado = now() WHERE id= ? ";
	conexion.update(sql, genero.getNombre(), generoid );
	}
	
	public void EliminaGenero(int generoid) {
	String sql="UPDATE generos SET activo = 0, eliminado = NOW() WHERE id = ?";
	conexion.update(sql, generoid);
	}
	
	public List<Generos> CatalogoGeneros() {
	String sql="SELECT * FROM generos WHERE activo= 1";
	return conexion.query(sql, new GeneroRM());
	}
	
	

}



