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
  private final int maxItems;
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
      this.maxItems= maxItems;
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
  public void setItems (IEquipableItem item){items.add(item);}

  @Override
  public int getMaxItems() {return maxItems;}

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
    if(this.getLocation().distanceTo(other.getLocation()) >= this.getEquippedItem().getMinRange() && this.getLocation().distanceTo(other.getLocation()) <= this.getEquippedItem().getMaxRange() && other.getCurrentHitPoints() > 0 && this.getCurrentHitPoints() > 0) {
      this.getEquippedItem().attack(other.getEquippedItem());
      if(this.getLocation().distanceTo(other.getLocation()) >= other.getEquippedItem().getMinRange() &&
              this.getLocation().distanceTo(other.getLocation()) <= other.getEquippedItem().getMaxRange() &&
                other.getCurrentHitPoints() > 0 &&
                  other.getEquippedItem()!=null){
        other.getEquippedItem().attack(this.getEquippedItem());
      }
      }
  }

  public void swap(IEquipableItem item, IUnit other){
    if(this.items.contains(item) &&
            other.getItems().size() < other.getMaxItems() &&
              other.getLocation().distanceTo(item.getOwner().getLocation())==1) {
          if(this.equippedItem.equals(item)){
            this.equippedItem.equals(null);
          }
          other.setItems(item);
          this.items.remove(item);
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
