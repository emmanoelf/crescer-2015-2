package br.com.cwi.crescer.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MatematicaTest {

    @Test
    public void deveSomarPositivos() {
        int resultado = new Matematica().somar(1, 1);
        assertEquals(2, resultado);
    }

}
