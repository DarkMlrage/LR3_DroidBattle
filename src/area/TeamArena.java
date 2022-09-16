package area;

import droid.Droid;
import utilits.SaveFight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TeamArena {

    private final List<Droid> blueDroids = new ArrayList<>();
    private final List<Droid> redDroids = new ArrayList<>();
    private Droid attacker;
    private Droid defender;
    private int currentRound = 0;

    public TeamArena(List<Droid> droids) {

        for (int i = 0; i < droids.size(); i++) {
            if ((i + 1) % 2 == 0) {
                this.blueDroids.add(droids.get(i));
            } else {
                this.redDroids.add(droids.get(i));
            }
        }
    }

    public Droid startFight() throws InterruptedException {
        do {
            prepareRound();
            double actualDamage = doFight();
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
        } while (defender.isAlive());

        return attacker;
    }

    private double doFight() {
        return defender.getHit(attacker.getDamage());
    }

    private void printRoundInfo(double actualDamage) {
        SaveFight.log(defender.getName() + " get hit with " + actualDamage + " damage");
        SaveFight.log("Defender " + defender);
        SaveFight.log("Attacker " + attacker);
    }

    private void prepareRound() {
        initFighters();
        currentRound++;
        SaveFight.log("-------------------------------------");
        SaveFight.log("Round " + currentRound);
    }

    private void initFighters() {
        Random random = new Random();
        Droid blue = blueDroids.get(random.nextInt(blueDroids.size()));
        Droid red = redDroids.get(random.nextInt(redDroids.size()));

        if (random.nextBoolean()) {
            if (!blue.isAlive()) {
                while (!blue.isAlive()) {
                    blue = blueDroids.get(random.nextInt(blueDroids.size()));
                }
            }
            attacker = blue;

            if (!red.isAlive()) {
                while (!red.isAlive()) {
                    red = redDroids.get(random.nextInt(redDroids.size()));
                }
            }
            defender = red;
        } else {
            if (!red.isAlive()) {
                while (!red.isAlive()) {
                    red = redDroids.get(random.nextInt(redDroids.size()));
                }
            }
            attacker = red;

            if (!blue.isAlive()) {
                while (!blue.isAlive()) {
                    blue = blueDroids.get(random.nextInt(blueDroids.size()));
                }
            }
            defender = blue;
        }
    }

}
