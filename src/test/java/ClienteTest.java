import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
    @BeforeEach
    void setUp() {
        DataBase.addCliente(new Cliente( 123456,"João" , "24999999","Centro, Vassouras",List.of("Consulta de Saldo - 01/03/2023", "Consulta Transferencia - 02/04/2023"),
                List.of("Extrato Realizado", "Extrato de 500")));;
        DataBase.addCliente(new Cliente( 234567,"José" , "24988899","Centro, Rio de Janeiro",List.of("Consulta de Saldo - 21/01/2023", "Consulta Transferencia - 12/02/2023"),
                List.of("Extrato Realizado", "Extrato de 500")));;
    }

    @Test
    void deveRetornarHistoricoDeConsultasDoCliente() {
        ClienteProxy cliente = new ClienteProxy(234567);
        cliente.obterHistoricoConsulta();

        assertEquals(List.of("Consulta de Saldo - 21/01/2023", "Consulta Transferencia - 12/02/2023"),
                cliente.obterHistoricoConsulta());
    }
    @Test
    void deveRetornarExtratoBancario() {
        Funcionario funcionario = new Funcionario("Fernanda", true);
        ClienteProxy cliente = new ClienteProxy(123456);
        cliente.obterExtratoBancario(funcionario);

        assertEquals(List.of("Consulta de Saldo - 01/03/2023", "Consulta Transferencia - 02/04/2023"),
                cliente.obterExtratoBancario(funcionario));
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoAutorizadoConsultarExtrato() {
        try {
            Funcionario funcionario = new Funcionario("Julia", false);
            ClienteProxy cliente = new ClienteProxy(123456);
            cliente.obterExtratoBancario(funcionario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Acesso negado.", e.getMessage());
        }
    }
}
