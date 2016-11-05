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
import modelo.Registros;
import modelo.Usuario;

/**
 *
 * @author Leonardo
 */
public class UsuariosDAO extends Registros<Usuario>{
    
     public UsuariosDAO() {
        setSqlInsercao("INSERT INTO usuarios (nome, tipo, login, telefone, n_exemplares, multa) VALUES (?, ?, ?, ?, ?, ?)");
        setSqlAlteracao("UPDATE usuarios SET nome = ?, tipo = ?, login = ?, telefone = ?, n_exemplares = ?, multa = ? WHERE id_usuario = ?");
        setSqlExclusao("DELETE FROM usuarios WHERE id_usuario = ?");
        setSqlBuscaChavePrimaria("SELECT * FROM usuarios WHERE id_usuario = ?");
        setSqlBuscaTodos("SELECT * FROM usuarios");
        setSqlBusca("");
    }


    @Override
    protected Collection<Usuario> preencherColecao(ResultSet rs) throws SQLException {
        Collection<Usuario> retorno = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario temp = new Usuario();
            temp.setNome(rs.getString("nome"));
            temp.setTelefone(rs.getString("telefone"));
            temp.setLogin(rs.getString("login"));
            temp.setTipo(rs.getString("tipo"));
            temp.setId_usuario(rs.getInt("id_usuario"));
            temp.setN_exemplares(rs.getInt("n_exemplares"));
            temp.setMulta(rs.getInt("multa"));
            retorno.add(temp);
        }
        return retorno;
    }

    @Override
    protected void preencherInsercao(PreparedStatement ps, Usuario t) throws SQLException {
        ps.setString(1, t.getNome());
        ps.setString(2, t.getTipo());
        ps.setString(3, t.getLogin());
        ps.setString(4, t.getTelefone());
        ps.setInt(5, 0); //numero de livro retirados ao inserir igual a 0
        ps.setInt(6, 0); //multa ao inserir igual a 0
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Usuario t) throws SQLException {
        ps.setString(1, t.getNome());
        ps.setString(2, t.getTipo());
        ps.setString(3, t.getLogin());
        ps.setString(4, t.getTelefone());
        ps.setInt(5, t.getN_exemplares());
        ps.setInt(6, t.getMulta());
        ps.setInt(7, t.getId_usuario());
        System.out.println("Entrei aqui: "+  t.getLogin());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Usuario t) throws SQLException {
        ps.setInt(1, t.getId_usuario());
    }

    @Override
    protected Usuario preencher(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        if(rs.next()){
           usuario.setNome(rs.getString("nome"));
           usuario.setId_usuario(rs.getInt("id_usuario"));
           usuario.setN_exemplares(rs.getInt("n_exemplares"));
           usuario.setTelefone(rs.getString("telefone"));
           usuario.setTipo(rs.getString("tipo"));
           usuario.setMulta(rs.getInt("multa"));
           usuario.setLogin(rs.getString("login"));
        }
        
        return usuario;
    }

    @Override
    protected void preencherInsercaoEmpRes(PreparedStatement ps, Usuario t, int id_livro, int id_user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
