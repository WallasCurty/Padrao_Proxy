import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<Integer, Cliente> cliente = new HashMap<>();

    public static Cliente getCliente(Integer cpf) {
        return cliente.get(cpf);
    }

    public static void addCliente(Cliente cliente) {
        cliente.put(cliente.getCpf(), cliente);
    }
}
