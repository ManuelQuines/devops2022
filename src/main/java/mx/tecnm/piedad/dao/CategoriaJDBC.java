package mx.tecnm.piedad.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mx.tecnm.piedad.models.Categorias;

@Repository
public class CategoriaJDBC {
	@Autowired
	private JdbcTemplate conexion;
	
	public void AgrgarCategoria(Categorias nueva_categoria) {
			String sql="INSERT INTO categorias (clasificacion, descripcion, creado) VALUES  (?,?, Now())";
			conexion.update(sql, nueva_categoria.getClasificacion(), nueva_categoria.getDescripcion());
	}
	public void ModificaCategoria(Categorias categoria, int categoriaid) {
		String sql="UPDATE categorias SET clasificacion= ?, descripcion= ?, modificado = NOW() WHERE id= ? ";
		conexion.update(sql, categoria.getClasificacion(), categoria.getDescripcion(), categoriaid );
		}
		
		public void EliminaCategoria(int categoriaid) {
		String sql="UPDATE categorias SET activo = 0, eliminado = NOW() WHERE id = ?";
		conexion.update(sql, categoriaid);
		}
		
		public Categorias ConsultaCategoria(int categoriaid) {
		String sql="SELECT * FROM categorias WHERE id= ?";
		return conexion.queryForObject(sql, new CategoriasRM(), categoriaid);
		}
		
		public List<Categorias> catalogoCategoria(){
		String sql="SELECT * FROM categorias WHERE activo= 1";
		return conexion.query(sql, new CategoriasRM());
		}
	
}