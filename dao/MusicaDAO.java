package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Musica;

public class MusicaDAO {
    private Connection connection;

    private MusicaDAO(Connection connection) {
        this.connection = connection;
    }
}
