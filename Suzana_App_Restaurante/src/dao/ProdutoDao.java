package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import conexao.Conexao;
import modelo.Produto;

public class ProdutoDao {

	public static Produto incluir(Produto produto) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
					"INSERT into TProduto (codigo, nome, preco) values (?,?,?)",
					Statement.RETURN_GENERATED_KEYS
					);

			ps.setString(1, produto.getCodigo());
			ps.setString(2, produto.getNome());
			ps.setFloat(3, produto.getPreco());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();	//retorna o primeiro campo autoincremento que existir na consulta
			
			if(rs.next()) {
				produto.setId(rs.getInt(1));
				return produto;
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	
	public static Set<Produto> obterLista() {
		Set<Produto> lista = new HashSet<Produto>();
		
		lista.addAll(BebidaDao.obterLista());
		lista.addAll(ComidaDao.obterLista());
		lista.addAll(SobremesaDao.obterLista());
		
		return lista;
	}
	
	public static Produto obterPorId(int id){
		
		Produto produto = BebidaDao.obterPorId(id); 			
		
		if(produto == null) {
			produto = ComidaDao.obterPorId(id);
			
			if(produto == null) {
				produto = SobremesaDao.obterPorId(id);							
			}
		}
	
		return produto;
	}
	
	public static boolean excluir(int id) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TProduto WHERE id = ?"
						);
			
			ps.setInt(1, id);
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Set<Produto> obterListaPorRestaurante(int idRestaurante){
		Set<Produto> lista = new HashSet<Produto>();

		String sql = "SELECT * FROM TRestauranteProduto where idRestaurante = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, idRestaurante);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				lista.add(
						obterPorId(rs.getInt("idProduto"))						
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}	
	
}
