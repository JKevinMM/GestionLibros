package gestionlibros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ClassConnect {
    
    private Connection variableConnect=null;
    private ResultSet variableResultSet=null;
                                          
    
    public ClassConnect() {
        openConnect();
    }
    
    private void openConnect(){
        try{
            String sUrl = "jdbc:mysql://localhost:3306/biblioteca";
            variableConnect=DriverManager.getConnection(sUrl, "root", "");
            JOptionPane.showMessageDialog(null, "Conectado!!!!");
        }catch (SQLException ex){
            variableConnect=null;
            throw new RuntimeException("Error con la conexión!!!");
        }
    }
    
    public void runQuery (String sql) throws SQLException {
        Statement variableEstament = variableConnect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        variableResultSet = variableEstament.executeQuery(sql);
    }
    
    public int updateSQL(String sql) throws SQLException {
        int i=0;
            Statement variableEstament = variableConnect.createStatement();
            i = variableEstament.executeUpdate(sql);
        return i;
    }

    public ResultSet getVariableResultSet() {
        return variableResultSet;
    }
}