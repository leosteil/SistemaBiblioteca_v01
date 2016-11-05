/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.DAOS.LivrosDAO;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class BDTeste {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        LivrosDAO cs = new LivrosDAO();
        
        
		System.out.println("Listando todos os livros...");
		for (Livro temp : cs.buscarTodos())
			System.out.println(temp.getIsbn()+ " - " + temp.getTitulo()+ " - "
                        + temp.getAutores()+ " - " + temp.getAno() + " - " + temp.getEdicao()+  " - "
                        + temp.getEditora()+ " - " + temp.getId_livro());
        
    }
}
