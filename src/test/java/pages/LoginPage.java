package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarPaginaLogin(){
        navegador.get("https://bugbank.netlify.app/");
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")
    private WebElement botaoRegistrar;
    public void abrirPaginaDeRegistro(){
        botaoRegistrar.click();
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement campoEmail;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement campoSenha;
    @FindBy (xpath = "//*[@type='submit']")
    private WebElement botaoAcessar;

    public void logarComUsuario(String lemail, String password){
        //Vou digitar o email
        campoEmail.sendKeys(lemail);
        //Vou digitar a senha
        campoSenha.sendKeys(password);
        //Vou clicar no botão de Acessar
        botaoAcessar.click();

    }

}
