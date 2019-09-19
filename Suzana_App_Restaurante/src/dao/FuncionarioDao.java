package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Funcionario;

public class FuncionarioDao {

	public static List<Funcionario> obterLista() {
		List<Funcionario> lista = new ArrayList<Funcionario>();

		String sql = "SELECT * FROM TFuncionario ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.next()) {
					lista.add(new Funcionario(
							rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("email"),
							rs.getString("telefone")));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	public static Funcionario incluir(Funcionario funcionario) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT into TFuncionario (nome, email, telefone) values (?,?,?)"
						);

			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getEmail());
			ps.setString(3, funcionario.getTelefone());
			
			
			ps.execute();
			
			return funcionario;	//por enquanto ainda nao tem o id do funcionario gravado
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	
	public static boolean excluir(int id) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM TFuncionario WHERE id = ?"
						);
			
			ps.setInt(1, id);
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
