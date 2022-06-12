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
    private int id;
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
    
    public Film GetMovieById(){
        this.filmModel.id = this.id;
        
        return this.filmModel.SelectById();
    }
    
    public List<Film> GetComingMovies(){
        return this.filmModel.SelectComingMovies();
    }
    
    public List<Film> GetAllMovies(){
        return this.filmModel.SelectAllMovies();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIsReleased() {
        return isReleased;
    }

    public void setIsReleased(boolean isReleased) {
        this.isReleased = isReleased;
    }
}
