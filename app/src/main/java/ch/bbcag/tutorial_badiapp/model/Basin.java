package ch.bbcag.tutorial_badiapp.model;

public class Basin {
    private String name;
    private double temp;

    @Override
    public String toString() {
        return name + " " + temp + "°C";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
