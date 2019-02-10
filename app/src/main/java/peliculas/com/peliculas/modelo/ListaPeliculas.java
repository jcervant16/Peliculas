package peliculas.com.peliculas.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaPeliculas {


    @SerializedName("results")
    List<Pelicula> resultado;



    public List<Pelicula> getResultado() {
        return resultado;
    }
}
