/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.DAO;

/**
 *
 * @author matheus
 */
import java.sql.*;
import com.locadora.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ExecuteSQL {
    public FuncionarioDAO(Connection con){
        super(con);
    }
    public boolean Logar(String login,String senha){
        boolean finalResult = false;
        
        try{
            String consulta = "select login, senha from tb_funcionario "
            + "where login = '"+login+"' and senha = '"+senha+"'";
            
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    
                    finalResult = true;
                }
            }
        } catch(SQLException ex){
            ex.getMessage();
        }
        
        return finalResult;
    }
    
    public String Inserir_Funcionario(Funcionario a){
        String sql = "INSERT INTO tb_funcionario VALUES(0,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getLogin());
            ps.setString(3, a.getSenha());
            
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso!";
            }else{
                return "Erro ao Inserir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<Funcionario> ListarFuncionario(){
        String sql = "SELECT idfuncionario, nome, login FROM tb_funcionario";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    
                    
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
    
    public List<Funcionario>  PesquisarNomeFuncionario(String nome){
        String sql = "SELECT idfuncionario, nome, login FROM tb_funcionario WHERE nome LIKE '%"+nome+"%'";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    
                    
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
    
    public List<Funcionario>  PesquisarCodFuncionario(int cod){
        String sql = "SELECT idfuncionario, nome, login FROM tb_funcionario WHERE idfuncionario = '"+cod+"'";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    
                    
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
    
    public boolean TestarFuncionario(int cod){
        boolean Resultado = false;
        try{
            String sql = "SELECT * FROM tb_funcionario where idfuncionario = '"+cod+"'";
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
    
    public List<Funcionario> CapturarFuncionario(int cod){
        String sql = "SELECT * FROM tb_funcionario WHERE idfuncionario = '"+cod+"'";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
                    
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
    
    public String AlterarFuncionario(Funcionario a){
        String sql = "UPDATE tb_funcionario SET nome = ?, login = ?, senha = ? WHERE idfuncionario = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getLogin());
            ps.setString(3, a.getSenha());
            ps.setInt(4, a.getCod());
            
            if(ps.executeUpdate() > 0){
                return "Atualizado com Sucesso!";
            }else{
                return "Erro ao Atualizar";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<Funcionario> ListarComboFuncionario(){
        String sql = "select nome from tb_funcionario order by nome";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
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
    
    public List<Funcionario> ConsultaCodigoFuncionario(String nome){
        
        String sql = "SELECT idfuncionario FROM tb_funcionario WHERE nome = '"+nome+"'";
        List<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
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
    
    public String ExcluirFuncionario(Funcionario a){
        String sql = "DELETE FROM tb_funcionario WHERE idfuncionario = ?";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            
            if(ps.executeUpdate() > 0){
                return "Excluído com sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public Funcionario CapturarLogin(String login, String senha){
        String sql = "SELECT * FROM tb_funcionario WHERE login = '"+login+"' AND  senha = '"+senha+"'";
        Funcionario a = new Funcionario();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    
                    
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
                    
                    
                }
                
                return a;
            }else{
                return a;
            }
        }catch(SQLException e){
            return null;
        }
    }
}
