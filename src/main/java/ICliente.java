import java.util.List;

public interface ICliente {
    List<String> obterHistoricoConsulta();
    List<String> obterExtratoBancario(Funcionario funcionario);
}
