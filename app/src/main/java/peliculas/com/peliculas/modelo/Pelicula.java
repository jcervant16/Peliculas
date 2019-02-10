package peliculas.com.peliculas.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Anand Singh on 23-07-2016.
 */
public class Pelicula implements Serializable {

    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private Double voteAverage;
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * Instantiates a new Pelicula.
     *
     * @param overview      the overview
     * @param releaseDate   the release date
     * @param title         the title
     * @param voteAverage   the vote average
     * @param posterPath    the poster path
     * @param originalTitle the original title
     */
    public Pelicula(String overview, String releaseDate, String title, Double voteAverage, String posterPath, String originalTitle) {
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.title = title;
        this.voteAverage = voteAverage;
        this.posterPath = posterPath;
        this.originalTitle = originalTitle;
    }

    /**
     * Gets overview.
     *
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Sets overview.
     *
     * @param overview the overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * Gets release date.
     *
     * @return the release date
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets release date.
     *
     * @param releaseDate the release date
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Gets vote average.
     *
     * @return the vote average
     */
    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     * Sets vote average.
     *
     * @param voteAverage the vote average
     */
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     * Gets poster path.
     *
     * @return the poster path
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * Sets poster path.
     *
     * @param posterPath the poster path
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets original title.
     *
     * @return the original title
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * Sets original title.
     *
     * @param originalTitle the original title
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
}
