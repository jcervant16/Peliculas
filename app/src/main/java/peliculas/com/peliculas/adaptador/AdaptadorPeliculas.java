package peliculas.com.peliculas.adaptador;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import peliculas.com.peliculas.R;
import peliculas.com.peliculas.constantes.Constantes;
import peliculas.com.peliculas.listener.RecyclerViewClickListener;
import peliculas.com.peliculas.modelo.Pelicula;


public class AdaptadorPeliculas extends RecyclerView.Adapter<AdaptadorPeliculas.MyViewHolder> {

    private List<Pelicula> listaPeliculas;
    private Context mContext;
    private RecyclerViewClickListener recyclerViewClickListener;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * The Title.
         */
        public TextView title;
        /**
         * The Thumbnail.
         */
        public ImageView thumbnail;

        /**
         * Instantiates a new My view holder.
         *
         * @param view the view
         */
        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v, listaPeliculas.get(getLayoutPosition()));
        }
    }


    /**
     * Instantiates a new Movies adapter.
     *
     * @param mContext                  the m context
     * @param listaPeliculas                 the movie list
     * @param recyclerViewClickListener the recycler view click listener
     */
    public AdaptadorPeliculas(Context mContext, List<Pelicula> listaPeliculas, RecyclerViewClickListener recyclerViewClickListener) {
        this.mContext = mContext;
        this.listaPeliculas = listaPeliculas;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Pelicula peli = listaPeliculas.get(position);
        holder.title.setText(peli.getTitle());
        Glide.with(mContext).load(Constantes.MOVIEDB_SMALL_POSTER_URL + peli.getPosterPath()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }
}
