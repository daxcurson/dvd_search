package ar.com.strellis.ar.com.strellis.app_dvd_search.data_model;

import java.util.LinkedList;
import java.util.List;

public class DVD
{
    private String title;
    private String UPC;
    private List<Actor> actors;
    private List<Director> directors;

    public DVD()
    {
        actors=new LinkedList<Actor>();
        directors=new LinkedList<Director>();
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getTitle()
    {
        return this.title;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
    }
    public String getUPC() {
        return UPC;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }
}
