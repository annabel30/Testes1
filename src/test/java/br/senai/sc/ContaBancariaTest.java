package br.senai.sc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;

public class ContaBancariaTest {

    private ContaBancaria contaBancaria;
    private ContaBancaria contaBancaria2;

    @BeforeEach
    public void setUp(){
        contaBancaria = new ContaBancaria("123", "Annabel");
        contaBancaria2 = new ContaBancaria("1234", "Ana");
    }

    @Test
    public void getNumeroContaTest() {
        String numeroEsperado = "123";
        String numeroObtido = contaBancaria.getNumeroConta();
        assertEquals(numeroEsperado, numeroObtido);
    }

    @Test
    public void getTitularTest() {
        String titularEsperado = "Annabel";
        String titularObtido = contaBancaria.getTitular();
        assertEquals(titularEsperado, titularObtido);
    }

    @Test
    public void getSaldoTest() {
        double saldoEsperado;
        double saldoObtido;

        saldoEsperado = 0;
        saldoObtido = contaBancaria.getSaldo();
        assertEquals(saldoEsperado, saldoObtido);

        saldoEsperado = 200;
        contaBancaria.depositar(200);
        saldoObtido = contaBancaria.getSaldo();
        assertEquals(saldoEsperado, saldoObtido);
    }

    @Test
    public void getTaxaJurosTest() {
        double taxaEsperada;
        double taxaObtida;

        taxaEsperada = 0;
        taxaObtida = contaBancaria.getTaxaJuros();
        assertEquals(taxaEsperada, taxaObtida);

        taxaEsperada = 4.5;
        contaBancaria.setTaxaJuros(4.5);
        taxaObtida = contaBancaria.getTaxaJuros();
        assertEquals(taxaEsperada, taxaObtida);
    }

    @Test
    public void setTaxaJurosTest() {
        double taxaEsperada = 4.5;
        contaBancaria.setTaxaJuros(4.5);
        double taxaObtida = contaBancaria.getTaxaJuros();
        assertEquals(taxaEsperada, taxaObtida);
    }

    @Test
    public void depositarTest() {
        assertTrue(contaBancaria.depositar(1000));
        assertFalse(contaBancaria.depositar(-1000));
    }

    @Test
    public void sacarTest() {
        contaBancaria.depositar(5000);
        assertTrue(contaBancaria.sacar(1000));
        assertFalse(contaBancaria.sacar(-1000));
    }

    @Test
    public void transferirTest() {
        double valorRestante = 500;
        contaBancaria.depositar(1000);
        assertTrue(contaBancaria.transferir(contaBancaria2, 500));
        assertEquals(valorRestante, contaBancaria.getSaldo());
        assertEquals(valorRestante, contaBancaria2.getSaldo());
    }

    @Test
    public void aplicarJurosTest() {
        contaBancaria.depositar(1000);
        contaBancaria.aplicarJuros();
        assertEquals(1000.0, contaBancaria.getSaldo());
    }

    @Test
    public void alterarTitularTest() {
        assertTrue(contaBancaria.alterarTitular("Caio"));
        assertEquals("Caio", contaBancaria.getTitular());
    }
}
