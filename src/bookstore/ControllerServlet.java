package bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;



    public void init() {
    	String url=getServletContext().getInitParameter("url");
    	String username=getServletContext().getInitParameter("username");
    	String password=getServletContext().getInitParameter("password");
    	bookDao = new BookDao(url,username,password);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch(action) {
			case "new":
				showNewForm(request,response);
				break;
			case "delete":
				deleteBook(request,response);
				break;
			case "insert":
				insertBook(request,response);
				break;
			case "edit":
				showEditForm(request,response);
				break;
			case "update":
				updateBook(request,response);
				break;
			case "list":
				listBook(request, response);
				break;
			}
		}catch(SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException{
		List<Book> listBook = bookDao.listAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		dispatcher.forward(request, response);
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book book = new Book(id, title, author, price);
		bookDao.updateBook(book);
		response.sendRedirect("ControllerServlet?action=list");		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = bookDao.getBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException{
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book newBook = new Book(title, author, price);
		bookDao.insertBook(newBook);
		response.sendRedirect("ControllerServlet?action=list");		
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));

		Book book = new Book(id);
		bookDao.deleteBook(book);
		response.sendRedirect("ControllerServlet?action=list");		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		dispatcher.forward(request, response);		
	}

}
