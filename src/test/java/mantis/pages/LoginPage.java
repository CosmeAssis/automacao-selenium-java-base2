package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement campoUsuario;

    @FindBy(name = "password")
    private WebElement campoSenha;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    private WebElement botaoLogin;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navegar(String url) {
        driver.get(url);
    }

    public void preencherUsuario(String usuario) {
        campoUsuario.sendKeys(usuario);
    }

    public void preencherSenha(String password) {
        campoSenha.sendKeys(password);
    }

    public void clicarLogin() {
        botaoLogin.click();
    }

    public void loginUsuario(String usuario) {
        preencherUsuario(usuario);
    }

    public void loginPassword(String password) {
        preencherSenha(password);
    }


}