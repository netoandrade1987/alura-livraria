package br.com.alura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Autor;



public class AutorDao {

	private Connection connection;

	public AutorDao() {

		try {

			this.connection = new ConnectionFactory().getConnection();

		} catch (SQLException e) {

			System.out.println("Falha ao conectar no Banco de Dados!!");
			e.printStackTrace();

			throw new RuntimeException(e);

		}

	}

	public AutorDao(Connection connection) {

		this.connection = connection;

	}

	public void add(Autor autor) {

		try {

			String sql = "insert into autor(nome, email, dataNascimento, miniCurriculo) values (?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(sql);
			
			

			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getDataNascimento()));
			ps.setString(4, autor.getMiniCurriculo());

			ps.execute();
			ps.close();

			System.out.println(autor.getNome() +" Adicionado com Sucesso!");

		} catch (SQLException e) {

			System.out.println("Deu error");
			throw new RuntimeException(e);

		}

	}

	public List<Autor> getLista() {

		try {

			List<Autor> autores = new ArrayList<Autor>();

			PreparedStatement ps = this.connection.prepareStatement("select * from autor");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Autor autor = new Autor();

				autor.setId(rs.getInt("id"));
				autor.setNome(rs.getString("nome"));
				autor.setEmail(rs.getString("email"));		
				autor.setDataNascimento((rs.getDate("dataNascimento").toLocalDate()));
				autor.setMiniCurriculo(rs.getString("miniCurriculo"));
				autores.add(autor);

			}

			rs.close();
			ps.close();

			return autores;

		} catch (SQLException e) {

			System.out.println("Error na leitura dos dados!");
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

}
