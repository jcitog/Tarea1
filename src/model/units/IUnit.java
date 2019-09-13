package model.units;

import java.util.List;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public interface IUnit {

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  void equipItem(IEquipableItem item);

  /**
   * @return hit points of the unit
   */
  double getCurrentHitPoints();

  /**
   * @return max hit points of the unit
   */
  double getHitPoints();

  /**
   * Sets the current hit points of this unit.
   *
   * @param hp
   *     the hit points to set
   */
  void setCurrentHitPoints(double hp);

  /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  /**
   * @param item
   *     the item to be equipped
   */
  void setEquippedItem(IEquipableItem item);

  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);

  /**
   * Set the opponent of a unit
   *
   * @param other
   *     other unit that will combat
   */
  void setOpponent(IUnit other);

  /**
   * @param fighter
   *     fighter to be equipped
   */
  void equipToFighter(Fighter fighter);

  /**
   * @param archer
   *     archer to be equipped
   */
  void equipToArcher(Archer archer);

  /**
   * @param sorcerer
   *     sorcerer to be equipped
   */
  void equipToSorcerer(Sorcerer sorcerer);

  /**
   * @param hero
   *     hero to be equipped
   */
  void equipToHero(Hero hero);

  /**
   * @param cleric
   *     cleric to be equipped
   */
  void equipToCleric(Cleric cleric);

  /**
   * @param swordMaster
   *     swordMaster to be equipped
   */
  void equipToSwordMaster(SwordMaster swordMaster);

}
