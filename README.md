# Projeto_Agenda_Java

## Projeto empregando o Padrão DAO e Repository, juntamente com pacotes services, para criar uma agenda de contato.

<p>Nesse projeto, com intuito de trabalhar padrões de projetos há:</p> <br>

<ul>
  <li>
    Interface DAO: Responsável por abstrair o tipo de banco de dados que será empregados e seus métodos de persistência;
  </li>
  <li>
    Classe DAO: Classe que implementa a interface DAO, realizando a inversão de dependências, de modo que, que possamos criar uma classe de persistência com diferentes tipos de bancos de dados ao mesmo tempo
  </li>
  <li>
    Interface DAORepository: Interface que abstrai a validação de dados do DAO, utilizando os mesmos métodos
    
  </li>
  <li>
    Classe DaoRepository: Classe que aplica inversão de dependência e pode trabalhar com os diferentes tipos de bancos de dados empregados no DAO
  </li>
  <li>
    Interface ContatoServices: Implementa os métodos de validação do banco de dados para realizar o tratamento de exceções antes de inserir no banco, garantindo a segurança da aplicação
    
  </li>
  <li>
    Classe ContatoService: Implementa a interface Service para realizar a implementação de seus métodos com o tratamento de exceções.
    
  </li>
</ul>

Para executar o projeto, é necessário: <br>

<ul>
  <li>
    Java Instalado em seu sistema;
  </li>
  <li>
    IDE de sua preferência;
  </li>
  <li>
    Abra a pasta do projeto em sua IDE e execute o arquivo App.java;
    
  </li>
  <li>
    O programa será compilado e rodará;
  </li>
</ul>
