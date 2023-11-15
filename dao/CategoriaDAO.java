package dao;

import java.sql.Connection;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createCategoria() {};
    public void retrieveCategoria() {};
    public void retrieveAllCategorias() {};
    public void deleteCategoria() {};
    public void updateCategoria() {};
}
