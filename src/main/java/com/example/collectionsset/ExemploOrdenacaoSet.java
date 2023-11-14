package com.example.collectionsset;

import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {


        System.out.println("--\tOrdem de aleatória\t--");
        Set<Serie> minhaSeries = new HashSet<>(){{
            add(new Serie("GOT", "Fantasia",60));
            add(new Serie("Dark", "Drama",60));
            add(new Serie("That '70s show", "comédia",25));
        }};
        for (Serie serie : minhaSeries) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - "
                + serie.getTempoEpisodio());

        System.out.println("--\tOrdem de Inserção\t--");
        Set<Serie> minhaSeries1 = new LinkedHashSet<>(){{
            add(new Serie("GOT", "Fantasia",60));
            add(new Serie("Dark", "Drama",60));
            add(new Serie("That '70s show", "comédia",25));
        }};
        for (Serie serie : minhaSeries1) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - "
                + serie.getTempoEpisodio());

        System.out.println("--\tOrdem Natural (TempoEpisodio)\t--");
        Set<Serie> minhaSeries2 =  new TreeSet<>(minhaSeries1);
        for (Serie serie : minhaSeries2) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - "
                + serie.getTempoEpisodio());


        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhaSeries3 =  new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhaSeries3.addAll(minhaSeries);
        for (Serie serie : minhaSeries3) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - "
                + serie.getTempoEpisodio());

    }
}
class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer TempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        TempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return TempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", TempoEpisodio=" + TempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Serie serie)) return false;
        return Objects.equals(getNome(), serie.getNome()) && Objects.equals(getGenero(), serie.getGenero()) && Objects.equals(getTempoEpisodio(), serie.getTempoEpisodio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getGenero(), getTempoEpisodio());
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0 ) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0 ) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0 ) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}