package peliculas.com.peliculas;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import peliculas.com.peliculas.adaptador.AdaptadorPeliculas;
import peliculas.com.peliculas.api.MovieDBApi;
import peliculas.com.peliculas.api.RetrofitClient;
import peliculas.com.peliculas.constantes.Constantes;
import peliculas.com.peliculas.listener.RecyclerViewClickListener;
import peliculas.com.peliculas.modelo.ListaPeliculas;
import peliculas.com.peliculas.modelo.Pelicula;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Callback<ListaPeliculas>, RecyclerViewClickListener {

    private RecyclerView recyclerView;
    private final static String TAG = MainActivity.class.getSimpleName();
    private MovieDBApi movieDBApi;
    private Call<ListaPeliculas> call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        movieDBApi = RetrofitClient.getClient().create(MovieDBApi.class);

        call = movieDBApi.getPopularMovies(Constantes.MOVIEDB_API_KEY,"es");
        call.enqueue(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hola jose", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onResponse(Call<ListaPeliculas> call, Response<ListaPeliculas> response) {
        Log.i(TAG, String.valueOf(response.code()));
        if (response.code() == 200) {
            AdaptadorPeliculas adaptador = new AdaptadorPeliculas(this, response.body().getResultado(), this);
            recyclerView.setAdapter(adaptador);
        }
    }

    @Override
    public void onFailure(Call<ListaPeliculas> call, Throwable t) {
        Log.e(TAG, t.getLocalizedMessage());
    }
    @Override
    public void recyclerViewListClicked(View v, Pelicula actual) {
        Intent intent = new Intent(this, DetallePeliculaActivity.class);
        intent.putExtra(Constantes.INTENT_MOVIE_DETAIL, actual);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 0, 0, getString(R.string.most_popular));
        menu.add(Menu.NONE, 1, 1, getString(R.string.top_rated));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                call = movieDBApi.getPopularMovies(Constantes.MOVIEDB_API_KEY,"es");
                call.enqueue(this);
                break;

            case 1:
                call = movieDBApi.getTopRatedMovies(Constantes.MOVIEDB_API_KEY,"es");
                call.enqueue(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
