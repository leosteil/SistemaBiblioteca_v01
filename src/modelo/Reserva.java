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
public class Reserva extends Registro{
    private Integer id_reserva;
    private Livro livro;
    private Usuario user;
    private Date dt_reserva;

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
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

    public Date getDt_reserva() {
        return dt_reserva;
    }

    public void setDt_reserva(Date dt_reserva) {
        this.dt_reserva = dt_reserva;
    }
}
