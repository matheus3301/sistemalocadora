/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.locadora.DAO;

import com.locadora.model.DVD;
import com.locadora.model.Dvd_Filme;
import com.locadora.model.Filme;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matheus
 */
public class DVDDAO extends ExecuteSQL {

    public DVDDAO(Connection con) {
        super(con);
    }

    public String Inserir_DVD(DVD a) {
        String sql = "INSERT INTO tb_dvd VALUES(0,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, a.getPreco());
            ps.setString(2, a.getData_compra());
            ps.setString(3, a.getSituacao());
            ps.setString(4, a.getCod_filme());

            if (ps.executeUpdate() > 0) {
                return "Inserido com Sucesso!";
            } else {
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<DVD> ListarDVD() {
        String sql = "SELECT iddvd, tb_filme.titulo,situacao, preco_compra, data_compra FROM tb_dvd "
                + "INNER JOIN tb_filme ON tb_dvd.tb_filme_idfilme = tb_filme.idfilme";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();

                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getString(2));
                    a.setSituacao(rs.getString(3));
                    a.setPreco(rs.getString(4));
                    a.setData_compra(rs.getString(5));

                    lista.add(a);
                }

                return lista;
            } else {
                return lista;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<DVD> PesquisarCodDVD(int cod) {
        String sql = "SELECT iddvd, tb_filme.titulo,situacao, preco_compra, data_compra FROM tb_dvd "
                + "INNER JOIN tb_filme ON tb_dvd.tb_filme_idfilme = tb_filme.idfilme WHERE idfilme = '" + cod + "'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();

                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getString(2));
                    a.setSituacao(rs.getString(3));
                    a.setPreco(rs.getString(4));
                    a.setData_compra(rs.getString(5));

                    lista.add(a);
                }

                return lista;
            } else {
                return lista;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public List<DVD> PesquisarFilmeDVD(String filme) {
        String sql = "SELECT iddvd, tb_filme.titulo,situacao, preco_compra, data_compra FROM tb_dvd "
                + "INNER JOIN tb_filme ON tb_dvd.tb_filme_idfilme = tb_filme.idfilme WHERE tb_filme.titulo LIKE '%" + filme + "%'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();

                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getString(2));
                    a.setSituacao(rs.getString(3));
                    a.setPreco(rs.getString(4));
                    a.setData_compra(rs.getString(5));

                    lista.add(a);
                }

                return lista;
            } else {
                return lista;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    public boolean TestarSituacao(int cod) {
        boolean Resultado = false;
        try {
            String sql = "SELECT * FROM tb_dvd where iddvd = '" + cod + "' AND situacao = 'Disponível'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Resultado = true;
                }
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Resultado;
    }
    
    public boolean TestarDVD(int cod) {
        boolean Resultado = false;
        try {
            String sql = "SELECT * FROM tb_dvd where iddvd = '" + cod + "'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Resultado = true;
                }
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Resultado;
    }

    public List<DVD> CapturarDVD(int cod) {
        String sql = "SELECT * FROM tb_dvd WHERE iddvd = '" + cod + "'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();

                    a.setCodigo(rs.getInt(1));
                    a.setPreco(rs.getString(2));
                    a.setData_compra(rs.getString(3));
                    a.setSituacao(rs.getString(4));
                    a.setCod_filme(rs.getString(5));

                    lista.add(a);
                }

                return lista;
            } else {
                return lista;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public String AlterarDVD(DVD a) {
        String sql = "UPDATE tb_dvd SET preco_compra = ?, data_compra = ?, situacao = ?, tb_filme_idfilme = ? WHERE iddvd = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, a.getPreco());
            ps.setString(2, a.getData_compra());
            ps.setString(3, a.getSituacao());
            ps.setString(4, a.getCod_filme());
            ps.setInt(5, a.getCodigo());

            if (ps.executeUpdate() > 0) {
                return "Atualizado com Sucesso!";
            } else {
                return "Erro ao Atualizar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<DVD> ListarComboDVD() {
        String sql = "select iddvd, tb_filme.titulo from tb_dvd INNER JOIN tb_filme ON tb_dvd.tb_filme_idfilme = tb_filme.idfilme";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getString(2));
                    lista.add(a);
                }

                return lista;
            } else {
                return lista;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    public String ExcluirDVD(DVD a) {
        String sql = "DELETE FROM tb_dvd WHERE iddvd = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());

            if (ps.executeUpdate() > 0) {
                return "Excluído com sucesso!";
            } else {
                return "Erro ao Excluir!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
       public List<Dvd_Filme> CapturarLoca(int cod) {
        String sql = "SELECT iddvd, tb_filme.titulo, tb_filme.tb_categoria_idcategoria, tb_filme.tb_classificacao_idclassificacao, tb_classificacao.preco, tb_filme.capa FROM tb_dvd INNER JOIN tb_filme ON tb_dvd.tb_filme_idfilme = tb_filme.idfilme INNER JOIN tb_classificacao ON tb_filme.tb_classificacao_idclassificacao = tb_classificacao.idclassificacao WHERE iddvd = '" + cod + "'";
        List<Dvd_Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Dvd_Filme a = new Dvd_Filme();

                   a.setIddvd(rs.getString(1));
                   a.setTitulo(rs.getString(2));
                   a.setCategoria(rs.getString(3));
                   a.setClassificacao(rs.getString(4));
                   a.setPreco(rs.getString(5));
                   a.setCapa(rs.getString(6));

                    lista.add(a);
                }

                return lista;
            } else {
                return lista;
            }
        } catch (SQLException e) {
            return null;
        }
    }

}
