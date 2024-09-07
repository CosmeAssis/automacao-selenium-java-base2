# language: pt
Funcionalidade: Criar Tarefa no Mantis

  Cenário: Criar uma nova tarefa com sucesso
    Dado que estou logado no sistema Mantis
    Quando eu navego para a página de criação de tarefa
    E preencho os detalhes da tarefa:
      | Categoria                           | Resumo                         | Descrição                            |
      | [Todos os Projetos] categoria teste | Nova tarefa teste automatizado | Tarefa criada via teste automatizado |
    E submeto a tarefa
    Então deve aparecer Ver Detalhes da Tarefa

  Cenário: Visualizar tarefa
    Dado que estou logado no sistema Mantis
    Quando eu navego para a página de visualização de tarefa
    Entao as tarefas relatados por mim são exibidas