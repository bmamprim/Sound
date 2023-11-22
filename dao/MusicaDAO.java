package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;

import modelo.Autor;
import modelo.Categoria;
import modelo.Musica;
import modelo.Pessoa;
import modelo.Telefone;
import modelo.TipoTelefone;

public class MusicaDAO {
    private Connection connection;

    public MusicaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createMusica(Musica musica) {
        try {
            String sql = "INSERT INTO Musica VALUES (default, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, musica.getTitulo());
                pstm.setDate(2, musica.getData_lancamento());
                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        musica.set_id_musica(rst.getInt(1));
                        for(Autor autor : musica.getAutores()) {
                            AutorDAO autorDAO = new AutorDAO(connection);
                            autorDAO.createAutor(autor, musica);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Musica retrieveMusica(String titulo) {
        try {
            String sql = "SELECT m.nome_mus, a.nome_art, c.nome_cat FROM Musica AS m INNER JOIN Autor AS a ON m.autor_id = a.id_autor INNER JOIN Categoria as c ON m.categoria_id = c.id_categoria WHERE nome_mus = ?";

            Musica ultimaMusica = null;

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, titulo);
                pstm.execute();

                ResultSet result = pstm.getResultSet();

                while (result.next()) {
                    if (ultimaMusica == null || ultimaMusica.get_id_musica() != result.getInt(1)) {
                        int id_musica = result.getInt("id_musica");
                        String nome_musica = result.getString("nome_mus");
                        Date data_lancamento = result.getDate("data_lancamento");
                        String letra= result.getString("letra");
                        Categoria nome_categoria = new Categoria(result.getString("nome_cat"));
                        int duracao = result.getInt("duracao");
                        Musica musica = new Musica(id_musica, nome_musica, letra, data_lancamento, nome_categoria, duracao);
                        ultimaMusica = musica;
                    }

                    int autor_id = result.getInt("autor_id");

                    String nome_artistico = result.getString("nome_art");
                    String nome_original = result.getString("nome_orig");
                    String cpf = result.getString("cpf");
                    Autor autor = new Autor(autor_id, cpf, nome_original, nome_artistico);
                    ultimaMusica.addAutor(autor);
                }
            }
            return ultimaMusica;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
