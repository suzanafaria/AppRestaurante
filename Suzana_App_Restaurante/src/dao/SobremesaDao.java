package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import conexao.Conexao;
import modelo.Produto;
import negocio.Sobremesa;

public class SobremesaDao {
	
	public static Sobremesa incluir(Sobremesa sobremesa) {
		try {
			
			Produto produto = ProdutoDao.incluir(sobremesa);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
					"INSERT into TSobremesa (idProduto, sobremesaFria, versaoDiet, contemLactose) values (?,?,?,?)"
					);
	
			ps.setInt(1, produto.getId());
			ps.setBoolean(2, sobremesa.isSobremesaFria());
			ps.setBoolean(3, sobremesa.isVersaoDiet());
			ps.setBoolean(4, sobremesa.isContemLactose());
			
			
			ps.execute();
			
			return sobremesa;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}	
	
	
	public static Set<Sobremesa> obterLista(){
		Set<Sobremesa> listaSobremesas = new HashSet<Sobremesa>();
		
		String sql = "SELECT s.idProduto, s.sobremesaFria, s.versaoDiet, s.contemLactose, p.codigo, p.nome, p.preco FROM bdrestaurante.tsobremesa s Inner join bdrestaurante.tproduto p on s.idProduto = p.id ORDER BY p.nome;";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while(rs.next()){

				listaSobremesas.add(
						new Sobremesa(
								rs.getInt("idProduto"), 
								rs.getString("codigo"), 
								rs.getString("nome"), 
								rs.getFloat("preco"),
								rs.getBoolean("sobremesaFria"), 
								rs.getBoolean("versaoDiet"), 
								rs.getBoolean("contemLactose")
								)
						);					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaSobremesas;
	}
	
	public static boolean excluir(int id) {
		try {
			ProdutoDao.excluir(id);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TSobremesa WHERE idProduto = ?"
						);
			
			ps.setInt(1, id);
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Sobremesa obterPorId(int id){
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"SELECT * FROM TSobremesa S INNER JOIN TPRODUTO P ON P.ID = S.IDPRODUTO "
					+ "WHERE P.ID = ?"
					);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Sobremesa(
						rs.getInt("idProduto"), 
						rs.getString("codigo"), 
						rs.getString("nome"), 
						rs.getFloat("preco"),
						rs.getBoolean("sobremesaFria"), 
						rs.getBoolean("versaoDiet"), 
						rs.getBoolean("contemLactose")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
