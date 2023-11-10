package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TransferenciaValidation extends BasePage {

    public TransferenciaValidation(WebDriver navegador) {
        super(navegador);
    }

    public void validarTransferencia(){
        String transfer = navegador.findElement(By.id("modalText")).getText();
        Assertions.assertEquals("Transferencia realizada com sucesso", transfer);
    }

}
