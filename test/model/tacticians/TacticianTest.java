package model.tacticians;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import controller.GameController;
import model.factories.IFactory;
import model.factories.factoryCleric;
import model.factories.factoryHero;
import model.items.Axe;
import model.items.Staff;
import model.map.Field;
import model.map.Location;
import model.tacticians.Tactician;
import model.units.Alpaca;
import model.units.Cleric;
import model.units.Fighter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Test set for the factory that makes Alpacas.
 *
 *
 */
class TacticianTest {

  private Tactician t1, t2;
  private GameController controller = new GameController(2,50);;
  private Field field;
  private long randomSeed;
  private List<String> testTacticians;
  private IFactory iFactory;
  private Alpaca alpaca;
  private Fighter fighter;
  private Cleric juan;


  @BeforeEach
  void setUp() {
    setTacticians();
    setField();

  }


  public void setField() {
    this.field = new Field();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        this.field.addCells(false, new Location(i, j));
      }
    }

  }

  public void setTacticians() {
    t1 = new Tactician("Player 1", controller, this.field);
    t2 = new Tactician("Player 2", controller, this.field);
  }

  @Test
  public void nameTest() {
    t1.setName("nick");
    assertEquals(t1.getName(), "nick");
  }

  @Test
  public void TacticiansUnitsTest() {
    GameController controller1 = new GameController(2,120);
    t1.setGameController(controller1);
    alpaca = new Alpaca(44, 4, new Location(1, 0));
    t1.getUnitList().add(alpaca);
    assertTrue(t1.getUnitList().contains(alpaca));
    t1.setSelectedUnit(alpaca);
    assertEquals(t1.getSelectedUnit(), alpaca);
    assertEquals(t1.getUnitHP(t1.selectedUnit), 44);
    assertEquals(t1.getUnitMaxHP(t1.selectedUnit), 44);
    assertEquals(t1.getMovement(), 4);
    Fighter fighter = new Fighter(45, 3, new Location(2, 0));
    t1.getUnitList().add(fighter);
    Axe axe = new Axe("hachita", 14, 1, 1);
    fighter.setItems(axe);
    t1.getUnitList().add(fighter);
    t1.setSelectedUnit(fighter);
    t1.selectedUnit.equipItem(axe);
    assertEquals(t1.selectedUnit.getItems().get(0),axe);
    t1.unitMoveTo(2,1);
    //t1.unitActionOn(1,0);
    assertEquals(t1.getUnitInventory(t1.selectedUnit).get(0), axe);
    assertEquals(t1.getMap(), null);
    assertEquals(t1.getFactory(), null);
    factoryHero HF = new factoryHero();
    t1.changeFactory(HF);
    assertEquals(t1.getFactory(), HF);
    t1.setMap(field);
    t1.addUnit(176, 6, 1, 0);
    assertEquals(t1.getUnitMaxHP(t1.selectedUnit), 176);
    assertEquals(t1.getMovement(),6);

    factoryCleric iglesia = new factoryCleric();
    t1.changeFactory(iglesia);
    t1.addUnit(12, 1, 3, 0);
    Staff staff = new Staff("palo santo", 10, 1, 40);
    factoryHero HF1 = new factoryHero();
    //t2.changeFactory(HF1);
    //t2.addUnit(100,5,2,1);
    Axe axe1 = new Axe("hacha1", 12,1,5);
    assertEquals(t1.selectedUnit.getMovement(),1);
    //t1.unitActionOn(1, 0);
    //assertEquals(t1.getUnitHP(t1.selectedUnit), 30);
    t1.surrender();






    //


  }

}