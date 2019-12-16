package model.items;

import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for Axes
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
class AxeTest extends AbstractTestItem {

  private Axe axe;
  private Axe wrongAxe;
  private Fighter fighter1;
  private Hero hero;
  private Spear spear;
  private Archer archer;
  private Bow bow;
  private MagicBookAnima magicBookAnima;
  private MagicBookLuz magicBookLuz;
  private MagicBookOscuridad magicBookOscuridad;
  private Staff staff;
  private Cleric cleric;
  private SwordMaster swordMaster;
  private Sword sword;
  private Alpaca alpaca;
  private Sorcerer sorcerer;

  @Override
  public void setTestItem() {
    expectedName = "Common axe";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    axe = new Axe(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    magicBookAnima = new MagicBookAnima(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    sorcerer= new Sorcerer(12000,4,new Location(0,0));
    spear = new Spear("lanzamolo",20,1,2);
    hero = new Hero(120,4,new Location(1,0));
    fighter1 = new Fighter(820,4,new Location(1,0));
    archer = new Archer(120,4,new Location(1,0));
    cleric = new Cleric(120,4,new Location(1,0));
    alpaca = new Alpaca (120,4,new Location(1,0));
    magicBookOscuridad = new MagicBookOscuridad("bible",20,1,2);
    magicBookLuz = new MagicBookLuz("librin",70,1,2);
    swordMaster = new SwordMaster(10,4,new Location(1,0));
    sword = new Sword("exodia",20,1,2);
    bow = new Bow("ocra",2000,2,4);
    archer = new Archer(120,4,new Location(1,0));
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
    fighter1 = new Fighter(1000, 5, new Location(0, 0));
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
    return fighter1;
  }

  @Test
  public void MBATest() {
    magicBookAnima.equipToSorcerer(sorcerer);
    spear.equipToHero(hero);
    assertEquals(spear,hero.getEquippedItem());
    axe.equipToFighter(fighter1);
    assertEquals(fighter1.getCurrentHitPoints(),1000);
    assertEquals(axe,fighter1.getEquippedItem());
    sword.equipToSwordMaster(swordMaster);
    assertEquals(sword,swordMaster.getEquippedItem());
    bow.equipToArcher(archer);
    assertEquals(bow,archer.getEquippedItem());
    axe.receiveSpearAttack(spear);
    assertEquals(fighter1.getCurrentHitPoints(),1000);
    axe.receiveAxeAttack(axe);
    assertEquals(fighter1.getCurrentHitPoints(),990);
    axe.receiveSwordAttack(sword);
    assertEquals(fighter1.getCurrentHitPoints(),960);
    axe.receiveMBOAttack(magicBookOscuridad);
    assertEquals(fighter1.getCurrentHitPoints(),930);
    magicBookLuz.equipToSorcerer(sorcerer);
    magicBookOscuridad.equipToSorcerer(sorcerer);
    axe.receiveMBLAttack(magicBookLuz);
    assertEquals(fighter1.getCurrentHitPoints(),825);

    axe.attack(magicBookLuz);
    axe.heal(magicBookLuz);

    magicBookAnima.equipToSorcerer(sorcerer);
    axe.receiveMBAAttack(magicBookAnima);
    assertEquals(fighter1.getCurrentHitPoints(),810);
    axe.equipToArcher(archer);




  }


}