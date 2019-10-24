import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public class GerenciadoresClientesTest_2 {

    /**
     * Cenario onde as mesmas informações são utilizadas
     * em testes diferentes.
     *  */

    private GerenciadoraClientes banco;
    private int idCliente = 1;

    @Before
    public void setUp() {

        /* Montagem do cenário de testes */

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

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(c1);
        clientes.add(c2);

        banco = new GerenciadoraClientes(clientes);

        System.out.println("Before");
    }

    @After
    public void tearDown(){
        banco.limpa();
        System.out.println("Limpa");
    }


    @Test
    public void testPesquisaCliente(){

        /* Execução */
        Cliente cliente = banco.pesquisaCliente(idCliente);

        /* Verificações */
        assertThat(cliente.getId(), is(idCliente));
        assertThat(cliente.getEmail(), is("marcos.souza@justa.com.vc"));

        System.out.println("Teste");

    }

    @Test
    public void testRemoveCliente(){

        /* Execução */
        boolean isRemoveCliente = banco.removeCliente(1);

        /* Verificações */
        assertThat(isRemoveCliente, is(true));
        assertThat(banco.getClientesDoBanco().size(), is(1));
        assertNull(banco.pesquisaCliente(1));

        System.out.println("Remove");

    }
}
