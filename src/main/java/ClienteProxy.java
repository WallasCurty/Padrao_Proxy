import java.util.List;

public class ClienteProxy implements ICliente{
    private Cliente cliente;
    private int cpf;

    public ClienteProxy(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public List<String> obterHistoricoConsulta() {
        if (this.cliente == null) {
            this.cliente = new Cliente(this.cpf);
        }
        return this.cliente.obterHistoricoConsulta();
    }

    @Override
    public List<String> obterExtratoBancario(Funcionario funcionario) {
        if (!funcionario.isCaixa()) {
            throw new IllegalArgumentException("Acesso negado.");
        }
        if (this.cliente == null) {
            this.cliente = new Cliente(this.cpf);
        }
        return this.cliente.obterExtratoBancario(funcionario);
    }
}
