package repositories;

import java.util.List;

import dao.factories.IContatoDAO;
import domain.ContatoVO;

public class ContatoMySqlRepository implements IContatoRepository{

    private IContatoDAO dao;
    
    public ContatoMySqlRepository(IContatoDAO dao) {
        this.dao = dao;
    }


    @Override
    public void salvar(ContatoVO contato) {
        //TODO: validar o objeto contato
        dao.salvar(contato);
    }

    @Override
    public void atualizar(ContatoVO contato) {
        // TODO Auto-generated method stub
        dao.atualizar(contato);
    }

    @Override
    public void excluir(Integer id) {
        // TODO Auto-generated method stub
        dao.excluir(id);
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        // TODO Auto-generated method stub
        return dao.buscarTodos();
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
    }
    
}
