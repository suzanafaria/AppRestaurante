package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import conexao.Conexao;
import negocio.Gerente;

public class GerenteDao {

	public static Set<Gerente> obterLista() {
		Set<Gerente> lista = new HashSet<Gerente>();

		String sql = "SELECT * FROM TGerente ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					lista.add(new Gerente(
							rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("email"),
							rs.getString("telefone")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	public static Gerente incluir(Gerente gerente) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT into TGerente (nome, email, telefone) values (?,?,?)"
						);

			ps.setString(1, gerente.getNome());
			ps.setString(2, gerente.getEmail());
			ps.setString(3, gerente.getTelefone());
			
			
			ps.execute();
			
			return gerente;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	
	public static boolean excluir(int id) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TGerente WHERE id = ?"
						);
			
			ps.setInt(1, id);
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static Gerente obterPorId(int id){
		String sql = "SELECT * FROM TGerente where id = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			 
			if(rs.next()){
				return new Gerente(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getString("email"), 
						rs.getString("telefone")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
