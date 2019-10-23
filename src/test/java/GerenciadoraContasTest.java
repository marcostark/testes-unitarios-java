import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GerenciadoraContasTest {

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

        gerenciaContas.transfereValor(1, 100, 2);


        /* Verificações */
        assertThat(cc2.getSaldo(), is(200.0));
        assertThat(cc1.getSaldo(), is(0.0));

    }

}

