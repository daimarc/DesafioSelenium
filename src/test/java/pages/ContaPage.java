package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContaPage extends BasePage {

    public ContaPage(WebDriver navegador) {
        super(navegador);
    }


    public String numeroConta(){
        String conta = navegador.findElement(By.xpath("//*[@id=\"textAccountNumber\"]/span")).getText();
        String[] contaParte = conta.split("-");
        return contaParte[0];
    }

    public String digitoConta(){
        String conta = navegador.findElement(By.xpath("//*[@id=\"textAccountNumber\"]/span")).getText();
        String[] contaParte = conta.split("-");
        return contaParte[1];
    }

    @FindBy(id = "btnExit")
    private WebElement botaoSair;

    // Vou clicar no botão Sair, da tela da Conta
    public void clicarSair(){
        botaoSair.click();
    }

    @FindBy(xpath = "//*[@id=\"btn-TRANSFERÊNCIA\"]")
    private WebElement botaoTransferencia;

    // Vou clicar no botão Transferência da tela da Conta
    public void clicarEmTransferencia(){
        botaoTransferencia.click();
    }


}

