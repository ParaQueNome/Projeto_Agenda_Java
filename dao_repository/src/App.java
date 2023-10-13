import java.sql.ResultSet;
import java.util.List;

import dao.factories.ConexaoFactory;
import dao.factories.ContatoMySqliDAO;
import dao.factories.IContatoDAO;
import domain.ContatoVO;
import repositories.ContatoMySqlRepository;
import repositories.ContatoinMemoryRepository;
import repositories.IContatoRepository;
import services.ContatoService;
import services.IContatoService;

import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");
        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoMySqliDAO(conexao);
        IContatoRepository repository = new ContatoMySqlRepository(dao);
        //TODO: mudar repository para in memory
        //IContatoRepository repository = new ContatoinMemoryRepository();
        IContatoService service = new ContatoService(repository);

        //TODO: Criar objeto ContatoVO e realizar chamada do metodo salvar do service.

        ContatoVO c1 = new ContatoVO(
        null, 
        "Joao Pedro Ferreira", 
        "jp@gmail.com", 
        "1999892321", 
        "jpferreira_li");

        //service.salvar(c1);

        

        //TODO: Criar mais 2 contato:
        ContatoVO c2 = new ContatoVO(
            null,
            "Guilherme Ferreira",
            "guiau@gmail.com",
            "19989732322",
            "gg_li");
            //service.salvar(c2);
            ContatoVO c3 = new ContatoVO(
            null,
            "Thiago Ferreira",
            "titi@gmail.com",
            "199897323342",
            "tiago_li");
            //service.salvar(c3);
        //TODO: Exibir os contatos cadastrados:
        List<ContatoVO> contatos = service.buscarTodos();
        System.out.println(contatos);
        //TODO: Remover o primeiro contato criado:
        service.excluir(1);
        //TODO: Buscar e exibir o segundo contato criado com base no email:
        service.buscaPorEmail("guiau@gmail.com");
        //TODO: Exibir os contatos cadastrados
        service.buscarTodos();

    }
}
