package mantis.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import mantis.pages.TaskPage;
import mantis.pages.LoginPage;
import mantis.utils.DriverManager;
import org.openqa.selenium.WebDriver;

public class TaskSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private TaskPage taskPage;

    @Before
    public void configurar() {
        driver = DriverManager.obterDriver();
        loginPage = new LoginPage(driver);
        taskPage = new TaskPage(driver);
    }

    @After
    public void finalizar() {
        DriverManager.encerrarDriver();
    }

    @Dado("que estou logado no sistema Mantis")
    public void queEstouLogadoNoSistemaMantis() {
        loginPage.navegar("http://mantis-prova.base2.com.br");
        loginPage.loginUsuario("cosme_assis");
        loginPage.clicarLogin();
        loginPage.loginPassword("Teste@123");
        loginPage.clicarLogin();
        taskPage.waitTitleMinhaVisao();
    }

    @Quando("eu navego para a página de criação de tarefa")
    public void euNavegoPaPáginaDeCriaçãoDeTarefa() {
        taskPage.clicarCriarTarefa();
    }

    @E("preencho os detalhes da tarefa:")
    public void preenchoOsDetalhesDaTarefa(io.cucumber.datatable.DataTable dataTable) {
        var dados = dataTable.asMaps().get(0);
        taskPage.selecionarCategoria(dados.get("Categoria"));
        taskPage.preencherResumo(dados.get("Resumo"));
        taskPage.preencherDescricao(dados.get("Descrição"));
    }

    @E("submeto a tarefa")
    public void submitoATarefa() {
        taskPage.clicarSubmeter();
    }

    @Então("deve aparecer Ver Detalhes da Tarefa")
    public void deveAparecerVerDetalhesDaTarefa() {
        taskPage.waitTitleVerDetalhesTarefa();
    }

    @Quando("eu navego para a página de visualização de tarefa")
    public void euNavegoParaAPáginaDeVisualizaçãoDeTarefa() {
        taskPage.clicarVerTarefa();
        taskPage.waitTitlePageVerTarefa();
    }

    @Entao("as tarefas relatados por mim são exibidas")
    public void asTarefasRelatadosPorMimSãoExibidas() {
        taskPage.waitWidgetVisualandoTarefas();
    }

}