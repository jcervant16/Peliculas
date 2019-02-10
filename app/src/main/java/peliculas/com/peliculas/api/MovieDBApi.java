package peliculas.com.peliculas.api;



import peliculas.com.peliculas.modelo.ListaPeliculas;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDBApi {

    /**
     * Gets popular movies.
     *
     * @param apiKey the api key
     * @return the popular movies
     */
    @GET("movie/popular")
    Call<ListaPeliculas> getPopularMovies(@Query("api_key") String apiKey,@Query("language") String language);

    /**
     * Gets top rated movies.
     *
     * @param apiKey the api key
     * @return the top rated movies
     */
    @GET("movie/top_rated")
    Call<ListaPeliculas> getTopRatedMovies(@Query("api_key") String apiKey,@Query("language") String language);

}

