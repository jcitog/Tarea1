package model.items;

import model.units.*;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public void equipTo(final IUnit unit) {
    unit.setEquippedItem(this);
    owner = unit;
  }

  @Override
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public float getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }

  //region Section equip item to unit
  @Override
  public void equipToArcher(Archer archer){}

  @Override
  public void equipToCleric(Cleric cleric){}

  @Override
  public void equipToFighter(Fighter fighter){}

  @Override
  public void equipToHero(Hero hero){}

  @Override
  public void equipToSorcerer(Sorcerer sorcerer){}

  @Override
  public void equipToSwordMaster(SwordMaster swordmaster){}
  //endregion

  //region Section receive attacks by debility and staff heal
  /**
   * Receives an attack to which this weapon is neutral.
   *
   * @param item
   *     the owner of the item receives a neutral attack.
   */
  protected void receiveNeutralAttack(IEquipableItem item)  {
    double power = item.getPower();
    double HPBeforeA = this.getOwner().getCurrentHitPoints();
    double HPAfterA = HPBeforeA - power;
    if(HPAfterA <= 0){
      HPAfterA= 0;
      this.getOwner().setCurrentHitPoints(HPAfterA);
      this.counterAttack(item);
    }
    else{
      this.getOwner().setCurrentHitPoints(HPAfterA);
      this.counterAttack(item);
    }
  }

  /**
   * Receives an attack to which this item is weak.
   *
   * @param item
   *     the owner of the item receives a strong attack.
   */
  protected void receiveStrongAttack(IEquipableItem item) {
    double power = item.getPower();
    double HPBeforeA = this.getOwner().getCurrentHitPoints();
    double HPAfterA = HPBeforeA - (power * 1.5);
    if(HPAfterA <= 0){
      HPAfterA= 0;
      this.getOwner().setCurrentHitPoints(HPAfterA);
      this.counterAttack(item);
    }
    else{
      this.getOwner().setCurrentHitPoints(HPAfterA);
      this.counterAttack(item);
    }
  }

  /**
   * Receives an attack to which this item is resistant.
   *
   * @param item
   *     the owner of the item receives a weak attack.
   */
  protected void receiveWeakAttack(IEquipableItem item) {
    double power = item.getPower();
    double HPBeforeA = this.getOwner().getCurrentHitPoints();
    double HPAfterA = HPBeforeA - (power - 20);
    if(HPAfterA <= 0){
      HPAfterA= 0;
      this.getOwner().setCurrentHitPoints(HPAfterA);
      this.counterAttack(item);
    }
    else{
      this.getOwner().setCurrentHitPoints(HPAfterA);
      this.counterAttack(item);
    }
  }

  public void receiveClericAbility(IEquipableItem item){
    double power = item.getPower();
    double HPBeforeA = this.getOwner().getCurrentHitPoints();
    double HPAfterA = HPBeforeA + power;
    if(HPAfterA <= this.getOwner().getHitPoints()){
      this.getOwner().setCurrentHitPoints(this.getOwner().getHitPoints());
    }
    else{
      this.getOwner().setCurrentHitPoints(HPAfterA);
    }
  }
  //endregion

  //region Section receive attacks by item
  @Override
  public void receiveAxeAttack(IEquipableItem other) {
    receiveNeutralAttack(other);
  }

  @Override
  public void receiveBowAttack(IEquipableItem other) {
    receiveNeutralAttack(other);
  }

  @Override
  public void receiveSpearAttack(IEquipableItem other) {
    receiveNeutralAttack(other);
  }

  @Override
  public void receiveSwordAttack(IEquipableItem other) {
    receiveNeutralAttack(other);
  }

  @Override
  public void receiveMBAAttack(IEquipableItem other) {
    receiveNeutralAttack(other);
  }

  @Override
  public void receiveMBLAttack(IEquipableItem other) {
    receiveNeutralAttack(other);
  }

  @Override
  public void receiveMBOAttack(IEquipableItem other) {
    receiveNeutralAttack(other);
  }

  //endregion

  //region Section counterattack by debility
  protected void receiveNeutralCounterAttack(IEquipableItem item){
    double power = item.getPower();
    double HPBeforeA = this.getOwner().getCurrentHitPoints();
    double HPAfterA = HPBeforeA - power;
    if(HPAfterA <= 0){
      HPAfterA= 0;
      this.getOwner().setCurrentHitPoints(HPAfterA);
    }
    else{
      this.getOwner().setCurrentHitPoints(HPAfterA);
    }
  }

  protected void receiveStrongCounterAttack(IEquipableItem item){
    double power = item.getPower();
    double HPBeforeA = this.getOwner().getCurrentHitPoints();
    double HPAfterA = HPBeforeA - (power * 1.5);
    if(HPAfterA <= 0){
      HPAfterA= 0;
      this.getOwner().setCurrentHitPoints(HPAfterA);
    }
    else{
      this.getOwner().setCurrentHitPoints(HPAfterA);
    }
  }

  protected void receiveWeakCounterAttack(IEquipableItem item){
    double power = item.getPower();
    double HPBeforeA = this.getOwner().getCurrentHitPoints();
    double HPAfterA = HPBeforeA - (power - 20);
    if(HPAfterA <= 0){
      HPAfterA= 0;
      this.getOwner().setCurrentHitPoints(HPAfterA);
    }
    else{
      this.getOwner().setCurrentHitPoints(HPAfterA);
    }
  }
  //endregion

  //region Section receive counterattacks by item

  @Override
  public void receiveBowCounterAttack(IEquipableItem other) {
    receiveNeutralCounterAttack(other);
  }

  @Override
  public void receiveSpearCounterAttack(IEquipableItem other) {
    receiveNeutralCounterAttack(other);
  }

  @Override
  public void receiveAxeCounterAttack(IEquipableItem other) {
    receiveNeutralCounterAttack(other);
  }

  @Override
  public void receiveSwordCounterAttack(IEquipableItem other) {
    receiveNeutralCounterAttack(other);
  }

  @Override
  public void receiveMBACounterAttack(IEquipableItem other) {
    receiveNeutralCounterAttack(other);
  }

  @Override
  public void receiveMBLCounterAttack(IEquipableItem other) {
    receiveNeutralCounterAttack(other);
  }

  @Override
  public void receiveMBOCounterAttack(IEquipableItem other) {
    receiveNeutralCounterAttack(other);
  }

  @Override
  public void receiveStaffCounterAttack(IEquipableItem item){};

  //endregion

}