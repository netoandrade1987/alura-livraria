/**
 * 
 */
package br.com.alura.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.dao.AutorDao;
import br.com.alura.modelo.Autor;

/**
 * @author neto_
 *
 */

@WebServlet("/autor")
public class AutorServelet extends HttpServlet {
	
	
private AutorDao autorDao;
	
	
public AutorServelet() {
	
	this.autorDao = new AutorDao();
		
}

	/**
	 * @param autorDao
	 * Construtor que recebe o Dao de Autor para realizar a Conexão com o Banco de Dados
	 * e efetuar as operações de adicição, remoção, listagem e remoção.
	 * 
	 */
	public AutorServelet(AutorDao autorDao) {
		
		this.autorDao = autorDao;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("autores", autorDao.getLista());
		req.getRequestDispatcher("WEB-INF/resources/jsp/autor.jsp").forward(req, resp);
		
					
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			LocalDate dataNascimento = LocalDate.parse(req.getParameter("dataNascimento"));
//					DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			
			String miniCurriculo = req.getParameter("miniCurriculo");
			
			Autor autor = new Autor(nome, email, dataNascimento, miniCurriculo);
			
			autorDao.add(autor);
			
			resp.sendRedirect("autor");
			
		} catch (Exception e) {
			
			System.out.println("Error na conversão dos parametros.");

			e.printStackTrace();

			throw new RuntimeException(e);
		}
		
		
	}
		
	
	
	
	
	
	

}
