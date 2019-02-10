package peliculas.com.peliculas.api;



import peliculas.com.peliculas.constantes.Constantes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static Retrofit retrofit = null;


    /**
     * Gets client.
     *
     * @return the client
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.MOVIEDB_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
