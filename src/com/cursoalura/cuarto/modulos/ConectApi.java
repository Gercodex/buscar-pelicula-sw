package com.cursoalura.cuarto.modulos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectApi {
    String direccion = "https://swapi.dev/api/films/?search=";
    String id;
    HttpClient cliente;
    HttpRequest request;
    HttpResponse<String> response;

    public ConectApi(String id) throws IOException, InterruptedException {
        direccion += id;
        cliente = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getRespuestaJson(){
        return response.body();
    }

    public void cerrarConexion(){
        cliente.close();
    }
}
