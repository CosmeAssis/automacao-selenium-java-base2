package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static mantis.utils.DriverManager.waitElementClickable;
import static mantis.utils.DriverManager.waitElementVisiblePage;

public class TaskPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Criar Tarefa')]")
    private WebElement botaoCriarTarefa;

    @FindBy(xpath = "//span[contains(.,'Ver Tarefas')]")
    private WebElement botaoVerTarefa;
    @FindBy(name = "category_id")
    private WebElement campoCategoria;

    @FindBy(name = "summary")
    private WebElement campoResumo;

    @FindBy(name = "description")
    private WebElement campoDescricao;

    @FindBy(css = "input[type='submit']")
    private WebElement botaoSubmeter;

    @FindBy(xpath = "//a[contains(.,'Minha Visão')]")
    private WebElement titlePageMinhaVisao;

    @FindBy(xpath = "//div[@class='widget-header widget-header-small'][contains(.,'Ver Detalhes da Tarefa')]")
    private WebElement titlePageVerDetalhesDaTarefa;

    @FindBy(xpath = "//title[contains(.,'Ver Tarefas - MantisBT')]")
    private WebElement titlePageVerTarefa;

    @FindBy(xpath = "//div[@class='widget-box widget-color-blue2']")
    private WebElement widgetVisualandoTarefas;

    @FindBy(xpath = "//a[contains(.,'Imprimir Tarefas')]")
    private WebElement botaoImprimirTarefas;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitTitleMinhaVisao() {
        waitElementVisiblePage(titlePageMinhaVisao, 10000);
    }

    public void waitTitleVerDetalhesTarefa() {
        waitElementVisiblePage(titlePageVerDetalhesDaTarefa, 10000);
    }

    public void waitTitlePageVerTarefa() {
        waitElementVisiblePage(titlePageVerTarefa, 10000);
    }

    public void waitWidgetVisualandoTarefas() {
        waitElementVisiblePage(widgetVisualandoTarefas, 10000);
    }

    public void clicarCriarTarefa() {
        botaoCriarTarefa.click();
    }

    public void clicarVerTarefa() {
        botaoVerTarefa.click();
    }

    public void selecionarCategoria(String categoria) {
        new Select(campoCategoria).selectByVisibleText(categoria);
    }

    public void preencherResumo(String resumo) {
        campoResumo.sendKeys(resumo);
    }

    public void preencherDescricao(String descricao) {
        campoDescricao.sendKeys(descricao);
    }

    public void clicarSubmeter() {
        botaoSubmeter.click();
    }

}