/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Film;

/**
 *
 * @author osama
 */
public class FilmService {
    private String name;
    private String directorName;
    private int genreId;
    private String decription;
    private String releaseDate;
    private String trailer;
    private String image;
    private boolean isReleased;
    
    private Film filmModel;

    public FilmService() {
        this.filmModel = new Film();
    }

    public FilmService(String name, String directorName, int genreId, String decription, String releaseDate, String trailer, String image, boolean isReleased) {
        this.name = name;
        this.directorName = directorName;
        this.genreId = genreId;
        this.decription = decription;
        this.releaseDate = releaseDate;
        this.trailer = trailer;
        this.image = image;
        this.isReleased = isReleased;
        
        this.filmModel = new Film();
    }
    
    public List<Film> GetComingMovies(){
        return this.filmModel.SelectComingMovies();
    }
}
