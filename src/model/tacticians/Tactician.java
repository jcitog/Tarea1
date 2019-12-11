package model.tacticians;

import model.units.IUnit;

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
   * Tacticians are
   * one.
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

  public void setName(String nickname){
    this.name = nickname;
  }

  public String getName() { return name;}

  public IUnit getSelectedUnit() {
    return selectedUnit;
  }
}
