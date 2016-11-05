/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Leonardo
 */
public class Emprestimo extends Registro{
    private Integer id_emprestimo;
    private Livro livro;
    private Usuario user;
    private Date dt_retirada;
    private Date dt_entrega; 
    private Integer multa;

    public Integer getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(Integer id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Date getDt_retirada() {
        return dt_retirada;
    }

    public void setDt_retirada(Date dt_retirada) {
        this.dt_retirada = dt_retirada;
    }

    public Date getDt_entrega() {
        return dt_entrega;
    }

    public void setDt_entrega(Date dt_entrega) {
        this.dt_entrega = dt_entrega;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Integer getMulta() {
        return multa;
    }

    public void setMulta(Integer multa) {
        this.multa = multa;
    }
}
