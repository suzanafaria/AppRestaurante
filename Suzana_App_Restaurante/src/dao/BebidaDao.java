package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public static List<Bebida> obterLista(){
		List<Bebida> listaBebidas = new ArrayList<Bebida>();
		
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
}
