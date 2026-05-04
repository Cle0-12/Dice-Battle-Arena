/**
 * Represents a combatant in the Dice Battle Arena.
 * Encapsulates the fighter's name, health points, and base attack power.
 */
public class Fighter {
    private String name;
    private int hp;
    private int attackPower;

    /**
     * Constructs a new Fighter instance.
     * @param name The display name of the fighter.
     * @param hp The starting hit points.
     * @param attackPower The base value used for damage rolls.
     */
    public Fighter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    // --- Accessors and Mutators ---

    public String getName() { return name; }
    
    public int getHp() { return hp; }

    /**
     * Updates the fighter's HP, ensuring it does not drop below zero.
     * @param hp The new HP value.
     */
    public void setHp(int hp) {
        // Using Math.max from java.lang to ensure hp is at least 0
        this.hp = Math.max(0, hp);
    }

    public int getAttackPower() { return attackPower; }

    /**
     * Checks if the fighter is still capable of fighting.
     * @return true if HP > 0, false otherwise.
     */
    public boolean isAlive() {
        return this.hp > 0;
    }
}