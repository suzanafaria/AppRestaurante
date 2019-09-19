package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import negocio.Usuario;

public class UsuarioDao {

	public static Usuario obterUsuario(String email, String senha) {
		String sql = "SELECT * FROM TUsuario WHERE email = ? AND senha = ?";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Usuario(rs.getInt("id"), 
						rs.getString("email"), 
						rs.getString("senha"), 
						rs.getString("nome")
					);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}