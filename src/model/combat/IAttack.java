package model.items;

import model.units.IUnit;

/**
        * Common interface for all the attacks. Every attack have a name, a power, a minimum range,
        * and a maximus range, and should be able to damage a Unit.
        * @author Ignacio Slater Muñoz
        * @version 1.1b2
        * @since 1.1b1
        */
public interface IAttack {

  /**
   * An attack damages a Unit based on the attack's power, it's weapon and the weapon of the
   * Unit that receives the attack.
   *
   * @param other
   *     Unit that receives the attack.
   */
  void attack(IUnit other);

  /**
   * Getter for the power.
   *
   * @return power of the attack.
   */
  int getPower();

  /**
   * Getter for the attack's name.
   *
   * @return Name of the attack.
   */
  String getName();

  /**
   * Getter for the minimium range of the attack.
   *
   * @return minimium range.
   */

  int getminRange();

  /**
   * Getter for the maximum range of the attack.
   *
   * @return maximum range.
   */

  int getmaxRange();
}
