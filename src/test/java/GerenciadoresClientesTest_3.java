import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class GerenciadoresClientesTest_3 {

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
    }

    @Test
    public void testPesquisaClienteInexistente(){

        /* Execução */
        Cliente cliente = banco.pesquisaCliente(1001);

        /* Verificações */
        assertNull(cliente);
    }

    @Test
    public void testRemoveCliente(){

        /* Execução */
        boolean isRemoveCliente = banco.removeCliente(1);

        /* Verificações */
        assertThat(isRemoveCliente, is(true));
        assertThat(banco.getClientesDoBanco().size(), is(1));
        assertNull(banco.pesquisaCliente(1));

    }

    @Test
    public void testRemoveClienteInexistente(){

        /* Execução */
        boolean isRemoveCliente = banco.removeCliente(1001);

        /* Verificações */
        assertThat(isRemoveCliente, is(false));
    }

    /**
     * Metodos de teste para valores limites*/
    @Test
    public void testValidaIdadeCliente() throws IdadeNaoPermitidaException{

        /* Execução */
        Cliente cliente = new Cliente(1, "Marcos", 20,"marcos@gmail.com",1,true);

        boolean idadeValida = banco.validaIdade(cliente.getIdade());

        /* Verificações */
        assertTrue(idadeValida);
    }

    @Test
    public void testValidaIdadeClienteMinima() throws IdadeNaoPermitidaException{

        /* Execução */
        Cliente cliente = new Cliente(1, "Marcos", 18,"marcos@gmail.com",1,true);

        boolean idadeValida = banco.validaIdade(cliente.getIdade());

        /* Verificações */
        assertTrue(idadeValida);
    }

    @Test
    public void testValidaIdadeClienteMaxima() throws IdadeNaoPermitidaException{

        /* Execução */
        Cliente cliente = new Cliente(1, "Marcos", 65,"marcos@gmail.com",1,true);

        boolean idadeValida = banco.validaIdade(cliente.getIdade());

        /* Verificações */
        assertTrue(idadeValida);
    }

    @Test
    public void testValidaIdadeClienteAbaixoDaMaxima() throws IdadeNaoPermitidaException{

        /* Execução */
        Cliente cliente = new Cliente(1, "Marcos", 17,"marcos@gmail.com",1,true);

        try{
            banco.validaIdade(cliente.getIdade());
            fail(); //Para o teste passar, não pode cair nessa linha
        } catch (Exception e){
            // Verificando se a mensagem da excecao está correta
            assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
        }
    }

    @Test
    public void testValidaIdadeClienteAcimaDaMaxima() throws IdadeNaoPermitidaException{

        /* Execução */
        Cliente cliente = new Cliente(1, "Marcos", 66,"marcos@gmail.com",1,true);

        try{
            banco.validaIdade(cliente.getIdade());
            fail();//Para o teste passar, não pode cair nessa linha
        } catch (Exception e){
            // Verificando se a mensagem da excecao está correta
            assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
        }
    }
}
