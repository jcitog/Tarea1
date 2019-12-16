package model.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.map.Field;
import model.map.Location;
import model.tacticians.Tactician;
import model.units.Alpaca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test set for the factory that makes Alpacas.
 *
 *
 */
class factoryAlpacaTest {
  private Field field;
  @BeforeEach
  public void setUp() {
    field = new Field();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        this.field.addCells(false, new Location(i, j));
      }
    }
  }

  @Test
  public void Test(){
    Tactician t1 = new Tactician("brayan",null,field);
    Tactician t2 = new Tactician("ole",null,field);
    factoryAlpaca factoryAlpaca = new factoryAlpaca();
    t1.changeFactory(factoryAlpaca);
    t1.addUnit(45,1,3,2);
    assertTrue(t1.getSelectedUnit() instanceof Alpaca);
    t2.changeFactory(factoryAlpaca);
    t2.addUnit(45,1,7,3);
    assertEquals(t2.getUnitList().get(0),t2.getSelectedUnit());
  }
}