package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DAO;
import models.Usuario;


@WebServlet(urlPatterns = {"/Controller", "/cadastro", "/logar"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Usuario user = new Usuario(); 
      DAO dao = new DAO();
    
    public Controller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		if(action.equals("/cadastro")) {
			inserirDados(request, response);
		}if(action.equals("/logar")) {
			logar(request,response);
		}
		
	}
	
	protected void inserirDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user.setNome(request.getParameter("nome"));
		user.setEmail(request.getParameter("email"));
		user.setSenha(request.getParameter("senha"));
		
		
		dao.inserirCadastro(user);
		
		response.sendRedirect("login.html");
	}
	
	protected void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		user.setEmail(request.getParameter("emailLogin"));
		user.setSenha(request.getParameter("senhaLogin"));
		
		dao.buscarSelecionado(user);
		
		if(dao.buscarSelecionado(user) == true) {
			logando(request, response);
		}else {
			response.sendRedirect("login.html");
		}
		
		
	}
	
	protected void informarDadosLogado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Usuario> nome = dao.buscarNome(user);
		
		request.setAttribute("nomeLogado", nome);
		RequestDispatcher rd = request.getRequestDispatcher("paginaLogadaUser.jsp");
		rd.forward(request, response);
		
	}
	
	protected void logando(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailLogin");
		String senha = request.getParameter("senhaLogin");
		
		
		
		if(email != null && senha != null && !email.isEmpty() && !senha.isEmpty()) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", email);
			informarDadosLogado(request, response);
		}else {
			response.sendRedirect("login.html");
		}
	
	}
}
