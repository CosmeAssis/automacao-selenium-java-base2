# Automação Selenium Java - Base2

Este repositório contém um projeto de automação de testes utilizando Selenium WebDriver com Java. Ele foi criado para simplificar a automação de tarefas repetitivas de testes em navegadores, garantindo maior eficiência no processo de validação de software.

## Funcionalidades

- Automação de testes web utilizando Selenium WebDriver
- Estrutura de projeto organizada seguindo boas práticas
- Integração com Maven para gerenciamento de dependências

## Requisitos

Antes de rodar o projeto, você precisará ter instalado:

- [Java 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.6+](https://maven.apache.org/download.cgi)
- Navegador Chrome
- [ChromeDriver](https://sites.google.com/chromium.org/driver/) configurado no diretório `drivers`

## Estrutura do Projeto

```bash
-java
└── mantis
    ├── pages        # Objetos de Página
    ├── runner       # Configurações de execução dos testes
    ├── steps        # Passos do BDD
    └── utils        # Utilitários e Helpers
-resources         # Recursos adicionais
--drivers
    └── chromedriver.exe # Driver do Chrome
--features
    └── tarefa.feature   # Arquivo de características BDD
