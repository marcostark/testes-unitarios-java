import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class GerenciadoraContasTest_0 {

    private GerenciadoraContas gerenciaContas;

    @Test
    public void testTranfereValor(){

        /* Montagem do cenário */

        ContaCorrente cc1 = new ContaCorrente(1,100, true);
        ContaCorrente cc2 = new ContaCorrente(2,100, true);

        List<ContaCorrente> contas = new ArrayList<>();
        contas.add(cc1);
        contas.add(cc2);

        gerenciaContas = new GerenciadoraContas(contas);

        /* Execução */

        boolean sucesso = gerenciaContas.transfereValor(1, 100, 2);

        /* Verificações */
        assertTrue(sucesso);

    }

}

