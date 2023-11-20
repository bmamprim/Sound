package Interface;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.AutorDAO;
import dao.ConnectionFactory;
import modelo.Autor;

public class InterfaceRead extends JFrame {
    public InterfaceRead() {
		super("Read");
	}
	
	public void Executa() {
        JTextField inputAutor = new JTextField(10);
        JLabel labelAutor = new JLabel("Autor:", SwingConstants.RIGHT);
        JTextField inputCategoria = new JTextField(10);
        JLabel labelCategoria = new JLabel("Categoria:", SwingConstants.RIGHT);
        JTextField inputMusica = new JTextField(10);
        JLabel labelMusica = new JLabel("Musica:", SwingConstants.RIGHT);
        JButton btnPesquisarAutor = new JButton("Pesquisar");
        JButton btnPesquisarCategoria = new JButton("Pesquisar");
        JButton btnPesquisarMusica = new JButton("Pesquisar");

        setLayout(new GridLayout(0,3));
        setSize(1000, 250);

        add(labelAutor);
        add(inputAutor);
        add(btnPesquisarAutor);
        add(labelCategoria);
        add(inputCategoria);
        add(btnPesquisarCategoria);
        add(labelMusica);
        add(inputMusica);
        add(btnPesquisarMusica);


        String autor = inputAutor.getText();
        String categoria = inputCategoria.getText();
        String musica = inputMusica.getText();

        btnPesquisarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectionFactory connectionFactory = new ConnectionFactory();
                Connection connection = connectionFactory.recuperaConexao();

                // Define o objeto DAO, onde ficam as funcoes que vamos chamar 
                AutorDAO autorDao = new AutorDAO(connection);

                // envia cada objeto criado em memoria para a funcao que cria autor no banco
                Autor resultadoAtor = autorDao.retrieveAutor(autor);

                System.out.println(resultadoAtor.getCpf() + " | " + resultadoAtor.getNome_artistico() + " | " + resultadoAtor.getNome_original());
            }
        });

        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args) throws SQLException { JFrame f = new JFrame();
        new InterfaceRead().Executa();

        f.setVisible(true);
    }
}
