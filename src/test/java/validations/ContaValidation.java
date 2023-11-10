package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ContaValidation extends BasePage {

    public ContaValidation(WebDriver navegador) {
        super(navegador);
    }

    public void validarSaldoSaida(){
    String saldoFinal = navegador.findElement(By.xpath("//*[@id=\"textBalance\"]/span")).getText();
    Assertions.assertEquals("R$ 995,00", saldoFinal);

    }

    public void validarSaldoEntrada() {
        String saldoFinal = navegador.findElement(By.xpath("//*[@id=\"textBalance\"]/span")).getText();
        Assertions.assertEquals("R$ 5,00", saldoFinal);

    }

}
