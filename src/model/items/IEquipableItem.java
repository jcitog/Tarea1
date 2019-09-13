package model.items;

import model.units.*;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);

  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * Sets the owner of this item.
   *
   * @param unit
   *     the unit to set
   */
  void setOwner(IUnit unit);

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  float getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  /**
   * Attack the owner of this item.
   *
   * @param item
   *      the item that will be attacked
   */
  void attack(IEquipableItem item);

  //region Section receive attack
  /**
   * Attack the owner of this item with the spear.
   *
   * @param item
   *     the item that will be attacked with the spear
   */
  void receiveSpearAttack(IEquipableItem item);

  /**
   * Attack the owner of this item with the sword.
   *
   * @param item
   *     the item that will be attacked with the sword
   */
  void receiveSwordAttack(IEquipableItem item);

  /**
   * Attack the owner of this item with the axe.
   *
   * @param item
   *     the item that will be attacked with the axe
   */
  void receiveAxeAttack(IEquipableItem item);

  /**
   * Attack the owner of this item with the bow.
   *
   * @param item
   *     the item that will be attacked with the bow
   */
  void receiveBowAttack(IEquipableItem item);

  /**
   * Attack the owner of this item with the oscuridad magic book.
   *
   * @param item
   *     the item that will be attacked with the oscuridad magic book
   */
  void receiveMBOAttack(IEquipableItem item);

  /**
   * Attack the owner of this item with the luz magic book.
   *
   * @param item
   *     the item that will be attacked with the luz magic book
   */
  void receiveMBLAttack(IEquipableItem item);

  /**
   * Attack the owner of this item with the anima magic book.
   *
   * @param item
   *     the item that will be attacked with the anima magic book
   */
  void receiveMBAAttack(IEquipableItem item);
  //endregion

  //region Section equip items

  /**
   * Equip the item to the unit.
   *
   * @param archer
   *      archer to be equipped
   */
  void equipToArcher(Archer archer);

  /**
   * Equip the item to the unit.
   *
   * @param cleric
   *      cleric to be equipped
   */
  void equipToCleric(Cleric cleric);

  /**
   * Equip the item to the unit.
   *
   * @param fighter
   *      fighter to be equipped
   */
  void equipToFighter(Fighter fighter);

  /**
   * Equip the item to the unit.
   *
   * @param hero
   *      hero to be equipped
   */
  void equipToHero(Hero hero);

  /**
   * Equip the item to the unit.
   *
   * @param sorcerer
   *      sorcerer to be equipped
   */
  void equipToSorcerer(Sorcerer sorcerer);

  /**
   * Equip the item to the unit.
   *
   * @param swordMaster
   *      swordMaster to be equipped
   */
  void equipToSwordMaster(SwordMaster swordMaster);
  //endregion

}
