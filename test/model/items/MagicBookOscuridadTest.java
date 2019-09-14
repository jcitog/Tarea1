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
  private MagicBookAnima magicBookAnima;
  private MagicBookLuz magicBookLuz;
  private Staff staff;
  private Cleric cleric;
  private SwordMaster swordMaster;
  private Sword sword;
  private Alpaca alpaca;
  private Sorcerer sorcerer2;
  private Sorcerer sorcerer3;


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
    fighter = new Fighter(120,4,new Location(1,0));
    axe = new Axe("hacha de leñador",20,1,2);
    archer = new Archer(120,4,new Location(1,0));
    cleric = new Cleric(120,4,new Location(1,0));
    alpaca = new Alpaca (120,4,new Location(1,0));
    magicBookLuz = new MagicBookLuz("librin",70,1,2);
    swordMaster = new SwordMaster(10,4,new Location(1,0));
    sword = new Sword("exodia",20,1,2);
    bow = new Bow("ocra",2000,2,4);
    archer = new Archer(120,4,new Location(1,0));
    sorcerer = new Sorcerer(150, 4,new Location(1,0));
    sorcerer2 = new Sorcerer(150, 4,new Location(1,0));
    sorcerer3= new Sorcerer(10, 4,new Location(1,0));
    magicBookAnima = new MagicBookAnima("PENITA",70,1,2);
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
    sorcerer = new Sorcerer(5000, 5, new Location(0, 0));
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
  public void MBOTest() {
    assertNull(sorcerer.getEquippedItem());
    magicBookOscuridad.equipToSorcerer(sorcerer);
    spear.equipToHero(hero);
    assertEquals(spear,hero.getEquippedItem());
    axe.equipToFighter(fighter);
    assertEquals(axe,fighter.getEquippedItem());
    sword.equipToSwordMaster(swordMaster);
    assertEquals(sword,swordMaster.getEquippedItem());
    bow.equipToArcher(archer);
    assertEquals(bow,archer.getEquippedItem());
    magicBookLuz.equipToSorcerer(sorcerer2);
    magicBookOscuridad.receiveSpearAttack(spear);
    assertEquals(sorcerer.getCurrentHitPoints(),4970);
    magicBookOscuridad.receiveAxeAttack(axe);
    assertEquals(sorcerer.getCurrentHitPoints(),4940);
    magicBookOscuridad.receiveSwordAttack(sword);
    assertEquals(sorcerer.getCurrentHitPoints(),4910);
    magicBookOscuridad.receiveMBLAttack(magicBookLuz);
    assertEquals(sorcerer.getCurrentHitPoints(),4805);
    magicBookAnima.equipToSorcerer(sorcerer3);
    magicBookOscuridad.receiveMBAAttack(magicBookAnima);
    assertEquals(sorcerer.getCurrentHitPoints(),4755);

    magicBookOscuridad.attack(magicBookLuz);

    magicBookOscuridad.receiveBowAttack(bow);
    assertEquals(sorcerer.getCurrentHitPoints(),2755);
  }
}
