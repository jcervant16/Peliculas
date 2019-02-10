package peliculas.com.peliculas.listener;

import android.view.View;



import peliculas.com.peliculas.modelo.Pelicula;


public interface RecyclerViewClickListener {


    void recyclerViewListClicked(View v, Pelicula peliculaActual);
}
