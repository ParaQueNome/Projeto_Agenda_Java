package dao.factories;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

import domain.ContatoVO;

public class ContatoMySqliDAO implements IContatoDAO {
    // Inversao de dependencia
    private Connection connection;
    private final Logger logger;
    public ContatoMySqliDAO(Connection connection) {
        this.connection = connection;
        this.logger = Logger.getLogger(this.getClass().getSimpleName());
    }

    @Override
    public void salvar(ContatoVO contato) {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO contatos (")
                .append("nome, email, telefone, linkedin) ")
                .append("values('%s', '%s', '%s', '%s')");

        String query = String.format(builder.toString(),
                contato.getNome(),
                contato.getEmail(),
                contato.getTelefone(),
                contato.getLinkedin());
                
        try (Statement stm = connection.createStatement()) {
            stm.execute(query);
        } catch (SQLException e) {
           e.printStackTrace();
        }

    }
         
    
    @Override
    public void atualizar(ContatoVO contato) {
        // TODO: atualizar informações no bando de dados
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE contatos SET nome = '%s', email = '%s', telefone = '%s', linkedin = '%s' WHERE id = %d");
        String query = String.format(builder.toString(),
        contato.getNome(),
        contato.getEmail(),
        contato.getTelefone(),
        contato.getLinkedin(),
        contato.getId());
        try(Statement stm = connection.createStatement()){
            stm.execute(query);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        
    }

    @Override
    public void excluir(Integer id) {
        // TODO: excluir contato do banco de dados
        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM contatos WHERE id = %d");
        String query = String.format(builder.toString(), id);
        try(Statement stm = connection.createStatement()){
            stm.execute(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
            
        
        
    
    
    @Override
    public List<ContatoVO> buscarTodos() {
        // TODO: Declarar lista de contatos:
        List<ContatoVO> contatos = new ArrayList<>();
        String query = "SELECT id, nome, email, telefone, linkedin FROM contatos";
        try (Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(query)) {
            while(rst.next()){
                ContatoVO contato = new ContatoVO(rst.getInt("id"),
                rst.getString("nome"), 
                rst.getString("email"), 
                rst.getString("telefone"), 
                rst.getString("linkedin"));
            contatos.add(contato);
            }
       } catch (Exception e) {
        // TODO: handle exception
        logger.log(Level.SEVERE, "Falha ao consultar contatos",e);
       }
       return contatos;
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        ContatoVO cont = null;  // Inicialize a variável cont

    // Usar PreparedStatement é mais seguro para evitar injeção de SQL
        String query = "SELECT id, nome, email, telefone, linkedin FROM contatos WHERE email = ?";
    
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rst = ps.executeQuery();

            if (rst.next()) {
                cont = new ContatoVO(
                    rst.getInt("id"),
                    rst.getString("nome"),
                    rst.getString("email"),
                    rst.getString("telefone"),
                    rst.getString("linkedin")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cont;
    }
}
