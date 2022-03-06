package mx.tecnm.piedad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Categorias;

@Repository
public class CategoriaJDBC {
	@Autowired
	private JdbcTemplate conexion;
	
	public void AgrgarCategoria(Categorias nueva_categoria) {
			String sql="INSERT INTO categorias (clasificacion) VALUES  (?)";
			conexion.update(sql, nueva_categoria.getClasificacion());
	}
	public void ModificaCategoria(Categorias categoria, int categoriaid) {
		String sql="UPDATE categorias SET nombre_completo= ? WHERE id= ? ";
		conexion.update(sql, categoria.getClasificacion(), categoriaid );
		}
		
		public void EliminaCategoria(int categoriaid) {
		String sql="DELETE FROM categorias WHERE id= ?";
		conexion.update(sql, categoriaid);
		}
		
		public void ConsultaCategoria(int categoriaid) {
		String sql="SELECT * FROM categorias WHERE id= ?";
		conexion.update(sql, categoriaid);
		}
	
}