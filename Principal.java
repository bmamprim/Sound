// import java.security.KeyStore.PasswordProtection;
import java.sql.Connection;
import java.sql.SQLException;
// import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Interface.InterfaceCreate;
import modelo.Autor;
// import modelo.Pessoa;
// import modelo.Telefone;
// import modelo.TipoTelefone;
import dao.AutorDAO;
import dao.ConnectionFactory;
// import dao.PessoaDAO;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Principal extends JFrame{
    public Principal() {
        super("Inicio");
    }
    public static void main(String[] args) throws SQLException{
        // comentei pq ainda n ta pronto, qnd estiver a gente testa
        // JFrame f = new JFrame();
        // JButton btnAtualizarAutor = new JButton("Atualizar Autor");
        // JButton btnAtualizarCategoria = new JButton("Atualizar Categoria");
        // JButton btnAtualizarMusica = new JButton("Atualizar Musica");
        // JButton btnListarAutores = new JButton("Listar Autores");
        // JButton btnListarCategorias = new JButton("Listar Categorias");
        // JButton btnListarMusicas = new JButton("Listar Musicas");
        // JButton btnPesquisarAutor = new JButton("Pesquisar Autor");
        // JButton btnPesquisarCategoria = new JButton("Pesquisar Categoria");
        // JButton btnPesquisarMusica = new JButton("Pesquisar Musica");
        // JButton btnDeletarAutor = new JButton("Deletar Autor");
        // JButton btnDeletarCategoria = new JButton("Deletar Categoria");
        // JButton btnDeletarMusica = new JButton("Deletar Musica");

        // f.setLayout(new GridLayout(0, 3));
        // f.setSize(1000, 250);

        // f.add(btnAtualizarAutor);
        // f.add(btnAtualizarCategoria);
        // f.add(btnAtualizarMusica);
        // f.add(btnListarAutores);
        // f.add(btnListarCategorias);
        // f.add(btnListarMusicas);
        // f.add(btnPesquisarAutor);
        // f.add(btnPesquisarCategoria);
        // f.add(btnPesquisarMusica);
        // f.add(btnDeletarAutor);
        // f.add(btnDeletarCategoria);
        // f.add(btnDeletarMusica);

        // f.setVisible(true);

        // Cria os objetos em memoria local
        Autor autor1 = new Autor("11122233344", "Gustavo", "Tavin");
        Autor autor2 = new Autor("12345678909", "Isabelle", "Isa");
        Autor autor3 = new Autor("00011122233", "Lucas", "Serejo");

        System.out.println(autor1);
        System.out.println(autor2);
        System.out.println(autor3);

        System.out.println("Acabei de printar os objetos em memoria\n\n\n");

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        // Define o objeto DAO, onde ficam as funcoes que vamos chamar 
        AutorDAO autorDao = new AutorDAO(connection);

        // envia cada objeto criado em memoria para a funcao que cria autor no banco
        autorDao.createAutor(autor1);
        autorDao.createAutor(autor2);
        autorDao.createAutor(autor3);
        
        ArrayList<Autor> listaAutores = autorDao.retrieveAllAutores();

        Autor autorEspecifico = autorDao.retrieveAutor("Isa");

        System.out.println(autorEspecifico.getCpf());

        for(Autor autor : listaAutores) {
            System.out.println(autor.getCpf());
        }

        autorDao.deleteAutor(autorDao.retrieveAutor("Tavin").get_id_autor());
        autorDao.updateAutor(autorDao.retrieveAutor("Isa"));
    }

}