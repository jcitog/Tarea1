package model.items;

import model.units.Hero;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class Spear extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }


  public void equipToHero(Hero hero){this.equipTo(hero);}

  @Override
  public void attack(IEquipableItem other) {
    other.receiveSpearAttack(this);
  }

  @Override
  public void counterAttack(IEquipableItem other) {
    other.receiveSpearCounterAttack(this);
  }

  //region Section receive TYPE attack

  @Override
  public void receiveSwordAttack(IEquipableItem other) {
    receiveWeakAttack(other);
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
    receiveStrongAttack(other);
  }

  @Override
  public void receiveMBAAttack(IEquipableItem other) {
    receiveStrongAttack(other);
  }

  //endregion

  //region Section receive TYPE counterattack

  @Override
  public void receiveSwordCounterAttack(IEquipableItem other) {
    receiveWeakCounterAttack(other);
  }

  @Override
  public void receiveAxeCounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  @Override
  public void receiveMBOCounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  @Override
  public void receiveMBLCounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  @Override
  public void receiveMBACounterAttack(IEquipableItem other) {
    receiveStrongCounterAttack(other);
  }

  //endregion


}
