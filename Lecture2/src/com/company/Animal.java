package com.company;

public class Animal {

    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public String getSpecies() {
        return species;
    }

    public boolean canHop() {
        return canHop;
    }

    public boolean canSwim() {
        return canSwim;
    }

    @Override
    public String toString() {

        return
                "species='" + species + '\'' +
                ", canHop='" + canHop + '\'' +
                ", canSwim='" + canSwim + '\''

                ;
    }
}
