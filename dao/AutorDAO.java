package dao;

import java.sql.Connection;

public class AutorDAO {
    private Connection connection;

    public AutorDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void createAutor(){};

    public void retrieveAutor() {};

    public void retrieveAllAutores(){};

    public void deleteAutor(){};

    public void updateAutor() {}

}
