package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cruds.model.Author;
import com.cruds.model.Book;
import com.cruds.model.Issue;
import com.cruds.model.Student;
import java.util.Calendar;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class BookDAO {
	
	public boolean addBook(Book book)
	{
		String sql = "insert into book(book_isbn, book_title, category, no_of_books) values(?, ?, ?, ?)";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book.getIsbn());
			ps.setString(2,  book.getTitle());
			ps.setString(3, book.getCategory());
			ps.setInt(4,  book.getQuantity());
			
			rows = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
	}
	
	public boolean addAuthor(Author author)
	{
		String sql = "insert into author(author_name, author_mail_id, book_isbn) values(?, ?, ?)";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, author.getName());
			ps.setString(2,  author.getEmail());
			ps.setString(3, author.getBook_isbn());
			
			rows = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
	}
	
	public boolean addStudent(Student stud)
	{
		String sql = "insert into student(usn, name) values(?, ?)";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stud.getUsn());
			ps.setString(2,  stud.getName());
			
			rows = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rows >= 0;
	}
	
	public boolean studentExist(Student stud)
	{
		String sql = "select usn, name from student where usn = ?";
		boolean flag = false;;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stud.getUsn());			
			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next())
			{
				flag = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
        
        public DefaultTableModel getStudentbyUsn(String usn)
	{
		String sql = "select usn, name from student where LOWER(usn) = ?";
		Vector<String> colNames = new Vector<>();
		colNames.add("USN");
		colNames.add("Name");
                
                Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usn.toLowerCase());
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
                                data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new DefaultTableModel(data, colNames);
	}
        
        public DefaultTableModel getStudentbyName(String name)
	{
		String sql = "select usn, name from student where LOWER(name) = ?";
		Vector<String> colNames = new Vector<>();
		colNames.add("USN");
		colNames.add("Name");
                
                Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name.toLowerCase());
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
                                data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new DefaultTableModel(data, colNames);
	}
	
	public DefaultTableModel getByTitle(String title)
	{
		String sql = "select b.book_isbn, b.book_title, b.category, b.no_of_books, a.author_name from book b, author a where a.book_isbn = b.book_isbn and LOWER(b.book_title) like ? ";
		Vector<String> colNames = new Vector<>();
		colNames.add("Book ISBN");
		colNames.add("Book Title");
                colNames.add("Category");
                colNames.add("Quantity");
                colNames.add("Author");
                
                Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + title.toLowerCase() + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(String.valueOf(rs.getInt(4)));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new DefaultTableModel(data, colNames);
	}
	
	public DefaultTableModel getByCategory(String category)
	{
		String sql = "select b.book_isbn, b.book_title, b.category, b.no_of_books, a.author_name from book b, author a where a.book_isbn = b.book_isbn and LOWER(b.category) like ?";
                Vector<String> colNames = new Vector<>();
		colNames.add("Book ISBN");
		colNames.add("Book Title");
                colNames.add("Category");
                colNames.add("Quantity");
                colNames.add("Author");
		
		Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, "%" + category.toLowerCase() + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(String.valueOf(rs.getInt(4)));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data, colNames);
	}
	
	public DefaultTableModel getByAuthor(String name)
	{
		String sql = "select b.book_isbn, b.book_title, b.category, b.no_of_books, a.author_name from book b, author a where b.book_isbn = a.book_isbn and LOWER(a.author_name) like ?";
		Book b = null;
                Vector<String> colNames = new Vector<>();
		colNames.add("Book ISBN");
		colNames.add("Book Title");
                colNames.add("Category");
                colNames.add("Quantity");
                colNames.add("Author");
		
		Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, "%" + name.toLowerCase() + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(String.valueOf(rs.getInt(4)));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data, colNames);
	}
        
        public DefaultTableModel getByIsbn(String isbn)
	{
		String sql = "select b.book_isbn, b.book_title, b.category, b.no_of_books, a.author_name from book b, author a where a.book_isbn = b.book_isbn and LOWER(b.book_isbn) = ?";
                Vector<String> colNames = new Vector<>();
		colNames.add("Book ISBN");
		colNames.add("Book Title");
                colNames.add("Category");
                colNames.add("Quantity");
                colNames.add("Author");
		
		Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, isbn.toLowerCase());
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(String.valueOf(rs.getInt(4)));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data, colNames);
	}
	
	public DefaultTableModel getTableBookAuthor()
	{
		String sql = "select b.book_isbn, b.book_title, b.category, b.no_of_books, a.author_name from book b, author a where a.book_isbn = b.book_isbn";
		Vector<String> colNames = new Vector<>();
		colNames.add("Book ISBN");
		colNames.add("Book Title");
                colNames.add("Category");
                colNames.add("Quantity");
                colNames.add("Author");
		
		Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(String.valueOf(rs.getInt(4)));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new DefaultTableModel(data, colNames);
	}
	
	public boolean issueBook(Issue bi)
	{
		String sql = "insert into book_issue(issue_id, usn, issue_date, return_date, book_isbn) values(?, ?, ?, ?, ?)";
                String sqlCount = "update book set no_of_books = no_of_books - 1 where book_isbn = ?";
		int rows = 0;
                int rowsCount = 0;
		java.sql.Date idate = new java.sql.Date(bi.getIssueDate().getTime());
		java.sql.Date rdate = new java.sql.Date(bi.getReturnDate().getTime());
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement psCount = conn.prepareStatement(sqlCount);
                        psCount.setString(1, bi.getBook_isbn());
                        rowsCount = psCount.executeUpdate();
                        
                        PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bi.getId());
			ps.setString(2, bi.getUsn());
			ps.setDate(3, idate);
			ps.setDate(4, rdate);
			ps.setString(5, bi.getBook_isbn());
			rows = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0 && rowsCount > 0;
	}
	
	public DefaultTableModel listBookByUsn(String usn)
	{
		String sql = "select bi.issue_id, b.book_title, bi.usn, s.name, bi.issue_date, bi.return_date, bi.book_isbn  from book b, student s, book_issue bi where b.book_isbn = bi.book_isbn and bi.usn = s.usn and LOWER(bi.usn) = ?";
                Vector<String> colNames = new Vector<>();
		colNames.add("ID");
                colNames.add("Book Title");
		colNames.add("USN");
                colNames.add("Student Name");
                colNames.add("Issue Date");
                colNames.add("Return Date");
                colNames.add("ISBN");
		
		Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, usn);
                        ResultSet rs = ps.executeQuery();
                        
                        while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(rs.getString(4));
                                row.add(String.valueOf(rs.getDate(5)));
                                row.add(String.valueOf(rs.getDate(6)));
                                row.add(rs.getString(7));
				data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return new DefaultTableModel(data, colNames);
	}
        
        public DefaultTableModel listIssuedBooks()
	{
		String sql = "select bi.issue_id, b.book_title, bi.usn, s.name, bi.issue_date, bi.return_date, bi.book_isbn  from book b, student s, book_issue bi where b.book_isbn = bi.book_isbn and bi.usn = s.usn";
                Vector<String> colNames = new Vector<>();
		colNames.add("ID");
                colNames.add("Book Title");
		colNames.add("USN");
                colNames.add("Student Name");
                colNames.add("Issue Date");
                colNames.add("Return Date");
                colNames.add("ISBN");
		
		Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                   
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(rs.getString(4));
                                row.add(String.valueOf(rs.getDate(5)));
                                row.add(String.valueOf(rs.getDate(6)));
                                row.add(rs.getString(7));
				data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return new DefaultTableModel(data, colNames);
	}
	
	public DefaultTableModel getBookToReturn(Date curDate)
	{
		String sql = "select bi.issue_id, b.book_title, bi.usn, s.name, bi.issue_date, bi.return_date, bi.book_isbn  from book b, student s, book_issue bi where b.book_isbn = bi.book_isbn and bi.usn = s.usn and bi.return_date = ?";
                Vector<String> colNames = new Vector<>();
		colNames.add("ID");
                colNames.add("Book Title");
		colNames.add("USN");
                colNames.add("Student Name");
                colNames.add("Issue Date");
                colNames.add("Return Date");
                colNames.add("ISBN");
		
		Vector<Vector<String>> data = new Vector<>();
                java.sql.Date cdate = new java.sql.Date(curDate.getTime());
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setDate(1, cdate);
                        ResultSet rs = ps.executeQuery();
                        
                        while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(rs.getString(4));
                                row.add(String.valueOf(rs.getDate(5)));
                                row.add(String.valueOf(rs.getDate(6)));
                                row.add(rs.getString(7));
				data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return new DefaultTableModel(data, colNames);
	}                 
        
        public boolean returnBook(int id, String isbn)
        {
            String sql = "Delete from book_issue where issue_id = ? ";
            
            String sqlCount = "update book set no_of_books = no_of_books+1 where book_isbn = ? ";
            
            int rows = 0;
            int rowsCount = 0;
            
            try(Connection conn = DBConnectionManager.getConnection())
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rows = ps.executeUpdate();
                
                PreparedStatement psCount = conn.prepareStatement(sqlCount);
                psCount.setString(1, isbn);
                rowsCount = psCount.executeUpdate();
                
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return ((rows > 0) && (rowsCount > 0));
        }
        
        public String[] getAllCategory()
        {
            String sql = "Select unique(category) from book";
            List<String> list = new ArrayList<>();
            list.add("Select");
            try(Connection conn = DBConnectionManager.getConnection())
            {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                
                while(rs != null && rs.next())
		{
                    list.add(rs.getString(1));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String[] category = new String[list.size()];
            
            for(int i=0; i<list.size();i++)
            {
                category[i] = list.get(i);
            }
                
            return category;
        }
        

}
