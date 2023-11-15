// import java.security.KeyStore.PasswordProtection;
import java.sql.Connection;
import java.sql.SQLException;
// import java.time.LocalDate;
// import java.util.ArrayList;

import modelo.Autor;
// import modelo.Pessoa;
// import modelo.Telefone;
// import modelo.TipoTelefone;
import dao.AutorDAO;
import dao.ConnectionFactory;
// import dao.PessoaDAO;

public class Principal{


    public static void main(String[] args) throws SQLException {

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

        // Pessoa pessoa4 = new Pessoa("Joao Correia", "00011122233", LocalDate.of(2003, 4, 15));
        // Telefone telefone40 = new Telefone(TipoTelefone.Celular,55,21,964695794);
        // Telefone telefone41 = new Telefone(TipoTelefone.Celular,55,21,96469579);
        // pessoa4.addTelefone(telefone40);
        // pessoa4.addTelefone(telefone41);  

        // Pessoa pessoa5 = new Pessoa("Joao Constant", "00011122244", LocalDate.of(2004, 5, 20)); //55 21 999309064
        // Pessoa pessoa6 = new Pessoa("Matheus Herzog", "00011122255", LocalDate.of(2005, 6, 25)); //55 21 960197272  55 21 96525522
        // Pessoa pessoa7 = new Pessoa("Thaís Bustamante", "00011122266", LocalDate.of(2000, 7, 30)); //55 21 973013773  55 21 24870553
        // Pessoa pessoa8 = new Pessoa("Théo Mauricio", "00011122277", LocalDate.of(2001, 8, 01)); //55 24 992675080  55 24 92675080
        // Pessoa pessoa9 = new Pessoa("Victor Lobianco", "00011122288", LocalDate.of(2002, 9, 05));//55 21 992471219

        // System.out.println(pessoa4);
        // System.out.println(pessoa5);
        // System.out.println(pessoa6);
        // System.out.println(pessoa7);
        // System.out.println(pessoa8);
        // System.out.println(pessoa9);
        
        // System.out.println("Acabei de printar os objetos em memoria\n\n\n");

        // PessoaDAO pdao = new PessoaDAO(connection);
    
        // pdao.createComTelefone(pessoa4);
        // pdao.createComTelefone(pessoa5);
        // pdao.createComTelefone(pessoa6);
        // pdao.createComTelefone(pessoa7);
        // pdao.createComTelefone(pessoa8);
        // pdao.createComTelefone(pessoa9);
 
        
        // ArrayList<Pessoa> pessoas =  pdao.retriveAllComTelefone();
        //ArrayList<Pessoa> pessoas =  pdao.retriveAllSemTelefone();


        // System.out.println("Comecei a printar os objetos do BD\n");
        // for (Pessoa pessoa : pessoas) {
        //     System.out.println(pessoa);
        //     for (Telefone telefone : pessoa.getTelefones()) {
        //         System.out.println(telefone);
        //     }
        // }
    
        //Exemplo de Injection
        // Pessoa pessoa10 = new Pessoa("%", "%' UNION SELECT cpf FROM Pessoa WHERE nome LIKE '%", LocalDate.of(2002, 9, 05));
        // ArrayList<Pessoa> pessoas2 =  pdao.retrieveInjection(pessoa10);
        // for (Pessoa pessoa : pessoas2) {
        //     System.out.println(pessoa);
        // }
    }

}