package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Categoria;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createCategoria() {};
    public void retrieveCategoria() {};
    public void retrieveAllCategorias() {};
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
