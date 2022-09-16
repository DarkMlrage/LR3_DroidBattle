package droid;

import mechanics.StatusDamage;

public class GingerDroid extends Droid {
    int armor;

    public GingerDroid(double health, double damage, String name, int armor) {
        super(health, damage, name);
        this.armor = armor;
    }

    @Override
    public StatusDamage getDamage() {

        return new StatusDamage("Fire", 0, 0, this.damage, 0);
    }

    public double getHit(StatusDamage damage) {


        double actualDamage;

        switch (damage.getStatus()) {
            case "Slash":
                actualDamage = damage.getSlash();
                break;
            case "Impact":
                actualDamage = damage.getImpact() * 0.90;       //0.90- резист до ударного урону
                break;
            case "Fire":
                actualDamage = damage.getFire() * 0.5 * (1 - ((double) armor / 100));  //Вроджений резист до вогню 0.5
                break;
            case "Ice":
                actualDamage = damage.getIce() * 1.5 * (1 - ((double) armor / 100));   //Збільшений урон морозом на 50%
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
