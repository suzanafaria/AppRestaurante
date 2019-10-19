package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import conexao.Conexao;
import modelo.Produto;
import negocio.Bebida;

public class BebidaDao {
	
	public static Bebida incluir(Bebida bebida) {
		try {
			
			Produto produto = ProdutoDao.incluir(bebida);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
					"INSERT into TBebida (idProduto, marca, tamanho, alcoolica) values (?,?,?,?)"
					);
	
			ps.setInt(1, produto.getId());
			ps.setString(2, bebida.getMarca());
			ps.setString(3, bebida.getTamanho());
			ps.setBoolean(4, bebida.isAlcoolica());
			
			
			ps.execute();
			
			return bebida;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}	
	
	public static Set<Bebida> obterLista(){
		Set<Bebida> listaBebidas = new HashSet<Bebida>();
		
		String sql = "SELECT b.idProduto, b.marca, b.tamanho, b.alcoolica, p.codigo, p.nome, p.preco FROM bdrestaurante.tbebida b Inner join bdrestaurante.tproduto p on b.idProduto = p.id ORDER BY p.nome;";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();			
			while(rs.next()){

				listaBebidas.add(
						new Bebida(
								rs.getInt("idProduto"), 
								rs.getString("codigo"), 
								rs.getString("nome"), 
								rs.getFloat("preco"),
								rs.getString("marca"), 
								rs.getString("tamanho"), 
								rs.getBoolean("alcoolica")
								)
						);					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaBebidas;
	}
	
	public static boolean excluir(int id) {
		try {
			ProdutoDao.excluir(id);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TBebida WHERE idProduto = ?"
						);
			
			ps.setInt(1, id);
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Bebida obterPorId(int id){
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"SELECT * FROM TBebida B INNER JOIN TPRODUTO P ON P.ID = B.IDPRODUTO "
					+ "WHERE P.ID = ?"
					);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Bebida(
						rs.getInt("idProduto"), 
						rs.getString("codigo"), 
						rs.getString("nome"), 
						rs.getFloat("preco"),
						rs.getString("marca"), 
						rs.getString("tamanho"), 
						rs.getBoolean("alcoolica")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
