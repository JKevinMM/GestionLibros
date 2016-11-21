package gestionlibros;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class TableView extends AbstractTableModel{
    ResultSet VarResulset;
    ResultSetMetaData VarMetada;
    int numColumns;
    int numRows; 
    
    public TableView(ResultSet rs){ 
        this.VarResulset=rs;
        try{
            VarMetada=rs.getMetaData();
            VarResulset.last();
            numRows=VarResulset.getRow();
            numColumns=VarMetada.getColumnCount();
        }catch(SQLException ex){   
        }
    }
    
    @Override
    public int getRowCount(){
        return numRows;
    }
 
    @Override
    public int getColumnCount(){
        return numColumns;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        try{
            VarResulset.absolute(rowIndex+1);
            Object o=VarResulset.getObject(columnIndex +1);
            return o;
        }catch (SQLException ex){
            return ex.toString();
        }
    }
}