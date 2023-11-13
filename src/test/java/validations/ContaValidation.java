package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.ContaPage;

public class ContaValidation extends BasePage {

    public ContaValidation(WebDriver navegador) {
        super(navegador);
    }

    public ContaPage validarSaldoSaida(){
    String saldoFinal = navegador.findElement(By.xpath("//*[@id=\"textBalance\"]/span")).getText();
    Assertions.assertEquals("R$ 995,00", saldoFinal);

    return new ContaPage(navegador);

    }

    public ContaPage validarSaldoEntrada() {
        String saldoFinal = navegador.findElement(By.xpath("//*[@id=\"textBalance\"]/span")).getText();
        Assertions.assertEquals("R$ 5,00", saldoFinal);

        return new ContaPage(navegador);

    }

}
