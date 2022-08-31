package com.noitcereon.movieapispringboot.models;

import java.util.ArrayList;

public class MovieCreateUpdate {
    private String title;
    private int releaseYear;
    private ArrayList<Long> actorIds;

    public MovieCreateUpdate(){}
    public MovieCreateUpdate(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.actorIds = new ArrayList<>();
    }
    public MovieCreateUpdate(String title, int releaseYear, ArrayList<Long> actorIds) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.actorIds = actorIds;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public ArrayList<Long> getActorIds() {
        return actorIds;
    }

}
