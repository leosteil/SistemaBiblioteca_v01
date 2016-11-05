/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 * @param <T>
 */
public abstract class Registros<T extends Registro> {

    private String sqlInsercao;
    private String sqlAlteracao;
    private String sqlExclusao;
    private String sqlBuscaChavePrimaria;
    private String sqlBuscaTodos;
    private String sqlBusca;
    private String sqlAlteraEstado; //vai ser usado para setar empestimo ou reserva
    private String sqlBuscaElemento;

    /*sql de busca livros*/
 /*sql de busca livros*/
    public String getSqlInsercao() {
        return sqlInsercao;
    }

    public void setSqlInsercao(String sqlInsercao) {
        this.sqlInsercao = sqlInsercao;
    }

    public String getSqlAlteracao() {
        return sqlAlteracao;
    }

    public void setSqlAlteracao(String sqlAlteracao) {
        this.sqlAlteracao = sqlAlteracao;
    }

    public String getSqlExclusao() {
        return sqlExclusao;
    }

    public void setSqlExclusao(String sqlExclusao) {
        this.sqlExclusao = sqlExclusao;
    }

    public String getSqlBuscaChavePrimaria() {
        return sqlBuscaChavePrimaria;
    }

    public void setSqlBuscaChavePrimaria(String sqlBuscaChavePrimaria) {
        this.sqlBuscaChavePrimaria = sqlBuscaChavePrimaria;
    }

    public String getSqlBuscaTodos() {
        return sqlBuscaTodos;
    }

    public void setSqlBuscaTodos(String sqlBuscaTodos) {
        this.sqlBuscaTodos = sqlBuscaTodos;
    }

    public Connection abrir() {
        Connection c = null;
        try {
            Class.forName(BD.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Nao encontrou o driver chamado " + BD.JDBC_DRIVER + " na memoria");
        }
        try {
            c = DriverManager.getConnection(BD.URL_CONEXAO, BD.USUARIO, BD.SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public void inserir(T t) {
        Connection conexao = abrir();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlInsercao());
            preencherInsercao(ps, t);
            ps.execute();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirEmpRes(T t, int id_livro, int id_user) {
        Connection conexao = abrir();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlInsercao());
            preencherInsercaoEmpRes(ps, t, id_livro, id_user);
            ps.execute();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void alterar(T t) {
        Connection conexao = abrir();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlAlteracao());
            preencherAlteracao(ps, t);
            ps.execute();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(T t) {
        Connection conexao = abrir();
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlExclusao());
            preencherExclusao(ps, t);
            ps.execute();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Busca apenas 1 elemento*/
    public T buscarElemento(Integer cod) {
        Connection conexao = abrir();
        T temp = null;
        try {
            PreparedStatement ps = conexao.prepareStatement(getSqlBuscaChavePrimaria());
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            temp = preencher(rs);
            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /*Busca todos os elementos a partir de um SQL de busca gerado para cada necessidade*/
    public Collection<T> buscar() throws SQLException {
        Connection conexao = abrir();
        
        Statement s = conexao.createStatement();
        ResultSet rs = s.executeQuery(getSqlBusca());
        Collection<T> registros = preencherColecao(rs);
        rs.close();
        conexao.close();
        return registros;
    }

    /*Busca todos elementos*/
    public Collection<T> buscarTodos() throws SQLException {
        Connection conexao = abrir();
        Statement s = conexao.createStatement();
        ResultSet rs = s.executeQuery(getSqlBuscaTodos());
        Collection<T> registros = preencherColecao(rs);
        rs.close();
        conexao.close();
        return registros;
    }

    public String getSqlBusca() {
        return sqlBusca;
    }

    public void setSqlBusca(String sqlBusca) {
        this.sqlBusca = sqlBusca;
    }

    protected abstract void preencherInsercao(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preencherAlteracao(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preencherExclusao(PreparedStatement ps, T t) throws SQLException;

    protected abstract T preencher(ResultSet rs) throws SQLException;

    protected abstract Collection<T> preencherColecao(ResultSet rs) throws SQLException;

    protected abstract void preencherInsercaoEmpRes(PreparedStatement ps, T t, int id_livro, int id_user) throws SQLException;

}
