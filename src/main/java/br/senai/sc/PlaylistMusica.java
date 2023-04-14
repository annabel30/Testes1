package br.senai.sc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlaylistMusica {

    private String nome;
    private List<Musica> musicas;

    public PlaylistMusica(String nome) {
        this.nome = nome;
        this.musicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public boolean adicionarMusica(Musica musica) {
        if (musica != null) {
            musicas.add(musica);
            return true;
        } else {
            return false;
        }
    }

    public boolean removerMusica(Musica musica) {
        return musicas.remove(musica);
    }

    public Musica buscarMusicaPorTitulo(String titulo) {
        return musicas.stream()
                .filter(musica -> musica.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Musica> buscarMusicasPorArtista(String artista) {
        List<Musica> musicasPorArtista = new ArrayList<>();
        for (Musica musica : musicas) {
            if (musica.getArtista().equalsIgnoreCase(artista)) {
                musicasPorArtista.add(musica);
            }
        }
        return musicasPorArtista;
    }

    public void ordenarPorTitulo() {
        musicas.sort(Comparator.comparing(Musica::getTitulo));
    }

    public void ordenarPorArtista() {
        musicas.sort(Comparator.comparing(Musica::getArtista));
    }

    public int getQuantidadeMusicas() {
        return musicas.size();
    }
}