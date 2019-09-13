package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test set for anima magic books
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class MagicBookAnimaTest extends AbstractTestItem {

  private MagicBookAnima magicBookAnima;
  private MagicBookAnima wrongmagicBookAnima;
  private Sorcerer sorcerer;


  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common anima magic book";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    magicBookAnima = new MagicBookAnima(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongmagicBookAnima = new MagicBookAnima("Wrong sword", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    sorcerer = new Sorcerer(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongmagicBookAnima;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return magicBookAnima;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return sorcerer;
  }
}