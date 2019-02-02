/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.DAO;

import com.locadora.model.Categoria;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheus
 */
public class CategoriaDAO extends ExecuteSQL{
    
    public CategoriaDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Categoria(Categoria a){
        String sql = "INSERT INTO tb_categoria VALUES(0,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
           
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso!";
            }else{
                return "Erro ao Inserir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<Categoria> ListarComboCategoria(){
        String sql = "select nome from tb_categoria order by nome";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }
                
                return lista;
            }else{
                return lista;
            }
        }catch(SQLException e){
            return null;
        }
    }
    
    public List<Categoria> ConsultaCodigoCategoria(String nome){
        
        String sql = "SELECT idcategoria FROM tb_categoria WHERE nome = '"+nome+"'";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                
                return lista;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Categoria> ListarCategoria(){
        String sql = "SELECT idcategoria, nome from tb_categoria";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
                    
                    lista.add(a);
                }
                
                return lista;
            }else{
                return lista;
            }
        }catch(SQLException e){
            return null;
        }
    }
    
    public List<Categoria> PesquisarNomeCategoria(String nome){
        String sql = "SELECT idcategoria, nome from tb_categoria WHERE nome LIKE '%"+nome+"%'";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
                    
                    lista.add(a);
                }
                
                return lista;
            }else{
                return lista;
            }
        }catch(SQLException e){
            return null;
        }
    }
    
   public List<Categoria> PesquisarCodCategoria(int cod){
        String sql = "SELECT idcategoria, nome from tb_categoria WHERE idcategoria = '"+cod+"'";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
                    
                    lista.add(a);
                }
                
                return lista;
            }else{
                return lista;
            }
        }catch(SQLException e){
            return null;
        }
    }
   
   public boolean TestarCategoria(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM tb_categoria where idcategoria = '"+cod+"'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Resultado = true;
                }
            }
            
        }catch(SQLException ex){
            ex.getMessage();
        }
        return Resultado;
    }
    
    public List<Categoria> CapturarCategoria(int cod){
        String sql = "SELECT * FROM tb_categoria WHERE idcategoria = '"+cod+"'";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Categoria a = new Categoria();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    
                    
                    lista.add(a);
                }
                
                return lista;
            }else{
                return lista;
            }
        }catch(SQLException e){
            return null;
        }
    }
    
    public String AlterarCategoria(Categoria a){
        String sql = "UPDATE tb_categoria SET nome = ? WHERE idcategoria = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
                       
            ps.setInt(2, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Atualizado com Sucesso!";
            }else{
                return "Erro ao Atualizar";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public String ExcluirCategoria(Categoria a){
        String sql = "DELETE FROM tb_categoria WHERE idcategoria = ?";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    
    
}
