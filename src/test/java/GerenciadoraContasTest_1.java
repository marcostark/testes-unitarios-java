import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GerenciadoraContasTest_1 {

    private GerenciadoraContas gerenciaContas;

    @Test
    public void testTranfereValor(){

        /* Montagem do cenário */

        int idConta01 = 1;
        int idConta02 = 2;

        ContaCorrente cc1 = new ContaCorrente(idConta01,200.0, true);
        ContaCorrente cc2 = new ContaCorrente(idConta02,0.0, true);

        List<ContaCorrente> contas = new ArrayList<>();
        contas.add(cc1);
        contas.add(cc2);

        gerenciaContas = new GerenciadoraContas(contas);

        /* Execução */

        boolean sucesso = gerenciaContas.transfereValor(idConta01, 100.0, idConta02);

        /* Verificações */
        assertTrue(sucesso);
        assertThat(cc1.getSaldo(), is(100.0));
        assertThat(cc2.getSaldo(), is(100.0));
    }

    @Test
    public void testTranfereValorSaldoNegativo(){

        /* Montagem do cenário */

        int idConta01 = 1;
        int idConta02 = 2;

        ContaCorrente cc1 = new ContaCorrente(idConta01,100.0, true);
        ContaCorrente cc2 = new ContaCorrente(idConta02,0.0, true);

        List<ContaCorrente> contas = new ArrayList<>();
        contas.add(cc1);
        contas.add(cc2);

        gerenciaContas = new GerenciadoraContas(contas);

        /* Execução */

        boolean sucesso = gerenciaContas.transfereValor(idConta01, 200.0, idConta02);

        /* Verificações */
        assertTrue(sucesso);
        assertThat(cc1.getSaldo(), is(-100.0));
        assertThat(cc2.getSaldo(), is(200.0));
    }

    @Test
    public void testTranfereValorSaldoNegatico_1(){

        /* Montagem do cenário */

        int idConta01 = 1;
        int idConta02 = 2;

        ContaCorrente cc1 = new ContaCorrente(idConta01,-100.0, true);
        ContaCorrente cc2 = new ContaCorrente(idConta02,0.0, true);

        List<ContaCorrente> contas = new ArrayList<>();
        contas.add(cc1);
        contas.add(cc2);

        gerenciaContas = new GerenciadoraContas(contas);

        /* Execução */

        boolean sucesso = gerenciaContas.transfereValor(idConta01, 200.0, idConta02);

        /* Verificações */
        assertTrue(sucesso);
        assertThat(cc1.getSaldo(), is(-300.0));
        assertThat(cc2.getSaldo(), is(200.0));
    }

    @Test
    public void testTranfereValorSaldoNegaticoParaSaldoNegativo(){

        /* Montagem do cenário */

        int idConta01 = 1;
        int idConta02 = 2;

        ContaCorrente cc1 = new ContaCorrente(idConta01,-100.0, true);
        ContaCorrente cc2 = new ContaCorrente(idConta02,-100.0, true);

        List<ContaCorrente> contas = new ArrayList<>();
        contas.add(cc1);
        contas.add(cc2);

        gerenciaContas = new GerenciadoraContas(contas);

        /* Execução */

        boolean sucesso = gerenciaContas.transfereValor(idConta01, 200.0, idConta02);

        /* Verificações */
        assertTrue(sucesso);
        assertThat(cc1.getSaldo(), is(-300.0));
        assertThat(cc2.getSaldo(), is(100.0));
    }

}

