package model.items;

import model.map.Location;
import model.units.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for swords
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordTest extends AbstractTestItem {

  private Sword sword;
  private Sword wrongSword;
  private SwordMaster swordMaster;
  private Sorcerer sorcerer;
  private MagicBookAnima magicBookAnima;
  private MagicBookAnima wrongmagicBookAnima;
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
  private Alpaca alpaca;
  private MagicBookOscuridad magicBookOscuridad;
  private MagicBookLuz magicBookLuz;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "exodia";
    expectedPower = 20;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    magicBookAnima = new MagicBookAnima(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    sorcerer = new Sorcerer(120, 4, new Location(0, 0));
    spear = new Spear("lanzamolo", 20, 1, 2);
    hero = new Hero(120, 4, new Location(1, 0));
    fighter = new Fighter(120, 4, new Location(1, 0));
    axe = new Axe("hacha de leñador", 20, 1, 2);
    archer = new Archer(120, 4, new Location(1, 0));
    cleric = new Cleric(120, 4, new Location(1, 0));
    alpaca = new Alpaca(120, 4, new Location(1, 0));
    magicBookOscuridad = new MagicBookOscuridad("bible", 20, 1, 2);
    magicBookLuz = new MagicBookLuz("librin", 70, 1, 2);
    swordMaster = new SwordMaster(1000, 4, new Location(1, 0));
    sword = new Sword("exodia", 20, 1, 2);
    bow = new Bow("ocra", 2000, 2, 4);
    archer = new Archer(120, 4, new Location(1, 0));
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSword = new Sword("Wrong sword", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(1000, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSword;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return sword;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Test
  public void swordTest() {
    magicBookAnima.equipToSorcerer(sorcerer);
    spear.equipToHero(hero);
    assertEquals(spear, hero.getEquippedItem());
    axe.equipToFighter(fighter);
    assertEquals(swordMaster.getCurrentHitPoints(), 1000);
    assertEquals(axe, fighter.getEquippedItem());
    sword.equipToSwordMaster(swordMaster);
    assertEquals(sword, swordMaster.getEquippedItem());
    bow.equipToArcher(archer);
    assertEquals(bow, archer.getEquippedItem());
    sword.receiveSpearAttack(spear);
    assertEquals(swordMaster.getCurrentHitPoints(), 970);
    sword.receiveAxeAttack(axe);
    assertEquals(swordMaster.getCurrentHitPoints(), 970);
    sword.receiveSwordAttack(sword);
    assertEquals(swordMaster.getCurrentHitPoints(), 950);
    sword.receiveMBOAttack(magicBookOscuridad);
    assertEquals(swordMaster.getCurrentHitPoints(), 920);
    magicBookLuz.equipToSorcerer(sorcerer);
    magicBookOscuridad.equipToSorcerer(sorcerer);
    sword.receiveMBLAttack(magicBookLuz);
    assertEquals(swordMaster.getCurrentHitPoints(), 815);

    axe.attack(magicBookLuz);

    magicBookAnima.equipToSorcerer(sorcerer);
    sword.receiveMBAAttack(magicBookAnima);
    assertEquals(swordMaster.getCurrentHitPoints(), 785);
    sword.attack(axe);
    assertEquals(fighter.getCurrentHitPoints(), 90);
  }
}

