/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.DAO;

import com.locadora.model.Aluguel;
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
public class AluguelDAO extends ExecuteSQL {
    
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a){
        String sql = "INSERT INTO tb_aluguel VALUES(0,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getHorario());
            ps.setString(2, a.getData_aluguel());
            ps.setString(3, a.getData_devolucao());
            ps.setInt(4, a.getCoddvd());
            ps.setInt(5, a.getCodfunc());
            ps.setString(6, a.getCodcliente());
            ps.setString(7, "Pendente");
           
            
            if(ps.executeUpdate() > 0){
                return "Inserido com Sucesso!";
            }else{
                return "Erro ao Inserir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public String EfetuarDevolucao(int codlocacao){
        String sql = "UPDATE tb_aluguel SET status = ? WHERE idaluguel = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, "Devolvido");
                       
            ps.setInt(2, codlocacao);
            
            if(ps.executeUpdate() > 0){
                return "Devolvido com Sucesso!";
            }else{
                return "Erro ao Devolver";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public String AtualizarSituacao(String situacao, int coddvd){
        String sql = "UPDATE tb_dvd SET situacao = ? WHERE iddvd = ?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, situacao);
                       
            ps.setInt(2, coddvd);
            
            if(ps.executeUpdate() > 0){
                return "Atualizado com Sucesso!";
            }else{
                return "Erro ao Atualizar";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    
    public List<Aluguel> ListarAluguel(){
        String sql = "SELECT idaluguel, hora_aluguel, data_aluguel, data_devolucao, tb_cliente.nome, tb_dvd_iddvd, tb_funcionario.nome, status FROM tb_aluguel INNER JOIN tb_cliente ON tb_cliente_idcliente = tb_cliente.idcliente INNER JOIN tb_funcionario ON tb_funcionario.idfuncionario = tb_funcionario_idfuncionario";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    
                    a.setCod(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setData_devolucao(rs.getString(4));
                    a.setCodcliente(rs.getString(5));
                    a.setCoddvd(rs.getInt(6));
                    a.setNomeFunc(rs.getString(7));
                    a.setStatus(rs.getString(8));
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
    
    
    public List<Aluguel> PesquisarCodAluguel(int cod){
        String sql = "SELECT idaluguel, hora_aluguel, data_aluguel, data_devolucao, tb_cliente.nome, tb_dvd_iddvd, tb_funcionario.nome, status FROM tb_aluguel INNER JOIN tb_cliente ON tb_cliente_idcliente = tb_cliente.idcliente INNER JOIN tb_funcionario ON tb_funcionario.idfuncionario = tb_funcionario_idfuncionario WHERE idaluguel= '"+cod+"'";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    
                    a.setCod(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setData_devolucao(rs.getString(4));
                    a.setCodcliente(rs.getString(5));
                    a.setCoddvd(rs.getInt(6));
                    a.setNomeFunc(rs.getString(7));
                    a.setStatus(rs.getString(8));
                    
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
    
    public List<Aluguel> PesquisarCodDVD(int cod){
        String sql = "SELECT idaluguel, hora_aluguel, data_aluguel, data_devolucao, tb_cliente.nome, tb_dvd_iddvd, tb_funcionario.nome, status  FROM tb_aluguel INNER JOIN tb_cliente ON tb_cliente_idcliente = tb_cliente.idcliente INNER JOIN tb_funcionario ON tb_funcionario.idfuncionario = tb_funcionario_idfuncionario WHERE tb_dvd_iddvd = "+cod;
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    
                    a.setCod(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setData_devolucao(rs.getString(4));
                    a.setCodcliente(rs.getString(5));
                    a.setCoddvd(rs.getInt(6));
                    a.setNomeFunc(rs.getString(7));
                    a.setStatus(rs.getString(8));
                    
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
    
    public List<Aluguel> PesquisarNomeCliente(String nome){
        String sql = "SELECT idaluguel, hora_aluguel, data_aluguel, data_devolucao, tb_cliente.nome, tb_dvd_iddvd, tb_funcionario.nome, status FROM tb_aluguel INNER JOIN tb_cliente ON tb_cliente_idcliente = tb_cliente.idcliente INNER JOIN tb_funcionario ON tb_funcionario.idfuncionario = tb_funcionario_idfuncionario WHERE tb_cliente.nome LIKE '%"+nome+"%'";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    
                    a.setCod(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setData_devolucao(rs.getString(4));
                    a.setCodcliente(rs.getString(5));
                    a.setCoddvd(rs.getInt(6));
                    a.setNomeFunc(rs.getString(7));
                    a.setStatus(rs.getString(8));
                    
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
    
    public List<Aluguel> PesquisarNomeFull(String nome){
        String sql = "SELECT idaluguel, hora_aluguel, data_aluguel, data_devolucao, tb_cliente_idcliente, tb_dvd_iddvd, tb_funcionario.nome FROM tb_aluguel INNER JOIN tb_cliente ON tb_cliente_idcliente = tb_cliente.idcliente INNER JOIN tb_funcionario ON tb_funcionario.idfuncionario = tb_funcionario_idfuncionario WHERE status = 'Pendente' AND tb_cliente.nome = '"+nome+"'";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    
                    a.setCod(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setData_devolucao(rs.getString(4));
                    a.setCodcliente(rs.getString(5));
                    a.setCoddvd(rs.getInt(6));
                    a.setNomeFunc(rs.getString(7));
                    
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
    
    public List<Aluguel> PesquisarCodCliente(String cod){
        String sql = "SELECT idaluguel, hora_aluguel, data_aluguel, data_devolucao, tb_cliente.nome, tb_dvd_iddvd FROM tb_aluguel INNER JOIN tb_cliente ON tb_cliente_idcliente = tb_cliente.idcliente WHERE tb_cliente_idcliente = '"+cod+"'";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    
                    a.setCod(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setData_devolucao(rs.getString(4));
                    a.setCodcliente(rs.getString(5));
                    a.setCoddvd(rs.getInt(6));
                    
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
    
    public List<Aluguel> PesquisarCodClienteID(String cod){
        String sql = "SELECT idaluguel, hora_aluguel, data_aluguel, data_devolucao, tb_cliente_idcliente, tb_dvd_iddvd, tb_funcionario.nome FROM tb_aluguel INNER JOIN tb_cliente ON tb_cliente_idcliente = tb_cliente.idcliente INNER JOIN tb_funcionario ON tb_funcionario.idfuncionario = tb_funcionario_idfuncionario WHERE tb_cliente_idcliente = '"+cod+"' AND status = 'Pendente'";
        List<Aluguel> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Aluguel a = new Aluguel();
                    
                    a.setCod(rs.getInt(1));
                    a.setHorario(rs.getString(2));
                    a.setData_aluguel(rs.getString(3));
                    a.setData_devolucao(rs.getString(4));
                    a.setCodcliente(rs.getString(5));
                    a.setCoddvd(rs.getInt(6));
                    a.setNomeFunc(rs.getString(7));
                    
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
    
}
