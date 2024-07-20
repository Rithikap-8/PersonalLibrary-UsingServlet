package com.Book.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Book.Util.HibernateUtil;
import com.Boook.Model.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
private SessionFactory sessionFactory;
private Session session;
protected void doPost(HttpServletRequest request, 
HttpServletResponse response)
throws ServletException, IOException {

int bookId = Integer.parseInt(request.getParameter("bookId"));
String bookName = request.getParameter("bookName");
String author = request.getParameter("author");
float bookPrice = Float.parseFloat(request.getParameter("bookPrice"));
String option = request.getParameter("option");


response.setContentType("text/html");
PrintWriter out = response.getWriter();

Book myBook = new Book();
myBook.setBookId(bookId);
myBook.setBookName(bookName);
myBook.setAuthor(author);
myBook.setBookPrice(bookPrice);

sessionFactory = HibernateUtil.getSessionFactory();

session = sessionFactory.openSession();

session.getTransaction().begin();
if (option.equals("Add")) {
session.save(myBook);
out.println("<h1  >Data Saved Successfully!</h1>");
}
if (option.equals("Update")) {
session.update(myBook);
out.println("<h1>Data updated Successfully!</h1>");
}
if (option.equals("Delete")) {
session.delete(myBook);
out.println("<h1>Data deleted Successfully!</h1>");
}
if (option.equals("Show")) {
List<Book> list = session.createCriteria(Book.class).list();
out.print("<table border='1' bgcolor='lightblue'>");
out.print("<th>Book Id.</th><th>Book Name</th><th>Author</th><th>Book Price(Rs.)</th>");
for (Book item : list) {
out.print("<tr><td>" + item.getBookId() + "</td><td>" + item.getBookName() + "</td><td>"+ item.getAuthor() + "</td><td>" + 
item.getBookPrice() + "</td></tr>");
}
out.print("</table>");
}


session.getTransaction().commit();
}
}

