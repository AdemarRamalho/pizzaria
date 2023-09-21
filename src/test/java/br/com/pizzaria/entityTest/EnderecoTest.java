package br.com.pizzaria.entityTest;

import br.com.pizzaria.entity.Endereco;
import org.junit.Assert;
import org.junit.Test;

public class EnderecoTest {

    @Test
    public void testEnderecoGetterSetter() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setNomeRua("Rua Principal");
        endereco.setNumeroCasa(123);

        Assert.assertEquals(1L, endereco.getId().longValue());
        Assert.assertEquals("Rua Principal", endereco.getNomeRua());
        Assert.assertEquals(123, endereco.getNumeroCasa());
    }
}

