package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	
	
	public static List<Produto> obterLista() {
		List<Produto> lista = new ArrayList<Produto>();
		
		lista.addAll(BebidaDao.obterLista());
		lista.addAll(ComidaDao.obterLista());
		lista.addAll(SobremesaDao.obterLista());
		
		return lista;
	}
}
