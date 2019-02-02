/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.DAO;

import com.locadora.model.Filme;
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
public class FilmeDAO extends ExecuteSQL{
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a){
        String sql = "INSERT INTO tb_filme VALUES(0,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setString(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setString(4, a.getCapa());
            ps.setString(5, a.getCod_cartegoria());
            ps.setString(6, a.getCod_classificacao());
            
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso!";
            }else{
                return "Erro ao Inserir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<Filme> ListarComboFilme(){
        String sql = "select titulo from tb_filme order by titulo";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setTitulo(rs.getString(1));
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
    
    public List<Filme> ConsultaCodigoFilme(String nome){
        
        String sql = "SELECT idfilme, capa FROM tb_filme WHERE titulo = '"+nome+"'";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setCapa(rs.getString(2));
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
    
     public List<Filme> CapturarCapa(int cod){
        
        String sql = "SELECT idfilme, capa FROM tb_filme WHERE idfilme = '"+cod+"'";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setCapa(rs.getString(2));
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
    
    public List<Filme> ListarFilme(){
        String sql = "SELECT idfilme,titulo,ano,duracao, tb_categoria.nome, tb_classificacao.nome FROM tb_filme "
                + "INNER JOIN tb_categoria ON tb_filme.tb_categoria_idcategoria = tb_categoria.idcategoria "
                + "INNER JOIN tb_classificacao ON tb_filme.tb_classificacao_idclassificacao = tb_classificacao.idclassificacao";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getString(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_cartegoria(rs.getString(5));
                    a.setCod_classificacao(rs.getString(6));
                    
                    
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
    
    public List<Filme> PesquisarTituloFilme(String titulo){
        String sql = "SELECT idfilme,titulo,ano,duracao, tb_categoria.nome, tb_classificacao.nome FROM tb_filme "
                + "INNER JOIN tb_categoria ON tb_filme.tb_categoria_idcategoria = tb_categoria.idcategoria "
                + "INNER JOIN tb_classificacao ON tb_filme.tb_classificacao_idclassificacao = tb_classificacao.idclassificacao"
                + "WHERE titulo LIKE '%"+titulo+"%'";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getString(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_cartegoria(rs.getString(5));
                    a.setCod_classificacao(rs.getString(6));
                    
                    
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
    public List<Filme> PesquisarCodFilme(int cod){
        String sql = "SELECT idfilme,titulo,ano,duracao, tb_categoria.nome, tb_classificacao.nome FROM tb_filme "
                + "INNER JOIN tb_categoria ON tb_filme.tb_categoria_idcategoria = tb_categoria.idcategoria "
                + "INNER JOIN tb_classificacao ON tb_filme.tb_classificacao_idclassificacao = tb_classificacao.idclassificacao"
                + "WHERE idfilme = '"+cod+"'";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getString(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_cartegoria(rs.getString(5));
                    a.setCod_classificacao(rs.getString(6));
                    
                    
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
    
    public boolean TestarFilme(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM tb_filme where idfilme = '"+cod+"'";
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
    
    public List<Filme> CapturarFilme(int cod){
        String sql = "SELECT * FROM tb_filme WHERE idfilme = '"+cod+"'";
        List<Filme> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Filme a = new Filme();
                    
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getString(3));
                    a.setDuracao(rs.getString(4));
                    a.setCapa(rs.getString(5));
                    a.setCod_cartegoria(rs.getString(6));
                    a.setCod_classificacao(rs.getString(7));
                    
                    
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
    
    public String AlterarFilme(Filme a){
        String sql = "UPDATE tb_filme SET titulo = ?, ano = ?, duracao = ?, capa = ?"
                + ",tb_categoria_idcategoria = ?, tb_classificacao_idclassificacao = ? WHERE idfilme = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setString(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setString(4, a.getCapa());
            ps.setString(5, a.getCod_cartegoria());
            ps.setString(6, a.getCod_classificacao());            
            ps.setInt(7, a.getCodigo());
            
            if(ps.executeUpdate() > 0){
                return "Atualizado com Sucesso!";
            }else{
                return "Erro ao Atualizar";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public String ExcluirFilme(Filme a){
        String sql = "DELETE FROM tb_filme WHERE idfilme = ?";
        
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