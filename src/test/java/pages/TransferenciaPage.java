package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import validations.ContaValidation;
import validations.TransferenciaValidation;

public class TransferenciaPage extends BasePage {

    public TransferenciaPage(WebDriver navegador) {
        super(navegador);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input")
    private WebElement campoConta;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[2]/input")
    private WebElement campoDigito;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/form/div[2]/input")
    private WebElement campoValor;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/form/div[3]/input")
    private WebElement campoDescricao;

    public TransferenciaPage preencherTransferencia(String numerodaConta, String digitodaConta, String valor, String descricao) {

        campoConta.sendKeys(numerodaConta);
        campoDigito.sendKeys(digitodaConta);
        campoValor.sendKeys(valor);
        campoDescricao.sendKeys(descricao);

        return new TransferenciaPage(navegador);

    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/form/button")
    private WebElement botaoTransferirAgora;

    public TransferenciaValidation botaoTransferirAgora() throws InterruptedException {
        botaoTransferirAgora.click();
        Thread.sleep(500);
        return new TransferenciaValidation(navegador);
    }

    @FindBy(id = "btnCloseModal")
    private WebElement botaoFechar;

    public TransferenciaPage fecharBotaoDeTransfComSucesso(){
        botaoFechar.click();

        return new TransferenciaPage(navegador);
    }

    @FindBy(id = "btnBack")
    private WebElement botaoVoltar;

    public ContaValidation botaoVoltar(){
        botaoVoltar.click();

        return new ContaValidation(navegador);
    }


}
