package model.items;

import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for luz magic books
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class MagicBookLuzTest extends AbstractTestItem {

  private MagicBookLuz magicBookLuz;
  private MagicBookLuz wrongmagicBookLuz;
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
  private MagicBookOscuridad magicBookOscuridad;
  private Sorcerer sorcerer2;


  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common luz magic book";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    magicBookLuz = new MagicBookLuz(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    spear = new Spear("lanza",20,1,2);
    hero = new Hero(120,4,new Location(1,0));
    sword = new Sword("espada",20,1,2);
    swordMaster = new SwordMaster(100,4,new Location(2,0));
    sorcerer= new Sorcerer(120,4,new Location(0,0));
    spear = new Spear("lanza",20,1,2);
    hero = new Hero(120,4,new Location(1,0));
    fighter = new Fighter(120,4,new Location(1,0));
    axe = new Axe("hacha",20,1,2);
    archer = new Archer(120,4,new Location(1,0));
    cleric = new Cleric(120,4,new Location(1,0));
    alpaca = new Alpaca (120,4,new Location(1,0));
    magicBookOscuridad = new MagicBookOscuridad("bible",20000,1,2);
    sorcerer2 = new Sorcerer(120,4,new Location(1,0));
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongmagicBookLuz = new MagicBookLuz("Wrong sword", 0, -1, -2);
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
    return wrongmagicBookLuz;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return magicBookLuz;
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
    magicBookLuz.equipToSorcerer(sorcerer);
    magicBookLuz.receiveSpearAttack(spear);
    spear.equipToHero(hero);
    assertEquals(sorcerer.getCurrentHitPoints(),0);
    magicBookLuz.receiveSwordAttack(spear);
    magicBookLuz.attack(spear);
    spear.equipTo(hero);
    magicBookLuz.attack(spear);
    assertEquals(hero.getCurrentHitPoints(),90);
    magicBookLuz.equipToHero(hero);
    assertEquals(spear, hero.getEquippedItem());
    magicBookLuz.receiveMBOAttack(magicBookOscuridad);

    assertEquals(magicBookLuz, sorcerer.getEquippedItem());
  }
}
