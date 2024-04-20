package com.cursoalura.cuarto.principal;

import com.cursoalura.cuarto.modulos.ConectApi;
import com.cursoalura.cuarto.modulos.Pelicula;
import com.cursoalura.cuarto.modulos.Titulo;
import com.google.gson.*;
import com.google.gson.stream.MalformedJsonException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        String json;
        ConectApi conectApi;
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Titulo titulo;
        ArrayList<Titulo> titulos;
        Pelicula pelicula;
        String busqueda;
        boolean bucle = true;
        String menu = """
                ------------------------------------------------
                Buscar por nombre de película:
                (Para mostrar todas las peliculas escriba 'e')
                ------------------------------------------------""";
        String salir = """
                ------------------------------------------------
                Para repetir la búsqueda escriba: 1
                Para salvar en archivo y salir escriba: 2
                ------------------------------------------------""";
        while (bucle){
            System.out.println(menu);
            busqueda = scanner.nextLine().replace(" ","+");
            try {
                conectApi = new ConectApi(busqueda);
                json = conectApi.getRespuestaJson();
                JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
                JsonArray jsonArray = jsonObject.getAsJsonArray("results");
                System.out.println(jsonArray.size() + (jsonArray.size() == 1 ? " resultado" : " resultados"));

                titulos = new ArrayList<>();
                for (int i = 0; i < jsonArray.size(); i++) {
                    pelicula = gson.fromJson(jsonArray.get(i), Pelicula.class);
                    titulo = new Titulo(pelicula);
                    titulos.add(titulo);
                }
                System.out.println(gson.toJson(titulos));

                while (true) {
                    System.out.println(salir);
                    String temp = scanner.nextLine();
                    if (temp.equals("2")) {
                        FileWriter fileWriter = new FileWriter("peliculas.json");
                        fileWriter.write(gson.toJson(titulos));
                        fileWriter.close();
                        System.out.println("Archivo 'peliculas.json' creado");
                        bucle = false;
                        break;
                    } else if (temp.equals("1")) {
                        System.out.println("Menú de búsqueda");
                        break;
                    } else {
                        System.out.println("Opción no reconocida. Intente de nuevo.");
                    }
                }

            } catch (MalformedJsonException e) {
                System.out.println("Error de búsqueda: "+e.getMessage());
                break;
            } catch (InterruptedException e ){
                System.out.println("Error de interrupción: " + e.getMessage());
            } catch (IOException e){
                System.out.println("Error IO: " + e.getMessage());
                break;
            }
        }
		scanner.close();
        System.out.println("Terminado.");
    }
}
