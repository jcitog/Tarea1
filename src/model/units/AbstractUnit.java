package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  protected final List<IEquipableItem> items = new ArrayList<>();
  private double currentHitPoints;
  private double hitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   */
  protected AbstractUnit(final float hitPoints, final int movement,
                         final Location location, final int maxItems, final IEquipableItem... items) {
      this.currentHitPoints = hitPoints;
      this.hitPoints = hitPoints;
      this.movement = movement;
      this.location = location;
      this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  @Override
  public double getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public double getHitPoints(){return hitPoints;};

  @Override
  public void setCurrentHitPoints(double hp) { this.currentHitPoints = hp; }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem(final IEquipableItem item) {
    this.equippedItem = item;
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  public void setOpponent(IUnit other) {
    double distance = this.getLocation().distanceTo(other.getLocation());
    if(distance >= this.getEquippedItem().getMinRange() &&
            distance <= this.getEquippedItem().getMaxRange() &&
              other.getCurrentHitPoints() > 0 &&
                this.getEquippedItem()!=null) {
      this.getEquippedItem().attack(other.getEquippedItem());
      if(distance >= other.getEquippedItem().getMinRange() &&
              distance <= other.getEquippedItem().getMaxRange() &&
                other.getCurrentHitPoints() > 0 &&
                  other.getEquippedItem()!=null){
        other.getEquippedItem().attack(this.getEquippedItem());
      }
      }
  }

  @Override
  public void equipToFighter(Fighter fighter){};

  @Override
  public void equipToArcher(Archer archer){};

  @Override
  public void equipToSorcerer(Sorcerer sorcerer){};

  @Override
  public void equipToHero(Hero hero){};

  @Override
  public void equipToCleric(Cleric cleric){};

  @Override
  public void equipToSwordMaster(SwordMaster swordMaster){};


}
