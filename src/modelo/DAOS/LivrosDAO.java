/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAOS;

import View.FormConsultaLivros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;
import modelo.Livro;
import modelo.Registros;

/**
 *
 * @author Leonardo
 */
public class LivrosDAO extends Registros<Livro> {

    public LivrosDAO() {
        setSqlInsercao("INSERT INTO livros (isbn, titulo, autores, edicao, editora, ano, emprestado, reservado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        setSqlAlteracao("UPDATE livros SET isbn = ?, titulo = ?, autores = ?, edicao = ?, editora = ?, ano = ?, emprestado = ?, reservado = ? WHERE id_livro = ?");
        setSqlExclusao("DELETE FROM livros WHERE isbn = ?");
        setSqlBuscaChavePrimaria("SELECT * FROM livros WHERE id_livro = ?");
        setSqlBuscaTodos("SELECT * FROM livros");
        setSqlBusca("");
    }

    @Override
    protected void preencherInsercao(PreparedStatement ps, Livro t) throws SQLException {
        ps.setInt(1, t.getIsbn());
        ps.setString(2, t.getTitulo());
        ps.setString(3, t.getAutores());
        ps.setString(4, t.getEdicao());
        ps.setString(5, t.getEditora());
        ps.setInt(6, t.getAno());
        ps.setBoolean(7, false);
        ps.setBoolean(8, false);
        
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Livro t) throws SQLException {
        ps.setInt(1, t.getIsbn());
        ps.setString(2, t.getTitulo());
        ps.setString(3, t.getAutores());
        ps.setString(4, t.getEdicao());
        ps.setString(5, t.getEditora());
        ps.setInt(6, t.getAno());
        ps.setBoolean(7, t.getEmprestado());
        ps.setBoolean(8, t.getReservado());
        ps.setInt(9, t.getId_livro());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Livro t) throws SQLException {
        ps.setInt(1, t.getIsbn());
    }

    @Override
    protected Livro preencher(ResultSet rs) throws SQLException {
        Livro livro = new Livro();
        if (rs.next()) {
            livro.setAno(rs.getInt("ano"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutores(rs.getString("autores"));
            livro.setEditora(rs.getString("editora"));
            livro.setEdicao(rs.getString("edicao"));
            livro.setEmprestado(rs.getBoolean("emprestado"));
            livro.setId_livro(rs.getInt("id_livro"));
            livro.setIsbn(rs.getInt("isbn"));
            livro.setReservado(rs.getBoolean("reservado"));
        }
        return livro;
    }

    @Override
    protected Collection<Livro> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Livro> retorno = new ArrayList<Livro>();
        while (rs.next()) {
            Livro temp = new Livro();
            temp.setIsbn(rs.getInt("isbn"));
            temp.setTitulo(rs.getString("titulo"));
            temp.setAno(rs.getInt("ano"));
            temp.setAutores(rs.getString("autores"));
            temp.setEditora(rs.getString("editora"));
            temp.setEdicao(rs.getString("edicao"));
            temp.setEmprestado(rs.getBoolean("emprestado"));
            temp.setReservado(rs.getBoolean("reservado"));
            temp.setId_livro(rs.getInt("id_livro"));
            retorno.add(temp);
        }
        return retorno;
    }

    @Override
    protected void preencherInsercaoEmpRes(PreparedStatement ps, Livro t, int id_livro, int id_user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
