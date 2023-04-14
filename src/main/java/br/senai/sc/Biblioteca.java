package br.senai.sc;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public boolean adicionarLivro(Livro livro) {
        if (livro != null) {
            livros.add(livro);
            return true;
        } else {
            return false;
        }
    }

    public boolean removerLivro(Livro livro) {
        return livros.remove(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> buscarLivrosPorGenero(String genero) {
        List<Livro> livrosPorGenero = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getGenero().equalsIgnoreCase(genero)) {
                livrosPorGenero.add(livro);
            }
        }
        return livrosPorGenero;
    }

    public int getQuantidadeLivros() {
        return livros.size();
    }

}