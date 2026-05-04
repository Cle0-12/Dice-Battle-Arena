import java.util.Random;

/**
 * Utility class for battle calculations and combat logging.
 * Demonstrates method overloading with multiple signatures for damage calculation.
 */
public class BattleUtils {
    private static Random random = new Random();

    /**
     * Overload 1: Basic attack roll.
     * @param basePower The fighter's attack stat.
     * @return A random integer between 1 and the basePower.
     */
    public static int rollDamage(int basePower) {
        return random.nextInt(basePower) + 1;
    }

    /**
     * Overload 2: Attack roll with a flat bonus.
     * @param basePower The fighter's attack stat.
     * @param bonus Extra damage added to the result.
     * @return The dice roll plus the bonus.
     */
    public static int rollDamage(int basePower, int bonus) {
        return (random.nextInt(basePower) + 1) + bonus;
    }

    /**
     * Overload 3: Weapon-specific attack roll with a multiplier.
     * @param basePower The fighter's attack stat.
     * @param multiplier The strength multiplier of the weapon.
     * @param weaponName The name of the weapon used (for logging).
     * @return The final damage as an integer.
     */
    public static int rollDamage(int basePower, double multiplier, String weaponName) {
        System.out.print("[" + weaponName + " Swing] ");
        int roll = random.nextInt(basePower) + 1;
        return (int) (roll * multiplier);
    }
}