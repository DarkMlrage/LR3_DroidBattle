package droid;

import mechanics.StatusDamage;

public class KurkusDroid extends Droid {
    int shield;

    public KurkusDroid(double health, double damage, String name, int shield) {
        super(health, damage, name);
        this.shield = shield / 5;
    }

    @Override
    public StatusDamage getDamage() {
        return new StatusDamage("Ice", 0, 0, 0, this.damage);
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
                actualDamage = damage.getFire() * 1.4;  //Збільшений урон вогню в 1.4
                break;
            case "Ice":
                actualDamage = damage.getIce() * 0.5;   //Вроджений резист морозу 50%
                break;
            default:
                System.out.println("Something go wrong");
                actualDamage = 0;
                break;
        }
        if (this.shield > 0) {
            this.shield -= actualDamage;
        } else {
            this.health -= actualDamage;
        }


        if (health < 0) {
            health = 0;
        }

        return actualDamage;
    }


}
