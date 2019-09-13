package model.combat;

import model.combat.AbstractAttack;
import model.units.IUnit;

/**
 * This class defines the logic of a axe attack.
 *
 * @author Ignacio Slater Muñoz
 * @version 1.1b10
 * @since 1.1b1
 */
public class AxeAttack extends AbstractAttack {

  /**
   * Creates a new bow attack.
   *
   * @param name
   *     Attack name
   * @param power
   *     power of the attack
   * @param minRange
   *     minimum range of the attack
   * @param maxRange
   *     maximus range of the attack
   */
  public AxeAttack(String name, int power, int minRange int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * Performs a Axe attack.
   * {@inheritDoc}
   *
   * @param other
   *     Unit that receives the attack.
   */
  @Override
  public void attack(IUnit other) {
    other.receiveAxeAttack(this);
  }


}