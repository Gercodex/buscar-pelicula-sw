package com.cursoalura.cuarto.modulos;

public class Titulo {
    private String nombre;
    private int id_pelicula;
    private String sinopsis;
    private String director;
    private int fechaLanzamiento;

    public Titulo(Pelicula pelicula) {
        this.nombre = pelicula.title();
        this.id_pelicula = Integer.parseInt(pelicula.episode_id());
        this.sinopsis = pelicula.opening_crawl();
        this.director = pelicula.director();
        this.fechaLanzamiento = Integer.parseInt(pelicula.release_date().substring(0,4));
    }

    @Override
    public String toString(){
        return """
                Nombre de la película: %s
                Fecha de lanzamiento: %d
                Director: %s
                ID: %d
                Sinopsis (inglés): %s
                """.formatted(nombre, fechaLanzamiento, director, id_pelicula, sinopsis);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }


    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
