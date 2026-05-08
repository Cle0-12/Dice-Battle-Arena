<<<<<<< HEAD
/**
 * Laboratory Exercise 03: Dice Battle Arena
 * 
 * This program demonstrates the use of the following Java API classes:
 * 1. java.util.ArrayList - Used to store the dynamic list of Fighter objects.
 * 2. java.util.Collections - Used for shuffling the turn order of fighters.
 * 3. java.util.Random - Used for selecting targets and determining attack types.
 * 4. java.lang.Math - Used for ensuring HP does not drop below zero via Math.max().
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Main {

    /**
     * Entry point of the application. Manages the game loop and battle report.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<Fighter> arena = new ArrayList<>();
        Random rand = new Random();

        // 1. Initialize 5 Fighters
        arena.add(new Fighter("Arthur the Knight", 100, 15));
        arena.add(new Fighter("Thrall the Orc", 120, 12));
        arena.add(new Fighter("Jaina the Mage", 75, 25));
        arena.add(new Fighter("Valeera the Rogue", 85, 20));
        arena.add(new Fighter("Patch the Goblin", 50, 10));

        System.out.println("--- BATTLE REPORT: STARTING STATS ---");
        for (Fighter f : arena) {
            System.out.println(f.getName() + " - HP: " + f.getHp() + " | ATK: " + f.getAttackPower());
        }

        int round = 1;
        
        // 2. Main Battle Loop
        while (arena.size() > 1) {
            System.out.println("\n--- ROUND " + round + " ---");
            
            // Randomize turn order using Collections API
            Collections.shuffle(arena);

            for (int i = 0; i < arena.size(); i++) {
                Fighter attacker = arena.get(i);
                if (!attacker.isAlive()) continue;

                // Select a random target that isn't the attacker
                Fighter target;
                do {
                    target = arena.get(rand.nextInt(arena.size()));
                } while (target == attacker || !target.isAlive());

                // 3. Demonstrate Overloaded Methods
                int damage;
                int attackType = rand.nextInt(3);

                if (attackType == 0) {
                    damage = BattleUtils.rollDamage(attacker.getAttackPower());
                } else if (attackType == 1) {
                    damage = BattleUtils.rollDamage(attacker.getAttackPower(), 7);
                } else {
                    damage = BattleUtils.rollDamage(attacker.getAttackPower(), 1.5, "Steel Sword");
                }

                // Apply damage using encapsulated method
                target.setHp(target.getHp() - damage);
                System.out.println(attacker.getName() + " hits " + target.getName() + " for " + damage + " dmg!");

                if (!target.isAlive()) {
                    System.out.println(">> " + target.getName() + " has fallen!");
                }
            }

            // Cleanup: Remove dead fighters from the list
            arena.removeIf(f -> !f.isAlive());
            round++;
        }

        // 4. Final Battle Report
        System.out.println("\n============================");
        System.out.println("THE WINNER IS: " + arena.get(0).getName());
        System.out.println("============================");
    }
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Driver program for the Dice Battle Arena.
 * * Java API Classes Used:
 * 1. java.util.ArrayList - Dynamic storage for the active fighters.
 * 2. java.util.Collections - Shuffling turn order for the fighters.
 * 3. java.util.Random - Targeting and selecting which attack to use.
 */
public class Main {

    /**
     * Entry point of the application. Manages the game loop and battle report.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<Fighter> arena = new ArrayList<>();
        Random rand = new Random();

        // 1. Initialize 5 Fighters
        arena.add(new Fighter("Arthur the Knight", 100, 15));
        arena.add(new Fighter("Thrall the Orc", 120, 12));
        arena.add(new Fighter("Jaina the Mage", 75, 25));
        arena.add(new Fighter("Valeera the Rogue", 85, 20));
        arena.add(new Fighter("Patch the Goblin", 50, 10));

        System.out.println("--- BATTLE REPORT: STARTING STATS ---");
        for (Fighter f : arena) {
            System.out.println(f.getName() + " - HP: " + f.getHp() + " | ATK: " + f.getAttackPower());
        }

        int round = 1;
        
        // 2. Main Battle Loop
        while (arena.size() > 1) {
            System.out.println("\n--- ROUND " + round + " ---");
            
            // Randomize turn order using Collections API
            Collections.shuffle(arena);

            for (int i = 0; i < arena.size(); i++) {
                Fighter attacker = arena.get(i);
                if (!attacker.isAlive()) continue;

                // Select a random target that isn't the attacker
                Fighter target;
                do {
                    target = arena.get(rand.nextInt(arena.size()));
                } while (target == attacker || !target.isAlive());

                // 3. Demonstrate Overloaded Methods
                int damage;
                int attackType = rand.nextInt(3);

                if (attackType == 0) {
                    damage = BattleUtils.rollDamage(attacker.getAttackPower());
                } else if (attackType == 1) {
                    damage = BattleUtils.rollDamage(attacker.getAttackPower(), 7);
                } else {
                    damage = BattleUtils.rollDamage(attacker.getAttackPower(), 1.5, "Steel Sword");
                }

                // Apply damage using encapsulated method
                target.setHp(target.getHp() - damage);
                System.out.println(attacker.getName() + " hits " + target.getName() + " for " + damage + " dmg!");

                if (!target.isAlive()) {
                    System.out.println(">> " + target.getName() + " has fallen!");
                }
            }

            // Cleanup: Remove dead fighters from the list
            arena.removeIf(f -> !f.isAlive());
            round++;
        }

        // 4. Final Battle Report
        System.out.println("\n============================");
        System.out.println("THE WINNER IS: " + arena.get(0).getName());
        System.out.println("============================");
    }
>>>>>>> c26df0ace064d70453cd12bd1593aca34907b572
}