/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fredaum
 */
@WebServlet(name = "AdicionaContatoServlet", urlPatterns = {"/adicionaContato"})
public class AdicionaContatoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //buscando o writer
        PrintWriter out = response.getWriter();
        
        //buscando os parâmetros no request
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        //fazendo a conversão da data.
        
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data!");
            return; //para a execução do método.
        }
        
        //montando o objeto contato.
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        
        //salva o contato
        ContatoDAO dao = new ContatoDAO();
        dao.adiciona(contato);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(request,response);
    }

    

}
