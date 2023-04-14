package br.senai.sc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistMusicaTest {

    private PlaylistMusica playlistMusica;
    private static Musica musica1 = new Musica("Sad but True", "Metallica", 3);
    private static Musica musica2 = new Musica("Chateau", "Blackbear", 9);
    private static Musica musica3 = new Musica("Heartbroken", "Blackbear", 3);

    @BeforeEach
    public void setUp(){
        playlistMusica = new PlaylistMusica("Playlist da Annabel");
        playlistMusica.adicionarMusica(musica1);
    }

    @Test
    public void adicionarMusicaTest() {
        assertTrue(playlistMusica.adicionarMusica(musica2));
    }

    @Test
    public void removerMusicaTest() {
        assertTrue(playlistMusica.removerMusica(musica1));
    }

    @Test
    public void buscarMusicaPorTituloTest() {
        assertEquals(musica1, playlistMusica.buscarMusicaPorTitulo("Sad but True"));
    }

    @Test
    public void buscarMusicasPorArtistaTest() {
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.adicionarMusica(musica3);

        List<Musica> listMusicas = new ArrayList<>();
        listMusicas.add(musica2);
        listMusicas.add(musica3);

        assertEquals(listMusicas, playlistMusica.buscarMusicasPorArtista("Blackbear"));
    }

    @Test
    public void ordenarPorTituloTeste() {
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorTitulo();

        List<Musica> listMusicasTest = new ArrayList<>();
        listMusicasTest.add(musica2);
        listMusicasTest.add(musica1);

        assertEquals(playlistMusica.getMusicas(), listMusicasTest);
    }

    @Test
    public void ordenarPorArtistaTeste() {
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorArtista();

        List<Musica> listMusicasTest = new ArrayList<>();
        listMusicasTest.add(musica2);
        listMusicasTest.add(musica1);

        assertEquals(listMusicasTest, playlistMusica.getMusicas());
    }

    @Test
    public void getQuantidadeMusicasTeste() {
        assertEquals(1, playlistMusica.getQuantidadeMusicas());
    }

    @Test
    public void getNomeTest() {
        String nomeEsperado = "Playlist da Annabel";
        String nomeObtido = playlistMusica.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void setNomeTest() {
        playlistMusica.setNome("AAAA");

        String nomeEsperado = "AAAA";
        String nomeObtido = playlistMusica.getNome();
        assertEquals(nomeEsperado, nomeObtido);
    }

    @Test
    public void getMusicasTest() {
        List<Musica> playlistMusicaTest = new ArrayList<>();
        playlistMusicaTest.add(musica1);

        assertEquals(playlistMusica.getMusicas(), playlistMusicaTest);
    }

}