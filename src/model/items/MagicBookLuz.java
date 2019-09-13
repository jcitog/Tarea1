package model.items;

import model.units.Sorcerer;

/**
 * This class represents a MagicBookLuz type item.
 * <p>
 * MagicBookluz are strong against MagicBookOscuridad and weak against MagicBookAnima.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class MagicBookLuz extends AbstractItem {

  /**
   * Creates a new MagicBookLuz.
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
  public MagicBookLuz(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  public void equipToSorcerer(Sorcerer sorcerer){this.equipTo(sorcerer);}

  @Override
  public void attack(IEquipableItem other) {
    other.receiveMBLAttack(this);
  }

  @Override
  public void counterAttack(IEquipableItem other) {
    other.receiveMBLCounterAttack(this);
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
    receiveWeakAttack(other);
  }

  @Override
  public void receiveMBAAttack(IEquipableItem other) {
    receiveStrongAttack(other);
  }

  //endregion

  //region Section receive TYPE counterattack

  @Override
  public void receiveSpearCounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  @Override
  public void receiveSwordCounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  @Override
  public void receiveAxeCounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  @Override
  public void receiveMBOCounterAttack(IEquipableItem other) {
    receiveWeakCounterAttack(other);
  }

  @Override
  public void receiveMBACounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  //endregion

}
