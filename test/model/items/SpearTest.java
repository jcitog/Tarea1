package model.items;

import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for spears
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SpearTest extends AbstractTestItem {

  private Spear javelin;
  private Spear wrongSpear;
  private Hero hero;
  private MagicBookAnima magicBookAnima;
  private MagicBookAnima wrongmagicBookAnima;
  private Sorcerer sorcerer;
  private Spear spear;
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
    expectedName = "Javelin";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 3;
    javelin = new Spear(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    magicBookAnima = new MagicBookAnima("uwu",20,1,2);
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
    wrongSpear = new Spear("Wrong spear", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    hero = new Hero(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSpear;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return javelin;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }

  @Test
  public void SpearTest() {
    magicBookAnima.equipToSorcerer(sorcerer);
    spear.equipToHero(hero);
    assertEquals(spear,hero.getEquippedItem());
    axe.equipToFighter(fighter);
    assertEquals(fighter.getCurrentHitPoints(),1000);
    assertEquals(spear,fighter.getEquippedItem());
    sword.equipToSwordMaster(swordMaster);
    assertEquals(sword,swordMaster.getEquippedItem());
    bow.equipToArcher(archer);
    assertEquals(bow,archer.getEquippedItem());
    spear.receiveSpearAttack(spear);
    assertEquals(hero.getCurrentHitPoints(),1000);
    spear.receiveAxeAttack(axe);
    assertEquals(hero.getCurrentHitPoints(),990);
    spear.receiveSwordAttack(sword);
    assertEquals(hero.getCurrentHitPoints(),960);
    spear.receiveMBOAttack(magicBookOscuridad);
    assertEquals(hero.getCurrentHitPoints(),930);
    magicBookLuz.equipToSorcerer(sorcerer);
    magicBookOscuridad.equipToSorcerer(sorcerer);
    spear.receiveMBLAttack(magicBookLuz);
    assertEquals(hero.getCurrentHitPoints(),825);

    spear.attack(magicBookLuz);

    magicBookAnima.equipToSorcerer(sorcerer);
    spear.receiveMBAAttack(magicBookAnima);
    assertEquals(hero.getCurrentHitPoints(),810);
    spear.equipToArcher(archer);
  }
}
