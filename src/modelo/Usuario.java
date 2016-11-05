/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Leonardo
 */
public class Usuario extends Registro{
    private Integer id_usuario;
    private String nome;
    private String telefone;
    private String tipo;
    private String login;
    private Integer n_exemplares;
    private Integer multa;

    public Usuario() {
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getN_exemplares() {
        return n_exemplares;
    }

    public void setN_exemplares(Integer n_exemplares) {
        this.n_exemplares = n_exemplares;
    }

    public Integer getMulta() {
        return multa;
    }

    public void setMulta(Integer multa) {
        this.multa = multa;
    }
    
}  
