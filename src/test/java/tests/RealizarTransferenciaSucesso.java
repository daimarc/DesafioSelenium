package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import validations.ContaValidation;
import validations.TransferenciaValidation;
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


        //Abrir o site BugBank (login)
        LoginPage loginPage = new LoginPage(navegador);
        loginPage.acessarPaginaLogin();
        loginPage.abrirPaginaDeRegistro();

        //Registrar o usuario 1
        RegistrarUsuarioPage registrarUsuarioPage = new RegistrarUsuarioPage(navegador);
        registrarUsuarioPage.registrarNovoUsuario("daimar.qa1@gmail.com", "Usuario 1", "123", "123");

        //Registrar o usuario 2
        loginPage.abrirPaginaDeRegistro();
        registrarUsuarioPage.registrarNovoUsuario("daimar.qa2@gmail.com", "Usuario 2", "789", "789");

        //Logar com o usuário 2
        loginPage.logarComUsuario("daimar.qa2@gmail.com","789");

        // Capturar conta e dígito e guardar nas variáveis
        ContaPage contaPage = new ContaPage(navegador);
        String numero = contaPage.numeroConta();
        String conta = contaPage.digitoConta();

        contaPage.clicarSair();

        //Logar com o usuário 1
        loginPage.logarComUsuario("daimar.qa1@gmail.com","123");

        // REALIZAR A TRANSFERENCIA
        contaPage.clicarEmTransferencia();
        TransferenciaPage transferenciaPage = new TransferenciaPage(navegador);
        transferenciaPage.preencherTransferencia(numero, conta, "5","teste");
        transferenciaPage.botaoTransferirAgora();

        //Validar transferencia com sucesso
        Thread.sleep(500);
        TransferenciaValidation transferenciaValidation = new TransferenciaValidation(navegador);
        transferenciaValidation.validarTransferencia();

        transferenciaPage.fecharBotaoDeTransfComSucesso();
        transferenciaPage.botaoVoltar();

        //Validar saldo de SAÍDA em conta (R$995,00)
        ContaValidation contaValidation = new ContaValidation(navegador);
        contaValidation.validarSaldoSaida();

        contaPage.clicarSair();

        //Logar com o usuário 2
            loginPage.logarComUsuario("daimar.qa2@gmail.com","789");

            //Validar saldo de ENTRADA em conta (R$5,00)
            ContaValidation contaValidation1 = new ContaValidation(navegador);
            contaValidation1.validarSaldoEntrada();

            contaPage.clicarSair();

    }

    @AfterEach
        public void tearDown(){
            //Fechar navegador
            navegador.quit();
       }

}
