package services;

import java.util.List;
import java.util.Objects;

import domain.ContatoVO;
import repositories.IContatoRepository;

public class ContatoService implements IContatoService {
    private final IContatoRepository repository;

    public ContatoService(IContatoRepository repository){
        this.repository = repository;
    }
    @Override
    public void salvar(ContatoVO contato) {
      
        if(Objects.isNull(contato.getNome()) || contato.getNome().isEmpty()){
            throw new RuntimeException("Nome é obrigatório");
        }
        if(Objects.isNull(contato.getEmail()) || contato.getEmail().isEmpty()){
            throw new RuntimeException("Email é obrigatório");
        }

        repository.salvar(contato);
         
    }

    @Override
    public void alterar(ContatoVO contato) {
        
        
        //TODO: Validar objeto conforme a entidade contatos
        if(Objects.isNull(contato.getId())){
            throw new RuntimeException("Não cadastrado");
        
        }else{
            //TODO: Consultar e recuperar contato
            
            ContatoVO cont = repository.buscarPorEmail(contato.getEmail());
            
            if(Objects.isNull(cont)){
                throw new RuntimeException("Não cadastrado");
            }else{
                repository.atualizar(contato);
            }
        }
    }

    @Override
    public ContatoVO buscaPorEmail(String email) {
        //TODO: Validar email

        if(Objects.isNull(email) || email.isEmpty()){
            throw new RuntimeException("Email é obrigatório");
        }
        if(!email.contains("@")){
           throw new RuntimeException("Email inválido"); 
        }
        //TODO: Localizar contato e retornar contato
        ContatoVO contato = repository.buscarPorEmail(email);

        return contato;
        }

    @Override
    public void excluir(Integer id){
        //TODO: Validar id
        List<ContatoVO> cont = repository.buscarTodos();
        if(cont.stream().filter(c -> c.getId().equals(id)).findFirst().isPresent()){
            //TODO: Localizar contato e excluir
            repository.excluir(id);
            
        }
    }

    @Override
    public List<ContatoVO> buscarTodos() { 
        return repository.buscarTodos();
    }
    
}
