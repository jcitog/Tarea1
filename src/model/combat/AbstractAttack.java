package model.items;

import model.units.IUnit;

/**
 * Base class for all the attacks. This contains the methods to access the attack's properties, like
 * it's name and power.
 *
 * @author Ignacio Slater Muñoz
 * @version 1.1rc1
 * @since 1.1b1
 */
public abstract class AbstractAttack implements IAttack {

  private int power;
  private String name;
  private int minRange;
  private int maxRange;

  /**
   * Creates a new attack.
   *
   * @param name
   *     Attack name
   * @param power
   *     power of the attack
   * @param minRange
   *     minimium range of the attack
   * @param maxRange
   *     maximum range of the attack
   */
  protected AbstractAttack(String name, int power, int min) {
    this.power = power;
    this.name = name;
    this.minRange = minRange;
    this.maxRange = maxRange;
  }

  //region Properties
  @Override
  public int getPower() {
    return power;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getMinRange() { return minRange; }

  @Override
  public int getMaxRange() {
    return maxRange;
  }
  //endregion

  /**
   * Checks if this attack is equal to another.
   *
   * @param obj
   *     Object to compare this attack.
   * @return <code>true</code> if the objects are equal, <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    return obj instanceof IAttack && ((IAttack) obj).getPower() == power
            && ((IAttack) obj).getName().equals(name);
  }
}
