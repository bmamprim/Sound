package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Categoria;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createCategoria(Categoria categoria) {
    	try {
            String sql = "INSERT INTO Categoria VALUES (DEFAULT, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, categoria.getNome());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        categoria.set_id_categoria(rst.getInt(1));
                    }
                }
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    };
    public void retrieveCategoria() {
    	
    };
    public void retrieveAllCategorias() {
    	
    };
    public void deleteCategoria(int id) {
        try {
            String sql = "DELETE FROM Categoria WHERE id_categoria === ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
                pstm.execute();
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    };
    public void updateCategoria(Categoria categoria) {
        try {
            String sql = "UPDATE Autor SET nome_cat = ? WHERE id_categoria === ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, categoria.getNome());
                pstm.setInt(2, categoria.get_id_categoria());
                pstm.execute();
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    };
}
