package peliculas.com.peliculas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import butterknife.BindView;
import butterknife.ButterKnife;
import peliculas.com.peliculas.constantes.Constantes;
import peliculas.com.peliculas.modelo.Pelicula;

/**
 * The type Movie detail activity.
 */
public class DetallePeliculaActivity extends AppCompatActivity {

    /**
     * The Original title.
     */
    @BindView(R.id.originalTitle)
    TextView originalTitle;

    /**
     * The Title.
     */
    @BindView(R.id.title)
    TextView title;

    /**
     * The Release date.
     */
    @BindView(R.id.releaseDate)
    TextView releaseDate;

    /**
     * The Cover.
     */
    @BindView(R.id.cover)
    ImageView cover;

    /**
     * The Rating.
     */
    @BindView(R.id.rating)
    TextView rating;

    /**
     * The Overview.
     */
    @BindView(R.id.overview)
    TextView overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pelicula);
        ButterKnife.bind(this);

        Pelicula pelicula= (Pelicula) getIntent().getExtras().getSerializable(Constantes.INTENT_MOVIE_DETAIL);

        if (pelicula != null) {
            Glide.with(this).load(Constantes.MOVIEDB_LARGE_POSTER_URL + pelicula.getPosterPath()).into(cover);
            title.setText(pelicula.getTitle());
            originalTitle.setText(pelicula.getOriginalTitle());
            releaseDate.setText(pelicula.getReleaseDate());
            rating.setText(String.valueOf(pelicula.getVoteAverage()));
            overview.setText(pelicula.getOverview());
        }

    }
}
