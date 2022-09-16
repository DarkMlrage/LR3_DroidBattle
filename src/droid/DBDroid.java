package droid;

import mechanics.StatusDamage;

import java.util.Random;

public class DBDroid extends Droid {
    int ignore;

    public DBDroid(double health, double damage, String name, int ignore) {
        super(health, damage, name);
        this.ignore = ignore / 15;
    }

    @Override
    public StatusDamage getDamage() {
        return new StatusDamage("Impact", 0, this.damage, 0, 0);
    }

    public double getHit(StatusDamage damage) {

        double actualDamage;
        //Всі резисти 10%
        switch (damage.getStatus()) {
            case "Slash":
                actualDamage = (damage.getSlash()-ignore)*0.9;
                break;
            case "Impact":
                actualDamage = (damage.getImpact()-ignore) * 0.9;
                break;
            case "Fire":
                actualDamage = (damage.getFire()-ignore) * 0.9;
                break;
            case "Ice":
                actualDamage = (damage.getIce()-ignore) * 0.9;
                break;
            default:
                System.out.println("Something go wrong");
                actualDamage = 0;
                break;
        }

        this.health -= actualDamage;

        if (health < 0) {
            health = 0;
        }

        return actualDamage;

    }
}
