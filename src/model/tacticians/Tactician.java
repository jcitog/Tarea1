package model.tacticians;

import model.factories.IFactory;
import model.items.IEquipableItem;
import model.map.Location;
import model.units.IUnit;
import model.map.Field;
import controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

/**
 * This class represents a Tactician.
 *  * <p>
 *  * This are the players who play the game.
 * @author Ignacio Slater Muñoz
 * @since
 */
public class Tactician {

  public IUnit selectedUnit;
  private String name;
  private ArrayList<IUnit> iUnits = new ArrayList<>();
  private boolean isAlive;
  private IFactory factory;
  private Field field;
  private ArrayList<IUnit> usedUnits = new ArrayList<>();
  private ArrayList<IUnit> movedUnits = new ArrayList<>();
  private GameController gameController;

  /**
   * Creates a new Tactician.
   * <p>
   *
   * @param name
   *  the name of the tactician
   *
   * @param gameController
   *
   * @param field
   *
   *
   */
  public Tactician(String name, GameController gameController, Field field){
    this.isAlive = true;
    this.name = name;
    this.gameController = gameController;
    this.field = field;
  }


  //region Tactician Data
  /**
   * Sets the name of the Tactician.
   * <p>
   *
   * @param nickname
   *      the name that will be assigned to the Tactician
   *
   */
  public void setName(String nickname){
    this.name = nickname;
  }

  /**
   * Gets the name of the Tactician.
   * <p>
   *
   * @return the name of the Tactician
   */
  public String getName() { return name;}


  /**
   * Gets the unit that the Tactician has selected.
   * <p>
   *
   * @return the selected unit by the Tactician
   */
  public IUnit getSelectedUnit() {
    return this.selectedUnit;
  }

  /**
   * Selects the unit in the position (x,y).
   * <p>
   *
   * @param unit
   *
   */
  public void setSelectedUnit(IUnit unit) {
    if (iUnits.contains(unit)){
      this.selectedUnit = unit;
    }
  }

  /**
   * Gets the tactician´s unit list
   *
   * @return units
   *        list of units that the tacticians owns
   *
   */
  public List<IUnit> getUnitList(){
    return this.iUnits;
  }

  /**
   * Gets the map of the current game
   *
   * @return field
   */
  public Field getMap() { return this.field;
  }

  /**
   * Sets the map in which it will be played
   * @param map
   *        the map that will be setted
   */
  public void setMap(Field map) { this.field = map;
  }

  //endregion

  //region Unit Data
  /**
   * Gets the current hit points
   *
   * @param selectedUnit
   * @return currentHitPoints
   *        the current hit points of the unit
   */
  public double getUnitHP (IUnit selectedUnit){
    return selectedUnit.getCurrentHitPoints();
  }

  /**
   * Gets the max hit points
   *
   * @param selectedUnit
   * @return maxHitPoints
   *         the max hit points of the unit
   */
  public double getUnitMaxHP(IUnit selectedUnit){
    return selectedUnit.getHitPoints();
  }

  /**
   * Gets the movement of the selected unit.
   *
   * @return movement
   *         the cells that the unit can move
   */
  public int getMovement() {return selectedUnit.getMovement();}

  /**
   * Gets the list of the inventory
   *
   * @param selectedUnit
   *
   * @return inventory
   *         inventory of the unit
   */
  public List<IEquipableItem> getUnitInventory(IUnit selectedUnit) {
    return selectedUnit.getItems();
  }

  //endregion

  //region Tactician Actions
  /**
   * The tactician uses the selected unit´s item in the position (x,y).
   *
   * @param x
   *        horizontal position of the unit
   * @param y
   *        vertical position of the unit
   */
  public void unitActionOn (int x, int y){
   if (!usedUnits.contains(selectedUnit)) {
      this.gameController.useItemOn(x,y);
      usedUnits.add(this.selectedUnit);
    }
  }

  /**
   * The tactician move the selected unit to the position (x,y).
   *
   * @param x
   *        horizontal position of the unit
   * @param y
   *        vertical position of the unit
   */
  public void unitMoveTo(int x, int y){
    if (!movedUnits.contains(selectedUnit)) {
      Location targetLocation = new Location(x,y);
      selectedUnit.moveTo(targetLocation); //con este método ya compruebo si la casilla está vacía y si le bastan sus puntos de movimiento
      movedUnits.add(this.selectedUnit); }
  }

  /**
   * The tactician finishes her/his turn.
   */
  public void endTurn(){
    usedUnits.clear();
    movedUnits.clear();
    this.getGameController().endTurn();
  }

  /**
   * The tactician withdraws from the game
   */
  public void surrender(){
    this.gameController.removeTactician(this.getName());
  }

  /**
   * Adds a unit to the Tactician´s army
   * <p>
   *
   *  @param hitPoints
   *      the amount of damage this unit can receive
   *  @param movement
   *      number of cells the unit can move
   *  @param x
   *      x is the abscissa of the unit position
   *  @param y
   *      y is the ordinate of the unit position
   *      */
  public void addUnit (int hitPoints, int movement, int x, int y){
    IUnit iUnit = this.getFactory().create(hitPoints,movement,this.getMap(),x,y);
    this.iUnits.add(iUnit);
    this.selectedUnit = iUnit;
  }

  /**
   * Changes the unit factory
   *
   * @param factory
   *        the factory of the unit that will be used to create
   */
  public void changeFactory(IFactory factory){this.factory = factory;}

  /**
   * Gets the current factory
   * @return factory
   *         the current factory
   */
  public IFactory getFactory(){return this.factory;}

  //endregion

  /**
   * Listener
   *
   * @param event
   *        the event that has changed
   */
  public void propertyChange(PropertyChangeEvent event){ event.getNewValue(); }

  /**
   * Sets the game controller.
   *
   * @param controller
   *         the controller to be setted
   */
  public void setGameController (GameController controller){
    this.gameController= controller;
  }

  /**
   * Gets the game controller.
   *
   * @return controller
   *         the gameController of the game that are playing the tactician
   */
  public GameController getGameController (){
    return this.gameController;
  }

}
