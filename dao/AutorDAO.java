package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Autor;

public class AutorDAO {
    private Connection connection;

    public AutorDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void createAutor(Autor autor){
        try {
            String sql = "INSERT INTO Autor VALUES (DEFAULT, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, autor.getCpf());
                pstm.setString(2, autor.getNome_original());
                pstm.setString(3, autor.getNome_artistico());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        autor.set_id_autor(rst.getInt(1));
                    }
                }
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public void retrieveAutor() {};

    public ArrayList<Autor> retrieveAllAutores() {

        ArrayList<Autor> autores = new ArrayList<Autor>();

        try {
            String sql = "SELECT * FROM Autor";

            try(PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                ResultSet result = pstm.getResultSet();

                while (result.next()) {
                    int id = result.getInt("id_autor");
                    String cpf = result.getString("cpf");
                    String nome_original = result.getString("nome_orig");
                    String nome_artistico = result.getString("nome_art");
                    Autor autor = new Autor(id, cpf, nome_original, nome_artistico);
                    autores.add(autor);
                }

            }

            return autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public void deleteAutor(){};

    public void updateAutor() {}

}
