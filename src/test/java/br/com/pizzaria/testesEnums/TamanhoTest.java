package br.com.pizzaria.testesEnums;

import br.com.pizzaria.entity.enums.Tamanho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TamanhoTest {

    @Test
    public void testNomeTamanhoBrotinho() {
        assertEquals("BROTINHO", Tamanho.BROTINHO.name());
    }

    @Test
    public void testNomeTamanhoPequena() {
        assertEquals("PEQUENA", Tamanho.PEQUENA.name());
    }

    @Test
    public void testNomeTamanhoMedia() {
        assertEquals("MEDIA", Tamanho.MEDIA.name());
    }

    @Test
    public void testNomeTamanhoGrande() {
        assertEquals("GRANDE", Tamanho.GRANDE.name());
    }

    @Test
    public void testNomeTamanhoGigante() {
        assertEquals("GIGANTE", Tamanho.GIGANTE.name());
    }

    @Test
    public void testToStringTamanhoBrotinho() {
        assertEquals("BROTINHO", Tamanho.BROTINHO.toString());
    }

    @Test
    public void testToStringTamanhoPequena() {
        assertEquals("PEQUENA", Tamanho.PEQUENA.toString());
    }

    @Test
    public void testToStringTamanhoMedia() {
        assertEquals("MEDIA", Tamanho.MEDIA.toString());
    }

    @Test
    public void testToStringTamanhoGrande() {
        assertEquals("GRANDE", Tamanho.GRANDE.toString());
    }

    @Test
    public void testToStringTamanhoGigante() {
        assertEquals("GIGANTE", Tamanho.GIGANTE.toString());
    }
}
