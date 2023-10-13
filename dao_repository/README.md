## Projeto Agenda Contatos

### Pasta contendo um projeto com Padrão de Projetos Em Java

<ul>
  Padrões utilizados: <br>

  <li>
    DAO Repository
  </li>
  <li>
    VO
  </li>
  <li>
    Services
  </li>
</ul>

Foram empregadas Interfaces para aplicar o conceito de Injeção de Dependencias e Inversão de Dependências:

<ul>
  <li>
    Interface IDaoRepository:<br>
  </li>
  <p>Interface base para definição do tipo de banco de dados que será empregado</p><br>
  <p>Representada a interface de pertinência dos dados do banco</p> <br>
  <li>
    Classe DaoRepository:
  </li>
  <p>Implementa os metodos da interface de pertinência</p><br>
  <li>
    Interface Repository:
  </li>
  <p>Interface responsavel pela implementação das validações dos dados antes da inserção no banco de dados</p> <br>
  <li>
    Interface IService:
  </li>
  <p>Emprega a lógica de validação dos dados, deixando independente da classe dos Bancos de Dados </p> <br>
</ul>

## Como utilizar o projeto: 
<ul>

  <li>
    Para rodar o projeto, confirme se possui Java JDK instalado em sua máquina e que tenha a extensão instalada na IDE de sua preferência;
  </li>
  <li>
    Abra a pasta dao-repository na IDE
  </li>
  <li>
    Rode o código da classe APP e compile ele para que a aplicação funcione corretamente.
  </li>
</ul>




