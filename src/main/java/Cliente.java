import java.util.List;

public class Cliente implements ICliente {
    private Integer cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private List<String> consulta;
    private List<String> extrato;

    public Cliente(Integer cpf) {
        this.cpf = cpf;
        Cliente objeto = DataBase.getCliente(cpf);
        this.nome = objeto.nome;
        this.telefone = objeto.telefone;
        this.endereco = objeto.endereco;
        this.consulta = objeto.consulta;
        this.extrato = objeto.extrato;
    }
    public Cliente(Integer cpf, String nome, String telefone, String endereco,
                   List<String> consulta,List<String> extrato) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.consulta = consulta;
        this.extrato = extrato;
    }


    public Integer getCpf() {
        return cpf;
    }


    @Override
    public List<String> obterHistoricoConsulta() {
        return consulta;
    }

    @Override
    public List<String> obterExtratoBancario(Funcionario funcionario) {
        return extrato;
    }
    public void put(Integer cpf2, Cliente cliente) {
    }

}
