package br.com.pizzaria.entityTest;

import br.com.pizzaria.entity.Funcionario;
import org.junit.Assert;
import org.junit.Test;

public class FuncionarioTest {

    @Test
    public void testFuncionarioGetterSetter() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("João");
        funcionario.setCargo("Atendente");

        Assert.assertEquals(1L, funcionario.getId().longValue());
        Assert.assertEquals("João", funcionario.getNome());
        Assert.assertEquals("Atendente", funcionario.getCargo());
    }
}
