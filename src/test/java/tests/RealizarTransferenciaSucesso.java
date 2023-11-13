package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import validations.ContaValidation;
import java.time.Duration;

public class RealizarTransferenciaSucesso {

        private WebDriver navegador;

       @BeforeEach
       public void setUp(){
               System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
               ChromeOptions options = new ChromeOptions();
               options.addArguments("--remote-allow-origins=*");
               options.addArguments("--start-maximized");
               navegador = new ChromeDriver(options);
               navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
       }


        @Test
        @DisplayName("Teste transferência entre contas")
        void testaselenium () throws InterruptedException {

           new LoginPage(navegador)
                    .acessarPaginaLogin()
                    .abrirPaginaDeRegistro()
                    .registrarNovoUsuario("daimar.qa1@gmail.com", "Usuario 1", "123", "123");
            new LoginPage(navegador)
                    .abrirPaginaDeRegistro()
                    .registrarNovoUsuario("daimar.qa2@gmail.com", "Usuario 2", "789", "789")
                    .logarComUsuario("daimar.qa2@gmail.com","789");

            // Capturar conta e dígito e guardar nas variáveis
            ContaPage contaPage = new ContaPage(navegador);
            String numero = contaPage.numeroConta();
            String conta = contaPage.digitoConta();

            new ContaPage(navegador)
                    .clicarSair()
                    .logarComUsuario("daimar.qa1@gmail.com","123")
                    .clicarEmTransferencia()
                    .preencherTransferencia(numero, conta, "5","teste")
                    .botaoTransferirAgora()
                    .validarTransferencia()
                    .fecharBotaoDeTransfComSucesso()
                    .botaoVoltar()
                    .validarSaldoSaida()
                    .clicarSair()
                    .logarComUsuario("daimar.qa2@gmail.com","789");

            new ContaValidation(navegador)
                   .validarSaldoEntrada()
                   .clicarSair();

    }

    @AfterEach
        public void tearDown(){
            //Fechar navegador
            navegador.quit();
       }

}
