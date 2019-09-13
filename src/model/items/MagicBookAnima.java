package model.items;

import model.units.Sorcerer;

/**
 * This class represents a MagicBookAnima type item.
 * <p>
 * MagicBookAnima are strong against MagicBookLuz and weak against MagicBookOscuridad.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class MagicBookAnima extends AbstractItem {

  /**
   * Creates a new MagicBookAnima.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public MagicBookAnima(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  public void equipToSorcerer(Sorcerer sorcerer){this.equipTo(sorcerer);}

  /**
   * Performs a anima magic book attack.
   * {@inheritDoc}
   *
   * @param other
   *     Unit that receives the attack.
   */
  @Override
  public void attack(IEquipableItem other) {
    other.receiveMBAAttack(this);
  }


  //region Section receive TYPE attack

  @Override
  public void receiveSpearAttack(IEquipableItem other) {
    receiveStrongAttack(other);
  }

  @Override
  public void receiveSwordAttack(IEquipableItem other) {
    receiveStrongAttack(other);
  }

  @Override
  public void receiveAxeAttack(IEquipableItem other) {
    receiveStrongAttack(other);
  }

  @Override
  public void receiveMBOAttack(IEquipableItem other) {
    receiveStrongAttack(other);
  }

  @Override
  public void receiveMBLAttack(IEquipableItem other) {
    receiveWeakAttack(other);
  }
  //endregion


}
