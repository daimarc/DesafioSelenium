package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void preencherTransferencia(String numerodaConta, String digitodaConta, String valor, String descricao) {

        campoConta.sendKeys(numerodaConta);
        campoDigito.sendKeys(digitodaConta);
        campoValor.sendKeys(valor);
        campoDescricao.sendKeys(descricao);

    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/form/button")
    private WebElement botaoTransferirAgora;

    public void botaoTransferirAgora(){
    botaoTransferirAgora.click();
    }

    @FindBy(id = "btnCloseModal")
    private WebElement botaoFechar;

    public void fecharBotaoDeTransfComSucesso(){
        botaoFechar.click();
    }

    @FindBy(id = "btnBack")
    private WebElement botaoVoltar;

    public void botaoVoltar(){
        botaoVoltar.click();
    }


}
