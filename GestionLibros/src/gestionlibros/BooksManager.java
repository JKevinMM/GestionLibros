package gestionlibros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BooksManager {
    
    private ClassConnect clConnect;
    private Book classBook;
    private ResultSet variableResultSet=null; 
                                            
    public BooksManager(ClassConnect Connection) {
        try{
            clConnect=Connection;
            classBook=new Book();
        }catch (Exception e){
        }
    }
    
    public Book showBook(String selectedID) throws SQLException{
            Book book = new Book();
            String sql="SELECT * FROM libros WHERE codigo="+selectedID;
            clConnect.runQuery(sql);                                         
            variableResultSet=clConnect.getVariableResultSet();
            variableResultSet.next();
            book.setId(variableResultSet.getString("codigo"));
            book.setTitle(variableResultSet.getString("titulo"));
            book.setAuthor(variableResultSet.getString("autor"));
            book.setEditorial(variableResultSet.getString("editorial"));
            book.setSubject(variableResultSet.getString("asignatura"));
            book.setState(variableResultSet.getString("estado"));
            return book;
    }
    
    public void modify(Book classBook){
        try{
            String sql = "update libros set titulo='" + classBook.getTitle() + "', autor='" + classBook.getAuthor() + "', "
            + "editorial='" + classBook.getEditorial() + "', asignatura='" + classBook.getSubject() + "', estado='" + classBook.getState() + "' "
            + "where codigo=" + classBook.getId();
            if (clConnect.updateSQL(sql) > 0) {
                JOptionPane.showMessageDialog(null, "Modificación Correcta");
            }
            else{
                JOptionPane.showMessageDialog(null, "Ha Habido un Error");
            }
        }catch(Exception e){
        }
    }
    
    public void deleteBook(Book classBook) throws SQLException{
        String sql="delete from libros where codigo=" + classBook.getId();
        if(clConnect.updateSQL(sql) > 0){ 
            JOptionPane.showMessageDialog(null, "Baja Correcta");
        }
        else{
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }
    
    public void addBook(Book classBook) throws SQLException{ 
        String sql="INSERT INTO libros(Titulo,Autor,Editorial,Asignatura,estado) " 
                 +"VALUES('"+classBook.getTitle()+"','"+classBook.getAuthor()+"','"
                 +classBook.getEditorial()+"','"+classBook.getSubject()+ "','" + classBook.getState() +"')";
        if(clConnect.updateSQL(sql) > 0){
            JOptionPane.showMessageDialog(null, "El libro se ha dado de alta correctamente.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
    }
    
    public void queryAll(){
        try {
            clConnect.runQuery("select * from libros");
        } catch (SQLException ex) {
            Logger.getLogger(BooksManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void search(String txtSearch){
        try{
            if(isNumeric(txtSearch)==true){
                 clConnect.runQuery("SELECT * FROM libros WHERE codigo="+txtSearch);
            }
            else{
                String searchSQL="";
                            
                searchSQL="SELECT * FROM libros WHERE Titulo LIKE '"+txtSearch+"%' OR Autor LIKE '"+txtSearch+"%' "
                        + "OR Editorial LIKE '"+txtSearch+"%' OR Asignatura LIKE '"+txtSearch+"%' OR estado LIKE '"+txtSearch+"%'";
                
                clConnect.runQuery(searchSQL);
            }                               
        } catch (SQLException ex) {
            Logger.getLogger(BooksManager.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    private boolean isNumeric(String cadena){
        try{
            Integer.valueOf(cadena);
            return true;       
        } catch(NumberFormatException E){
            return false; 
        }
    }
}