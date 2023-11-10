package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrarUsuarioPage extends BasePage {

    // Crie um objeto Duration com a duração desejada (30 segundos, por exemplo)
    Duration duracao = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(navegador, duracao);

    public RegistrarUsuarioPage(WebDriver navegador) {
        super(navegador);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")
    private WebElement campoEmail;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input")
    private WebElement campoNome;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")
    private WebElement campoSenha;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input")
    private WebElement campoConfSenha;

    @FindBy(id = "toggleAddBalance")
    private WebElement botaoIncluirSaldo;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")
    private WebElement botaoCadastrar;


    public void registrarNovoUsuario(String email, String nome, String senha, String confsenha) throws InterruptedException {

        campoEmail.clear();
        campoEmail.sendKeys(email);

        campoNome.clear();
        campoNome.sendKeys(nome);

        campoSenha.clear();
        campoSenha.sendKeys(senha);

        campoConfSenha.clear();
        campoConfSenha.sendKeys(confsenha);

        Thread.sleep(500);
        botaoIncluirSaldo.click();


        //WebElement outerLabel = navegador.findElement(By.cssSelector("#toggleAddBalance"));
       // Thread.sleep(500);
       // WebElement toggleButton = outerLabel.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[6]/label/span"));
       // Thread.sleep(500);
        //if (!toggleButton.isSelected()) {
            // O botão de alternância não está ativado, então vamos ativá-lo
      //     outerLabel.click();
       // } else {
            // O botão de alternância já está ativado, não fazemos nada
      //  }


        //botão cadastrar
        botaoCadastrar.click();

        //Fechar janela de conta criada com sucesso, esperando até que o elemento fique visível
        By elementoLocator = By.xpath("//*[@id=\"btnCloseModal\"]");
        WebElement elementoVisivel = wait.until(ExpectedConditions.visibilityOfElementLocated(elementoLocator));
        // Realizar o clique após o elemento ficar visível
        elementoVisivel.click();

    }

}
