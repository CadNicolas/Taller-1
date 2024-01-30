package dao;

import bean.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;


public class ProductoDAO extends Producto {

    @Override
    public void Insertar() throws SQLException {
        PreparedStatement pstmt=null;
        Connection cnx=null;
        try{
            String sql="INSERT INTO persona(cantidad, nombres, valuno, base)VALUES(?,?,?,?)";
            cnx=Conexion.Obtener();
            pstmt=cnx.prepareStatement(sql);
            pstmt.setString(1, this.getCantidad());
            pstmt.setString(2, this.getNombres());
            pstmt.setString(3, this.getValuno());
            pstmt.setString(4, this.getBase());
            pstmt.execute();
        }finally{
            if(pstmt!=null)
                pstmt.close();
            
        }
    }

    @Override
    public void Actualizar() throws SQLException {
       PreparedStatement pstmt=null;
        Connection cnx=null;
        try{
            String sql="UPDATE persona SET cantidad=?, "
                    + "nombres=?, "
                    + "valuno=?, "
                    + "base=? "
                    + "WHERE id=?";
            cnx=Conexion.Obtener();
            pstmt=cnx.prepareStatement(sql);
            pstmt.setString(1, this.getCantidad());
            pstmt.setString(2, this.getNombres());
            pstmt.setString(3, this.getValuno());
            pstmt.setString(4, this.getBase());
            pstmt.setInt(5, this.getId());
            pstmt.execute();
        }finally{
            if(pstmt!=null)
                pstmt.close();
            
        }
    }

    @Override
    public void Eliminar() throws SQLException {
        PreparedStatement pstmt=null;
        Connection cnx=null;
        try{
            String sql="DELETE FROM persona WHERE id=?";
            cnx=Conexion.Obtener();
            pstmt=cnx.prepareStatement(sql);
            pstmt.setInt(1, this.getId());
            pstmt.execute();
        }finally{
            if(pstmt!=null)
                pstmt.close();
            
        }
    }

    @Override
    public List Listar() throws SQLException {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Connection cnx=null;
        List<ProductoDAO> lista= new ArrayList<>();
        try{
            String sql="SELECT * FROM persona";
            cnx=Conexion.Obtener();
            pstmt=cnx.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                ProductoDAO oPrueba= new ProductoDAO();
                oPrueba.setId(rs.getInt(1));
                oPrueba.setNombres(rs.getString(2));
                oPrueba.setCantidad(rs.getString(3));
                oPrueba.setValuno(rs.getString(4));
                oPrueba.setBase(rs.getString(5));
                lista.add(oPrueba);
            }
            return lista;
        }finally{
            if(pstmt!=null)
                pstmt.close();
            
            if(rs!=null)
                rs.close();
        }
    }
    
}
