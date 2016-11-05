/*
 * Nesta classe serão realizados alguns tratamentos necessários para
 * algumas funcionalidades do programa, tentando assim deixar os códigos
 * das view mais claros
 */
package negocio;

import View.FormNovoEmprestimo;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import modelo.DAOS.LivrosDAO;
import modelo.DAOS.ReservasDAO;
import modelo.DAOS.UsuariosDAO;
import modelo.Reserva;

public class Negocios {

    /*Retorna a data de devolução do livro*/
    public Date dataRetirada(String dataRetirada, SimpleDateFormat formato) {
        java.util.Date data = new java.util.Date();
        try {
            data = formato.parse(dataRetirada);
        } catch (ParseException ex) {

            Logger.getLogger(FormNovoEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date dt = new java.sql.Date(data.getTime());
        return dt;
    }

    /*Retorna a data de devolução do livro*/
    public Date dataEntrega(Usuario u) {
        Calendar c = Calendar.getInstance();

        if (u.getTipo().equals("Aluno")) {
            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 7);
        } else if (u.getTipo().equals("Professor")) {
            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 15);
        }

        java.util.Date data = c.getTime();
        java.sql.Date dt = new java.sql.Date(data.getTime());

        return dt;
    }

    /*Retorna disponibilidade do livro*/
    public boolean disponibilidadeLivro(Livro livro) {
        if (livro.getEmprestado() == false && livro.getReservado() == false) {
            return true;
        } else {
            return false;
        }
    }

    /*Verifica o numero de emprestimos que o usuario tem*/
    /*Faz a diferenciação do tipo de usuario: Aluno e Professor*/
    public boolean numeroEmprestimos(Usuario u) {
        if (u.getTipo().equals("Aluno") && u.getN_exemplares() < 3) {
            return true;
        } else if (u.getTipo().equals("Aluno") && u.getN_exemplares() >= 3) {
            return false;
        } else if (u.getTipo().equals("Professor") && u.getN_exemplares() < 5) {
            return true;
        } else if (u.getTipo().equals("Professor") && u.getN_exemplares() >= 5) {
            return false;
        }
        return false;
    }
    
    /*Verifica se o livro devolvido passou da data de entrega*/
    /*Devolve o valor da multa*/
    public int controlaMulta(Emprestimo emp, Date dataRecebimento) {
        UsuariosDAO daoUser = new UsuariosDAO();
        Usuario u1 = daoUser.buscarElemento(emp.getUser().getId_usuario());

        Calendar dInicial = Calendar.getInstance();
        dInicial.setTime(dataRecebimento);
        Calendar dFinal = Calendar.getInstance();
        dFinal.setTime(emp.getDt_entrega());
       
        
        long diff = emp.getDt_entrega().getTime() - dataRecebimento.getTime();
        int nDias = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
              
        
        if(nDias >=0){
            return 0;
        }else{
            return nDias * (-1);
        }
    }
    
    /*Verifica se o usuario possui alguma multa vigente*/
    public boolean verificaMulta(Usuario u){
        if(u.getMulta() >0){
            return true; // possui multa
        }else return false; //não possui multa
    }
    
    /*Para renovar, não pode ser depois da data de entrega*/
    /*Verifica se o livro está atrasado*/
    /*Função usada para a renovação*/
    public boolean verificaAtraso(Emprestimo emp, Date dataRenovacao){
        Calendar dInicial = Calendar.getInstance();
        dInicial.setTime(dataRenovacao);
        Calendar dFinal = Calendar.getInstance();
        dFinal.setTime(emp.getDt_entrega());
        
        long diff = emp.getDt_entrega().getTime() - dataRenovacao.getTime();
        int nDias = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        
        if(nDias >= 0){
            return true;
        }else return false;
        
    }
    
    /*Se o usuario possui multa, não pode retirar livro*/
    public boolean usuarioBloqueado(Usuario u){
        if(u.getMulta() > 0){
            return false;
        }
        return true;
    }
    
    /*Verifica se o livro já esta reservado*/
    public boolean verificaReserva(Livro l){
        if(l.getReservado() == true){
            return false;
        }else return true;
    }
    
    /*Verifica se o login já é existente*/
    public boolean verificaLogin(Usuario u) throws SQLException{
        UsuariosDAO daoU = new UsuariosDAO();
        Collection<Usuario> colecao = new ArrayList<Usuario>();
        colecao = daoU.buscarTodos();       
        for (Usuario user : colecao){
            if(user.getLogin().equals(u.getLogin()))
                return true; //existe login igual
        }
        return false; //não existe login igual
    }
    
    /*Função que verifica se o usuario possui uma reserva em seu nome*/
    public boolean usuarioPossuiReserva(Usuario u) throws SQLException{
        ReservasDAO daoRes = new ReservasDAO();
        Collection<Reserva> colecao = new ArrayList<Reserva>();
        colecao = daoRes.buscarTodos();
        for(Reserva r : colecao){
            if(r.getUser().getId_usuario() == u.getId_usuario()){
                return true; //retorna true se existe alguma reserva relacionado com o usuario
            }
        }
        
        return false;
    }
}

    