package dao;

import java.sql.Connection;

public class MusicaDAO {
    private Connection connection;

    private MusicaDAO(Connection connection) {
        this.connection = connection;
    }
}
