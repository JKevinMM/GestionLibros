package gestionlibros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Events implements ActionListener, MouseListener, DocumentListener{
    
    private BooksForm form;
    private BooksManager ClassBooksManager;
    private ClassConnect Connection;
    
    public Events(){
        Connection = new ClassConnect();
        ClassBooksManager = new BooksManager(Connection);
        ClassBooksManager.queryAll();
        form = new BooksForm(Connection.getVariableResultSet(),this);
        form.setVisible(true);                                                                                             
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource() == form.getButtonDeleteBook()){
            try{
                Book classBook=new Book();
                classBook.setId(form.getTxtID().getText());
                ClassBooksManager.deleteBook(classBook);
                update();
            } catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == form.getButtonExit()){
            System.exit(EXIT_ON_CLOSE);
        }
        
        if(e.getSource() == form.getButtonModify()){
            Book classBook=new Book();
            classBook.setTitle(form.getTxtTitle().getText());
            classBook.setId(form.getTxtID().getText());
            classBook.setAuthor(form.getTxtAuthor().getText());
            classBook.setEditorial(form.getTxtEditorial().getText());
            classBook.setSubject(form.getTxtSubject().getText());
            classBook.setState(form.getTxtState().getText());
            ClassBooksManager.modify(classBook);
            update();
        }
        
        if(e.getSource() == form.getButtonNewBook()){
            try{                                   
                Book classBook=new Book();
                classBook.setTitle(form.getTxtTitle().getText());
                classBook.setId(form.getTxtID().getText());
                classBook.setAuthor(form.getTxtAuthor().getText());
                classBook.setEditorial(form.getTxtEditorial().getText());
                classBook.setSubject(form.getTxtSubject().getText());
                classBook.setState(form.getTxtState().getText());
                ClassBooksManager.addBook(classBook);
                update();
            }catch (SQLException ex) {
                Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    } 
    
    @Override
    public void mouseClicked(MouseEvent e) {
        try{
            Book selectedBook = new Book();
            
            String selectedRegistry="";
            int selectedRow=0;
            
            selectedRow=form.getBooksTable().getSelectedRow();
            selectedRegistry=String.valueOf(form.getBooksTable().getValueAt(selectedRow, 0));
            
            selectedBook=ClassBooksManager.showBook(selectedRegistry);
            form.getTxtAuthor().setText(selectedBook.getAuthor());
            form.getTxtEditorial().setText(selectedBook.getEditorial());
            form.getTxtID().setText(selectedBook.getId());
            form.getTxtState().setText(selectedBook.getState());
            form.getTxtSubject().setText(selectedBook.getSubject());
            form.getTxtTitle().setText(selectedBook.getTitle());
        } catch (SQLException ex) {
            Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    private void update() {
        TableView tableview;
        
        ClassBooksManager.queryAll();
        tableview = new TableView(Connection.getVariableResultSet());
        form.getBooksTable().setModel(tableview);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Metodos Abstractos de MouseListener">
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    //</editor-fold>

    @Override
    public void insertUpdate(DocumentEvent e) {
        TableView tableview;
        String txtField="";
        
        txtField=form.getTxtSearch().getText();
                                   
        ClassBooksManager.search(txtField);
        form.getBooksTable().setModel(tableview=new TableView(Connection.getVariableResultSet()));
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        TableView tableview;
        String txtField="";
        
        txtField=form.getTxtSearch().getText();
                                          
        if(txtField.equals("")){
            update();     
        }
        else{
            ClassBooksManager.search(txtField);
            form.getBooksTable().setModel(tableview=new TableView(Connection.getVariableResultSet()));
        }                                    
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}