package gestionlibros;

import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BooksForm extends javax.swing.JFrame {

    private Events classEvents;
    private TableView ClassTable=null;
    
    public BooksForm(ResultSet tablecontent, Events classEvents) {
        initComponents();
        try{
            this.setLocationRelativeTo(null);
            this.classEvents = classEvents;
            buttonNewBook.addActionListener(classEvents);
            ButtonDeleteBook.addActionListener(classEvents);
            ButtonModify.addActionListener(classEvents);
            ButtonExit.addActionListener(classEvents);
            BooksTable.addMouseListener(classEvents);
            txtSearch.getDocument().addDocumentListener(classEvents);
            ClassTable=new TableView(tablecontent);
            BooksTable.setModel(ClassTable);
        }catch (Exception e){
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BooksTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        buttonNewBook = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ButtonDeleteBook = new javax.swing.JButton();
        ButtonModify = new javax.swing.JButton();
        ButtonExit = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(BooksTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 720, 213));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 59, -1));
        jPanel1.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 236, -1));
        jPanel1.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 236, -1));
        jPanel1.add(txtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 236, -1));
        jPanel1.add(txtSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 130, -1));

        jLabel1.setText("Codigo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Titulo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, -1));

        jLabel3.setText("Autor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel4.setText("Editorial");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel5.setText("Asignatura");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, 20));

        jLabel6.setText("Estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));
        jPanel1.add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 440, 290));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonNewBook.setText("Nuevo libro");
        jPanel2.add(buttonNewBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 110, 170));

        ButtonDeleteBook.setText("Quitar libro");
        jPanel2.add(ButtonDeleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        ButtonModify.setText("Modificar");
        jPanel2.add(ButtonModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 110, -1));

        ButtonExit.setText("Salir");
        jPanel2.add(ButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 110, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 290, 290));
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 370, -1));

        jLabel7.setText("Buscador:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BooksTable;
    private javax.swing.JButton ButtonDeleteBook;
    private javax.swing.JButton ButtonExit;
    private javax.swing.JButton ButtonModify;
    private javax.swing.JButton buttonNewBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtAuthor() {
        return txtAuthor;
    }

    public JTextField getTxtEditorial() {
        return txtEditorial;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public JTextField getTxtState() {
        return txtState;
    }

    public JTextField getTxtSubject() {
        return txtSubject;
    }

    public JTextField getTxtTitle() {
        return txtTitle;
    }

    public JButton getButtonDeleteBook() {
        return ButtonDeleteBook;
    }

    public JButton getButtonExit() {
        return ButtonExit;
    }

    public JButton getButtonModify() {
        return ButtonModify;
    }

    public JButton getButtonNewBook() {
        return buttonNewBook;
    }

    public JTable getBooksTable() {
        return BooksTable;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }
}