package br.com.caelum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

 /*
 * @author fredaum
 */
public class ContatoDAO {
    
    //Conexão com banco de dados.
    private Connection connection;
    
    public ContatoDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adiciona(Contato contato) {
        String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";
        
        
        try {
            //prepared statement para inserção.
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            //seta os valores.
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            
            // executa
            stmt.execute();
            stmt.close();
        }   catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Contato> getLista() {
        try {
            //criando array list.
        List<Contato> contatos = new ArrayList<Contato>();
            //criando conexão.
        PreparedStatement stmt = connection.prepareStatement("select * from contatos");
        //result set é parecido com iterator do list.
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            //criando objeto.
            Contato contato = new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));
            
            // montando a data através do Calendar
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            contato.setDataNascimento(data);
            
            
            //adicionando o objeto à lista
            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        return contatos;
        } catch (SQLException e) {
            throw new DAOException("Ocorreu um erro!");
        }
    }
    
    public List<Contato> getPesquisa(long id){
        String sql = "select * from contatos where id = ";
        try {
        List<Contato> contatos = new ArrayList<Contato>();
        PreparedStatement stmt = connection.prepareStatement(sql + id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Contato contato = new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));
            
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            contato.setDataNascimento(data);
            
            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        return contatos;
        } catch (SQLException e) {
            throw new DAOException("Ocorreu um erro!");
        }
    }
    
    public void altera(Contato contato) {
        String sql = "update contatos set nome = ?, email = ?, endereco = ?," +
                "dataNascimento = ? where id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException("Ocorreu um erro!");
        }
    }
    
    public void remove(Contato contato){
        try {
            PreparedStatement stmt = 
                    connection.prepareStatement("delete from contatos where id = ?");
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException("Ocorreu um erro!");
        }
    }
}
