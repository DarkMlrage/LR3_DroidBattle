package droid;

import mechanics.StatusDamage;

public class Droid {
    protected String name;
    protected double damage;
    protected double health;

    public Droid(double health, double damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public StatusDamage getDamage() {
        return new StatusDamage("default", 0, 0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public double getHit(StatusDamage damage) {

        double actualDamage = 0;
        this.health -= actualDamage;

        if (health < 0) {
            health = 0;
        }

        return actualDamage;
    }

    @Override
    public String toString() {
        return name + " health " + health;
    }
}
