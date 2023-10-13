package services;

import java.util.List;

import domain.ContatoVO;

public interface IContatoService {
    void salvar(ContatoVO contato);
    void alterar(ContatoVO contato);
    ContatoVO buscaPorEmail(String email);
    void excluir(Integer id);
    List<ContatoVO> buscarTodos();

}
