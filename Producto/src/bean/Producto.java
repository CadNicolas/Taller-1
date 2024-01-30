package bean;

import java.sql.SQLException;
import java.util.List;

public abstract class Producto {
    private int id;
    private String cantidad;
    private String nombres;
    private String valuno;
    private String base;
	
    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getValuno() {
        return valuno;
    }

    public void setValuno(String valuno) {
        this.valuno = valuno;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
    
    public abstract void Insertar()throws SQLException;
    public abstract void Actualizar()throws SQLException;
    public abstract void Eliminar()throws SQLException;
    public abstract List Listar()throws SQLException;
}
