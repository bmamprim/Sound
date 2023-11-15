package dao;

import java.sql.Connection;

public class PlaylistDAO {
    private Connection connection;

    private PlaylistDAO(Connection connection) {
        this.connection = connection;
    }
}
