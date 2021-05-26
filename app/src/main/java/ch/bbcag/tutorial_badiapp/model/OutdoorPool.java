package ch.bbcag.tutorial_badiapp.model;

import java.util.ArrayList;
import java.util.List;

public class OutdoorPool {
    private int id;
    private String name;
    private String location;
    private String canton;
    private List<Basin> basins = new ArrayList<>();


    public OutdoorPool() {
    }

    public OutdoorPool(int id, String name, String location, String canton) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.canton = canton;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public List<Basin> getBasins() {
        return basins;
    }

    public void setBasins(List<Basin> basins) {
        this.basins = basins;
    }

    public void addBasin(Basin basin) {
        basins.add(basin);
    }

    public void removeBasin(Basin basin) {
        basins.remove(basin);
    }
}
