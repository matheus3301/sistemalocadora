/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.DAO;

import com.locadora.model.Categoria;
import com.locadora.model.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheus
 */
public class ClassificacaoDAO extends ExecuteSQL{
    
    public ClassificacaoDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Classificacao(Classificacao a){
        String sql = "INSERT INTO tb_classificacao VALUES(0,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getPreco());
           
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso!";
            }else{
                return "Erro ao Inserir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<Classificacao> ListarComboClassificacao(){
        String sql = "select nome from tb_classificacao order by nome";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
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
    
    public List<Classificacao> ConsultaCodigoClassificacao(String nome){
        
        String sql = "SELECT idclassificacao FROM tb_classificacao WHERE nome = '"+nome+"'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
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
    
    public List<Classificacao> ListarClassificacao(){
        String sql = "SELECT idclassificacao, nome, preco from tb_classificacao";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getString(3));
                    
                    
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
    
     public List<Classificacao> PesquisarNomeClassificacao(String nome){
        String sql = "SELECT idclassificacao, nome, preco from tb_classificacao WHERE nome LIKE '%"+nome+"%'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getString(3));
                    
                    
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
     public List<Classificacao> PesquisarCodClassificacao(int cod){
        String sql = "SELECT idclassificacao, nome, preco from tb_classificacao WHERE idclassificacao = '"+cod+"'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getString(3));
                    
                    
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
     
     public boolean TestarClassificacao(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM tb_classificacao where idclassificacao = '"+cod+"'";
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
    
    public List<Classificacao> CapturarClassificacao(int cod){
        String sql = "SELECT * FROM tb_classificacao WHERE idclassificacao = '"+cod+"'";
        List<Classificacao> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Classificacao a = new Classificacao();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setPreco(rs.getString(3));
                    
                    
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
    
    public String AlterarCategoria(Classificacao a){
        String sql = "UPDATE tb_classificacao SET nome = ?, preco = ? WHERE idclassificacao = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
                       
            ps.setInt(3, a.getCodigo());
            
            ps.setString(2, a.getPreco());
            
            if(ps.executeUpdate() > 0){
                return "Atualizado com Sucesso!";
            }else{
                return "Erro ao Atualizar";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    } 
    
     public String ExcluirClassificacao(Classificacao a){
        String sql = "DELETE FROM tb_classificacao WHERE idclassificacao = ?";
        
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
