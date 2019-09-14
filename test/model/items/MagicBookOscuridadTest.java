package model.items;

import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for oscuridad magic books
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class MagicBookOscuridadTest extends AbstractTestItem {

  private MagicBookOscuridad magicBookOscuridad;
  private MagicBookOscuridad wrongmagicBookOscuridad;
  private Sorcerer sorcerer;
  private Spear spear;
  private Hero hero;
  private Axe axe;
  private Fighter fighter;
  private Archer archer;
  private Bow bow;
  private MagicBookAnima anima;
  private MagicBookOscuridad oscuridad;
  private Staff staff;
  private Cleric cleric;
  private SwordMaster swordMaster;
  private Sword sword;
  private Alpaca alpaca;


  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common oscuridad magic book";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    magicBookOscuridad = new MagicBookOscuridad(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    spear = new Spear("lanza",20,1,2);
    hero = new Hero(120,4,new Location(1,0));
    sword = new Sword("espada",20,1,2);
    swordMaster = new SwordMaster(100,4,new Location(2,0));

  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongmagicBookOscuridad = new MagicBookOscuridad("Wrong sword", 0, -1, -2);
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
    return wrongmagicBookOscuridad;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return magicBookOscuridad;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return sorcerer;
  }

  @Test
  public void MBLTest() {
    assertNull(sorcerer.getEquippedItem());
    magicBookOscuridad.equipToSorcerer(sorcerer);
    magicBookOscuridad.receiveSpearAttack(spear);
    spear.equipToHero(hero);
    assertEquals(sorcerer.getCurrentHitPoints(),0);
    magicBookOscuridad.receiveSwordAttack(spear);
    magicBookOscuridad.attack(spear);
    spear.equipTo(hero);
    magicBookOscuridad.attack(spear);
    assertEquals(hero.getCurrentHitPoints(),90);
    magicBookOscuridad.equipToHero(hero);
    assertEquals(spear, hero.getEquippedItem());

    assertEquals(magicBookOscuridad, sorcerer.getEquippedItem());
  }
}
