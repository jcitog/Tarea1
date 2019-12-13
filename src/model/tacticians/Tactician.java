package model.tacticians;

import model.factories.IFactory;
import model.units.IUnit;
import model.map.Field;
import java.util.List;

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
  private List<IUnit> iUnits;
  private boolean isAlive = true;
  private boolean onTurn;

  /**
   * Creates a new Tactician.
   * <p>
   *
   * @param name
   *  the name of the tactician
   * @param iUnits
   *  the units that the tactician owns
   * @param isAlive
   *  boolean that indicates if the tactician is alive
   * @param onTurn
   *  boolean that indicates if is the turn of the tactician
   * @param selectedUnit
   *  the unit that the tactician has selected
   */
  public Tactician(String name, List<IUnit> iUnits, boolean isAlive, boolean onTurn, IUnit selectedUnit){
    this.name = name;
    this.iUnits = iUnits;
    this.isAlive = isAlive;
    this.onTurn = onTurn;
    this.selectedUnit = selectedUnit;
  }



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
    return selectedUnit;
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
   *
   */
  public void addUnit (int hitPoints, int movement, int x, int y){
    IUnit iUnit = IFactory.create(hitPoints,movement,this.getMap(),x,y);
    this.iUnits.add(iUnit);
  }

  public void setMap(Object map) {
    this.map = map;
  }
}
