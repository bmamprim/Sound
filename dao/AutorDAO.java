package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Autor;

public class AutorDAO {
    private Connection connection;

    public AutorDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void createAutor(Autor autor){
        try {
            String sql = "INSERT INTO Autor VALUES (?, ?, ?)";

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

    public void retrieveAllAutores(){};

    public void deleteAutor(){};

    public void updateAutor() {}

}
