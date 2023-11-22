import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.Autor;
import modelo.Categoria;
import modelo.Musica;
import dao.AutorDAO;
import dao.CategoriaDAO;
import dao.ConnectionFactory;
import dao.MusicaDAO;

public class Principal{
    public static void main(String[] args) throws SQLException{
        // Cria os objetos em memoria local
        Autor autor1 = new Autor("11122233344", "Gustavo", "Tavin");
        Autor autor2 = new Autor("12345678909", "Isabelle", "Isa");
        Autor autor3 = new Autor("00011122233", "Lucas", "Serejo");

        Musica musica1 = new Musica();
        Musica musica2 = new Musica();
        Musica musica3 = new Musica();

        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        Categoria categoria3 = new Categoria();

        // Estabelece a conexao com o db
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        // Instancia os objetos DAO
        AutorDAO autorDao = new AutorDAO(connection);
        MusicaDAO musicaDao = new MusicaDAO(connection);
        CategoriaDAO categoriaDao = new CategoriaDAO(connection);

        // Metodos de insercao no db
        autorDao.createAutor(autor1, null);
        autorDao.createAutor(autor2, null);
        autorDao.createAutor(autor3, null);

        musicaDao.createMusica(musica1);
        musicaDao.createMusica(musica2);
        musicaDao.createMusica(musica3);

        categoriaDao.createCategoria(categoria1);
        categoriaDao.createCategoria(categoria2);
        categoriaDao.createCategoria(categoria3);
        
        // Metodos de listagem das linhas
        ArrayList<Autor> listaAutores = autorDao.retrieveAllAutores();
        ArrayList<Musica> listaMusicas = musicaDao.retrieveAllMusicas();
        ArrayList<Categoria> listaCategorias = categoriaDao.retrieveAllCategorias();

        for(Autor autor : listaAutores) {
            System.out.println(autor.getCpf() + " - " + autor.getNome_original() + " - " + autor.getNome_artistico());
        }

        for(Musica musica : listaMusicas) {
            System.out.println(musica.getTitulo() + " - " + musica.getDuracao() + " - " + musica.getCategoria().getNome());
        }

        for(Categoria categoria : listaCategorias) {
            System.out.println(categoria.get_id_categoria() + " - " + categoria.getNome());
        }

        // Metodos de consulta de um dado especifico
        Autor autorEspecifico = autorDao.retrieveAutor("Isa");
        Musica musicaEspecifica = musicaDao.retrieveMusica("Bang");
        Categoria categoriaEspecifica = categoriaDao.retrieveCategoria("Sertanejo");

        System.out.println(autorEspecifico.getCpf());
        System.out.println(musicaEspecifica.getAutores().get(0).getNome_artistico());
        System.out.println(categoriaEspecifica.get_id_categoria());

        // Metodos de deleçao
        autorDao.deleteAutor(autorDao.retrieveAutor(autor1));
        musicaDao.deleteMusica(musicaDao.retrieveMusica(musica1));
        categoriaDao.deleteCategoria(categoriaDao.retrieveCategoria(categoria1));

        for(Autor autor : listaAutores) {
            System.out.println(autor.getCpf() + " - " + autor.getNome_original() + " - " + autor.getNome_artistico());
        }

        for(Musica musica : listaMusicas) {
            System.out.println(musica.getTitulo() + " - " + musica.getDuracao() + " - " + musica.getCategoria().getNome());
        }

        for(Categoria categoria : listaCategorias) {
            System.out.println(categoria.get_id_categoria() + " - " + categoria.getNome());
        }

        // Metodos de atualizacao
        Autor autor1Update = new Autor(1, "11122233344", "Gustavo", "Tavin");
        Musica musica1Update = new Musica();
        Categoria categoria1Update = new Categoria();

        autorDao.updateAutor(autorDao.retrieveAutor(autor1Update));
        musicaDao.updateMusica(musicaDao.retrieveMusica(musica1Update));
        categoriaDao.updateCategoria(categoriaDao.retrieveCategoria(categoria1Update));

        for(Autor autor : listaAutores) {
            System.out.println(autor.getCpf() + " - " + autor.getNome_original() + " - " + autor.getNome_artistico());
        }

        for(Musica musica : listaMusicas) {
            System.out.println(musica.getTitulo() + " - " + musica.getDuracao() + " - " + musica.getCategoria().getNome());
        }

        for(Categoria categoria : listaCategorias) {
            System.out.println(categoria.get_id_categoria() + " - " + categoria.getNome());
        }

    }

}