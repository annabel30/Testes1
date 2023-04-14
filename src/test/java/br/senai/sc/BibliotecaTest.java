package br.senai.sc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private static Livro livro = new Livro("ACOTAR", "Sarah J. Maas", "Fantasia", 2015);

    @BeforeEach
    public void setUp(){
        biblioteca = new Biblioteca("Annabel's Bookstore");
        biblioteca.adicionarLivro(livro);
    }

    @Test
    public void adicionarLivroTest(){
        assertTrue(biblioteca.adicionarLivro(new Livro("Trono de Vidro", "Sarah J. Maas", "Fantasia", 2012)));
    }

    @Test
    public void removerLivroTest(){
        assertTrue(biblioteca.removerLivro(livro));
    }

    @Test
    public void verQtdLivrosTest(){
        assertEquals(1, biblioteca.getQuantidadeLivros());
    }

    @Test
    public void buscarLivrosPorGeneroTest(){
        List<Livro> livros = new ArrayList<>();
        livros.add(livro);
        assertEquals(biblioteca.buscarLivrosPorGenero("Fantasia"), livros);
    }

    @Test
    public void buscarLivrosPorAutorTest(){
        Livro livro = new Livro("ACOTAR", "Sarah Maas", "Fantasia", 2015);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.buscarLivrosPorAutor("Sarah Maas").size());
    }

    @Test
    public void buscarLivroPorTituloTest(){
        Livro livro = new Livro("Trono de Vidro", "Sarah J. Maas", "Fantasia", 2012);
        biblioteca.adicionarLivro(livro);
        assertEquals(livro, biblioteca.buscarLivroPorTitulo("Trono de Vidro"));
    }

    @Test
    public void getNomeTest() {
        String nomeEsperado = "Annabel's Bookstore";
        String nomeObtido = biblioteca.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void setNomeTest() {
        biblioteca.setNome("Ana's Books");

        String nomeEsperado = "Ana's Books";
        String nomeObtido = biblioteca.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void getLivrosTest() {
        List<Livro> listLivrosTest = new ArrayList<>();
        listLivrosTest.add(livro);
        assertEquals(listLivrosTest, biblioteca.getLivros());
    }

}
