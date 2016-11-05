/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Registros;
import modelo.Usuario;

/**
 *
 * @author Leonardo
 */
public class EmprestimosDAO extends Registros<Emprestimo> {

    public EmprestimosDAO() {
        setSqlInsercao("INSERT INTO emprestimos (id_livro, id_usuario, dt_retirada, dt_entrega) VALUES (?, ?, ?, ?)");
        setSqlAlteracao("UPDATE emprestimos SET id_livro = ?, id_usuario = ?, dt_entrega = ?, dt_retirada = ? WHERE id_emprestimo = ?");
        setSqlExclusao("DELETE FROM emprestimos WHERE id_emprestimo = ?");
        setSqlBuscaChavePrimaria("SELECT * FROM emprestimos WHERE id_emprestimo = ?");
        setSqlBuscaTodos("SELECT * FROM emprestimos");
        setSqlBusca("select e.*, u.nome, l.titulo from emprestimos as e\n"
                    +"inner join livros as l on e.id_livro  = l.id_livro\n"
                    +"inner join usuarios as u on e.id_usuario = u.id_usuario");
 
    }

    protected void preencherInsercaoEmpRes(PreparedStatement ps, Emprestimo t, int id_livro, int id_user) throws SQLException {
        ps.setInt(1, id_livro);
        ps.setInt(2, id_user);
        ps.setDate(3, t.getDt_retirada());
        ps.setDate(4, t.getDt_entrega());
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Emprestimo t) throws SQLException {
        ps.setInt(1, t.getLivro().getId_livro());
        ps.setInt(2, t.getUser().getId_usuario());
        ps.setDate(3, t.getDt_entrega());
        ps.setDate(4, t.getDt_retirada());
        ps.setInt(5, t.getId_emprestimo());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Emprestimo t) throws SQLException {
        ps.setInt(1, t.getId_emprestimo());
    }

    @Override
    protected Emprestimo preencher(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Collection<Emprestimo> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Emprestimo> retorno = new ArrayList<Emprestimo>();
        LivrosDAO daoLivro = new LivrosDAO();
        UsuariosDAO daoUser = new UsuariosDAO();
        while (rs.next()) {
            Emprestimo temp = new Emprestimo();
            temp.setDt_entrega(rs.getDate("dt_entrega"));
            temp.setDt_retirada(rs.getDate("dt_retirada"));
            temp.setLivro((Livro) daoLivro.buscarElemento(rs.getInt("id_livro")));
            temp.setUser((Usuario) daoUser.buscarElemento(rs.getInt("id_usuario")));
            temp.setId_emprestimo(rs.getInt("id_emprestimo"));
            retorno.add(temp);
        }
        return retorno;
    }

    @Override
    protected void preencherInsercao(PreparedStatement ps, Emprestimo t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
