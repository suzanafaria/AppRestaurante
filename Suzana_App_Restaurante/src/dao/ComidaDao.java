package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import conexao.Conexao;
import modelo.Produto;
import negocio.Comida;

public class ComidaDao {
	
	public static Comida incluir(Comida comida) {
		try {
			
			Produto produto = ProdutoDao.incluir(comida);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
					"INSERT into TComida (idProduto, tipo, serveDuasPessoas, acompanhamentoExtra) values (?,?,?,?)"
					);
	
			ps.setInt(1, produto.getId());
			ps.setString(2, comida.getTipo());
			ps.setBoolean(3, comida.isServeDuasPessoas());
			ps.setBoolean(4, comida.isAcompanhamentoExtra());
			
			
			ps.execute();
			
			return comida;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	public static Set<Comida> obterLista() {
		Set<Comida> listaComidas = new HashSet<Comida>();

	
		String sql = "SELECT c.idProduto, c.tipo, c.serveDuasPessoas, c.acompanhamentoExtra, p.codigo, p.nome, p.preco FROM bdrestaurante.tcomida c Inner join bdrestaurante.tproduto p on c.idProduto = p.id ORDER BY p.nome;";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			
			while(rs.next()){
				listaComidas.add(
						new Comida(
								rs.getInt("idProduto"), 
								rs.getString("codigo"), 
								rs.getString("nome"), 
								rs.getFloat("preco"),
								rs.getString("tipo"), 
								rs.getBoolean("serveDuasPessoas"), 
								rs.getBoolean("acompanhamentoExtra")));					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaComidas;
	}
	
	public static boolean excluir(int id) {
		try {
			ProdutoDao.excluir(id);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TComida WHERE idProduto = ?"
						);
			
			ps.setInt(1, id);
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Comida obterPorId(int id){
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"SELECT * FROM TComida C INNER JOIN TPRODUTO P ON P.ID = C.IDPRODUTO "
					+ "WHERE P.ID = ?"
					);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Comida(
						rs.getInt("idProduto"), 
						rs.getString("codigo"), 
						rs.getString("nome"), 
						rs.getFloat("preco"),
						rs.getString("tipo"), 
						rs.getBoolean("serveDuasPessoas"), 
						rs.getBoolean("acompanhamentoExtra")		
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
