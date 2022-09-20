package droid;

import mechanics.StatusDamage;

import java.util.Random;

import static mechanics.StatusDamage.status.Impact;

public class DBDroid extends Droid {

    public DBDroid(double health, double damage, String name) {
        super(health, damage, name);
        this.resistSl = 0.9;
        this.resistIm = 0.9;
        this.resistFi = 0.9;
        this.resistIc = 0.9;
        this.ignore = 1.4;
    }

    @Override
    public StatusDamage getDamage() {
        return new StatusDamage(Impact, this.damage);
    }

}
