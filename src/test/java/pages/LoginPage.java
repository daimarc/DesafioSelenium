package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginPage acessarPaginaLogin(){
        navegador.get("https://bugbank.netlify.app/");
        //Fluent Page
        return new LoginPage(navegador);
    }

    //Page Factory
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")
    private WebElement botaoRegistrar;
    public RegistrarUsuarioPage abrirPaginaDeRegistro(){
        botaoRegistrar.click();
        //Fluent Page
        return new RegistrarUsuarioPage(navegador);
    }

    //Page Factory
    @FindBy(xpath = "//input[@type='email']")
    private WebElement campoEmail;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement campoSenha;
    @FindBy (xpath = "//*[@type='submit']")
    private WebElement botaoAcessar;

    public ContaPage logarComUsuario(String lemail, String password){
        //Vou digitar o email
        campoEmail.sendKeys(lemail);
        //Vou digitar a senha
        campoSenha.sendKeys(password);
        //Vou clicar no botão de Acessar
        botaoAcessar.click();

        return new ContaPage(navegador);

    }

}
