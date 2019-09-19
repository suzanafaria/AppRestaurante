package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Comida> obterLista() {
		List<Comida> listaComidas = new ArrayList<Comida>();

	
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
								rs.getBoolean("acompanhamentoExtra")
								)
						);					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaComidas;
	}
}
