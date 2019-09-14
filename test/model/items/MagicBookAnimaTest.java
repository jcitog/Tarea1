package model.items;

import static org.junit.jupiter.api.Assertions.assertTrue;

import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Test;

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
  private Spear spear;
  private Hero hero;
  private Axe axe;
  private Fighter fighter;
  private Archer archer;
  private Bow bow;
  private MagicBookOscuridad oscuridad;
  private MagicBookLuz luz;
  private Staff staff;
  private Cleric cleric;
  private SwordMaster swordMaster;
  private Sword sword;
  private Alpaca alpaca;
  private MagicBookOscuridad magicBookOscuridad;
  private MagicBookLuz magicBookLuz;
  private Sorcerer sorcerer2;


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
    sorcerer= new Sorcerer(120,4,new Location(0,0));
    spear = new Spear("lanzamolo",20,1,2);
    hero = new Hero(120,4,new Location(1,0));
    fighter = new Fighter(120,4,new Location(1,0));
    axe = new Axe("hacha de leñador",20,1,2);
    archer = new Archer(120,4,new Location(1,0));
    cleric = new Cleric(120,4,new Location(1,0));
    alpaca = new Alpaca (120,4,new Location(1,0));
    magicBookOscuridad = new MagicBookOscuridad("bible",20,1,2);
    magicBookLuz = new MagicBookLuz("librin",70,1,2);
    swordMaster = new SwordMaster(10,4,new Location(1,0));
    sword = new Sword("exodia",20,1,2);
    bow = new Bow("ocra",2000,2,4);
    archer = new Archer(120,4,new Location(1,0));
    sorcerer2 = new Sorcerer(150, 4,new Location(1,0));
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
    sorcerer = new Sorcerer(1000, 5, new Location(0, 0));
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


  @Test
  public void MBATest() {
    assertNull(sorcerer.getEquippedItem());
    magicBookAnima.equipToSorcerer(sorcerer);
    spear.equipToHero(hero);
    assertEquals(spear,hero.getEquippedItem());
    axe.equipToFighter(fighter);
    assertEquals(axe,fighter.getEquippedItem());
    sword.equipToSwordMaster(swordMaster);
    assertEquals(sword,swordMaster.getEquippedItem());
    bow.equipToArcher(archer);
    assertEquals(bow,archer.getEquippedItem());
    magicBookLuz.equipToSorcerer(sorcerer2);
    magicBookAnima.receiveSpearAttack(spear);
    assertEquals(sorcerer.getCurrentHitPoints(),970);
    magicBookAnima.receiveAxeAttack(axe);
    assertEquals(sorcerer.getCurrentHitPoints(),940);
    magicBookAnima.receiveSwordAttack(sword);
    assertEquals(sorcerer.getCurrentHitPoints(),910);
    magicBookAnima.receiveMBOAttack(magicBookOscuridad);
    assertEquals(sorcerer.getCurrentHitPoints(),880);
    magicBookOscuridad.equipToSorcerer(sorcerer2);
    magicBookAnima.receiveMBLAttack(magicBookLuz);
    assertEquals(sorcerer.getCurrentHitPoints(),830);

    magicBookAnima.attack(magicBookLuz);

    magicBookAnima.receiveBowAttack(bow);
    assertEquals(sorcerer.getCurrentHitPoints(),0);



  }
}