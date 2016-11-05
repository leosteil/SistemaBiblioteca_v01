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
import modelo.Reserva;
import modelo.Usuario;

/**
 *
 * @author Leonardo
 */
public class ReservasDAO extends Registros<Reserva>{
    
    public ReservasDAO() {
        setSqlInsercao("INSERT INTO reservas (id_livro, id_usuario, dt_reserva) VALUES (?, ?, ?)");
        setSqlAlteracao("UPDATE emprestimos SET id_livro = ?, id_usuario = ?, dt_entrega = ?, dt_retirada = ? WHERE id_emprestimo = ?");
        setSqlExclusao("DELETE FROM emprestimos WHERE id_emprestimo = ?");
        setSqlBuscaChavePrimaria("SELECT * FROM livros WHERE codigo = ?");
        setSqlBuscaTodos("SELECT * FROM reservas");
        setSqlBusca("select e.*, u.nome, l.titulo from emprestimos as e\n"
                    +"inner join livros as l on e.id_livro  = l.id_livro\n"
                    +"inner join usuarios as u on e.id_usuario = u.id_usuario");
 
    }
    
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Reserva t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Reserva t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Reserva t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Reserva preencher(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Collection<Reserva> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Reserva> retorno = new ArrayList<Reserva>();
        LivrosDAO daoLivro = new LivrosDAO();
        UsuariosDAO daoUser = new UsuariosDAO();
        while (rs.next()) {
            Reserva temp = new Reserva();
            temp.setDt_reserva(rs.getDate("dt_reserva"));
            temp.setLivro((Livro) daoLivro.buscarElemento(rs.getInt("id_livro")));
            temp.setUser((Usuario) daoUser.buscarElemento(rs.getInt("id_usuario")));
            temp.setId_reserva(rs.getInt("id_reserva"));
            retorno.add(temp);
        }
        return retorno;
    }

    @Override
    protected void preencherInsercaoEmpRes(PreparedStatement ps, Reserva t, int id_livro, int id_user) throws SQLException {
        ps.setInt(1, id_livro);
        ps.setInt(2, id_user);
        ps.setDate(3, t.getDt_reserva());
    }
    
}
