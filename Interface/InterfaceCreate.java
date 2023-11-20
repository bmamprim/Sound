package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import dao.AutorDAO;
import dao.ConnectionFactory;
import modelo.Autor;

public class InterfaceCreate extends JFrame {
    public InterfaceCreate() {
		super("Create");
	}
	
	public void Executa(String option) {
        if (option == "Autor") {
            JTextField inputCpf = new JTextField(10);
            JLabel labelCpf = new JLabel("CPF:", SwingConstants.RIGHT);
            JTextField inputNomeArt = new JTextField(10);
            JLabel labelNomeArt = new JLabel("Nome Artistico: ", SwingConstants.RIGHT);
            JTextField inputNomeOrig = new JTextField(10);
            JLabel labelNomeOrig = new JLabel("Nome Original: ", SwingConstants.RIGHT);
            JButton btnCreateAutor = new JButton("Criar Autor");
            JButton btnVoltar = new JButton("Voltar");

            setLayout(new GridLayout(0,2));
            setSize(1000, 250);

            add(labelCpf);
            add(inputCpf);
            add(labelNomeArt);
            add(inputNomeArt);
            add(labelNomeOrig);
            add(inputNomeOrig);
            add(btnVoltar);
            add(btnCreateAutor);

            String autorCpf = inputCpf.getText();
            String autorNomeArt = inputNomeArt.getText();
            String autorNomeOrig = inputNomeOrig.getText();
            Autor autor = new Autor(autorCpf, autorNomeArt, autorNomeOrig);

            btnVoltar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dispose();
                }
            });

            btnCreateAutor.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ConnectionFactory connectionFactory = new ConnectionFactory();
                    Connection connection = connectionFactory.recuperaConexao();

                    // Define o objeto DAO, onde ficam as funcoes que vamos chamar 
                    AutorDAO autorDao = new AutorDAO(connection);

                    // envia cada objeto criado em memoria para a funcao que cria autor no banco
                    autorDao.createAutor(autor);

                    JOptionPane.showMessageDialog(null, "Autor Criado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        } else if (option == "Categoria") {
            System.out.println("Categoria");
        } else {
            System.out.println("Musica");
        }

        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        JButton btnCriarAutor = new JButton("Criar Autor");
        JButton btnCriarCategoria = new JButton("Criar Categoria");
        JButton btnCriarMusica = new JButton("Criar Musica");

        f.setLayout(new FlowLayout());
        f.setSize(1000, 250);

        f.add(btnCriarAutor);
        f.add(btnCriarCategoria);
        f.add(btnCriarMusica);
        btnCriarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new InterfaceCreate().Executa("Autor");
            }
        });
        btnCriarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new InterfaceCreate().Executa("Categoria");
            }
        });
        btnCriarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new InterfaceCreate().Executa("Musica");
            }
        });

        f.setVisible(true);
    }
}
