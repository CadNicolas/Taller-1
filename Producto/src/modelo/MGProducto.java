package modelo;

import dao.ProductoDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class MGProducto extends AbstractTableModel{
    List<ProductoDAO> lista;
    String cabecera[]={"Id","Nombre","Cantidad","Valor Unitario","BD"};

    public MGProducto(List<ProductoDAO> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

    public String getColumnName(int index){
        return cabecera[index];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductoDAO oPrueba=lista.get(rowIndex);
        switch(columnIndex){
            case 0: return oPrueba.getId();
            case 1: return oPrueba.getCantidad();
            case 2: return oPrueba.getNombres();
            case 3: return oPrueba.getValuno();
            case 4: return oPrueba.getBase();
            default:return null;
        }
    }
    
}
