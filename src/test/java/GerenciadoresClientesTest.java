import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GerenciadoresClientesTest {

    @Test
    public void TestPesquisaCliente(){

        Cliente c1 = new Cliente(1,
                "Marcos",
                31,
                "marcos.souza@justa.com.vc",
                1,
                true);

        Cliente c2 = new Cliente(2,
                "Patricia",
                25,
                "paty@gmail.com",
                2,
                true);

        List<Cliente> clientes = Arrays.asList(c1, c2);

        GerenciadoraClientes banco = new GerenciadoraClientes(clientes);

        Cliente pesquisaCliente = banco.pesquisaCliente(1);

        assertThat(pesquisaCliente.getId(), is(1));
        assertThat(pesquisaCliente.getEmail(), is("marcos.souza@justa.com.vc"));

    }
}
