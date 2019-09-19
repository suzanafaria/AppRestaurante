package conexao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import auxiliar.Constante;


public class ConexaoFuncionario {

	private static BufferedReader in = null;
	private static BufferedWriter out = null;
	
	public static BufferedReader obterLeitura() {
		if (in == null) {
			try {
				in = new BufferedReader(new FileReader(Constante.DIR+Constante.TABFuncionarios));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return in;
	}
	
	public static BufferedWriter obterEscrita() {
		if (out == null) {
			try {
				out = new BufferedWriter(new FileWriter(Constante.DIR+Constante.TABFuncionarios, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return out;
	}
	
	public static void fecharLeitura() {
		try {
			in.close();
			in=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fecharEscrita() {
		try {
			out.close();
			out = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
