package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Restaurante;

public class RestauranteDao {

	
	public static Restaurante obterPorId(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"SELECT * FROM TRestaurante WHERE id = ?"
					);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Restaurante(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("categoria"), 
						rs.getString("localizacaoBairro"), 
						GerenteDao.obterPorId(rs.getInt("idGerente")),
						ProdutoDao.obterListaPorRestaurante(rs.getInt("id"))
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
		
	
	public static Restaurante incluir(Restaurante restaurante) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT into TRestaurante (nome, categoria, localizacaoBairro) values (?,?,?)"
						);
			

			ps.setString(1, restaurante.getNome());
			ps.setString(2, restaurante.getCategoria());
			ps.setString(3, restaurante.getLocalizacaoBairro());

			
			
			ps.execute();
			
			return restaurante;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	//while é para utilizar para obter uma lista, enquanto if é para pegar um objeto só
	public static List<Restaurante> obterLista() {
		List<Restaurante> lista = new ArrayList<Restaurante>();

		String sql = "SELECT * FROM TRestaurante ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					lista.add(new Restaurante(
							rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("categoria"),
							rs.getString("localizacaoBairro"),
							GerenteDao.obterPorId(rs.getInt("idGerente")),
							ProdutoDao.obterListaPorRestaurante(rs.getInt("id"))
							));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public static Restaurante associarGerente(Restaurante restaurante) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"UPDATE TRestaurante SET idGerente = ? WHERE id=?"		
						);

			ps.setInt(1, restaurante.getGerente().getId());
			ps.setInt(2, restaurante.getId());
			
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return restaurante;
	}
	
	
	private static boolean cancelarRestaurante(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TRestaurante WHERE id = ?"
						);

			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	
	public static boolean excluir(int idRestaurante){
		try {
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TRestauranteProduto WHERE idRestaurante = ?"
						);

			ps.setInt(1, idRestaurante);
			
			ps.execute();
			
			RestauranteDao.cancelarRestaurante(idRestaurante);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	public static boolean associarProduto(int idRestaurante, int idProduto) {
		try {
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO TRestauranteProduto (idRestaurante, idProduto) VALUES (?,?)");

			ps.setInt(1, idRestaurante);
			ps.setInt(2, idProduto);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
}
