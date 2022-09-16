package droid;

import mechanics.StatusDamage;

import java.util.Random;

public class NinjaDroid extends Droid {
    int evasion;

    public NinjaDroid(double health, double damage, String name, int evasion) {
        super(health, damage, name);
        this.evasion = evasion;
    }

    @Override
    public StatusDamage getDamage() {
        return new StatusDamage("Slash", this.damage, 0, 0, 0);
    }

    public double getHit(StatusDamage damage) {
        Random random = new Random();

        double actualDamage;

        switch (damage.getStatus()) {
            case "Slash":
                actualDamage = damage.getSlash() * 2;           //Бій між двома ніндязми - лотерея))))
                break;
            case "Impact":
                actualDamage = damage.getImpact() * 1.2;       //Збільшений на 20% ударний урон
                break;
            case "Fire":
                actualDamage = damage.getFire()*1.1;
                break;
            case "Ice":
                actualDamage = damage.getIce()*1.1;
                break;
            default:
                System.out.println("Something go wrong");
                actualDamage = 0;
                break;
        }
        if (random.nextInt(100) > evasion) {
            this.health -= actualDamage;
            if (health < 0) {
                health = 0;
            }
            return actualDamage;
        }

        return 0;
    }

}
