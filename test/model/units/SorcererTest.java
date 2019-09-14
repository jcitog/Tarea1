package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.*;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class SorcererTest extends AbstractTestUnit {

  private Sorcerer sorcerer;
  private MagicBookOscuridad magicBookOscuridad;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return sorcerer;
  }

  /**
   * Checks if the magic book is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    assertNull(sorcerer.getEquippedItem());
    sorcerer.equipItem(magicBookOscuridad);
    assertEquals(magicBookOscuridad, sorcerer.getEquippedItem());
    assertEquals(sorcerer.getMaxItems(),3);
  }
}