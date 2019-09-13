package model.items;

import model.map.Location;
import model.units.Fighter;
import model.units.Hero;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class AxeTest extends AbstractTestItem {

  private Axe axe;
  private Axe wrongAxe;
  private Fighter fighter;
  private Hero hero;
  private Spear spear;

  @Override
  public void setTestItem() {
    expectedName = "Common axe";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    axe = new Axe(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    spear = new Spear("lanzilla",30,1,2);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongAxe = new Axe("Wrong axe", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongAxe;
  }

  @Override
  public IEquipableItem getTestItem() {
    return axe;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  @Test
  public void axeSpearTest(){
    hero = new Hero(120,4,new Location(1,0));
    fighter.getLocation().addNeighbour(hero.getLocation());
    hero.equipItem(spear);
    //spear.receiveAxeAttack(axe);
    axe.attack(spear);
    //fighter.setOpponent(hero);
    assertEquals(hero.getCurrentHitPoints(),105);
    fighter.swap(axe,hero);
    assertEquals(hero.getCurrentHitPoints(),105);
  }



}