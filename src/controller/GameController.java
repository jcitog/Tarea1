package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import model.tacticians.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController implements Observer {
    private int numberOfPlayers;
    private int mapSize;
    private Field field;
    private ArrayList<Tactician> tacticiansList = new ArrayList<>();
    private Tactician selectedTactician;
    private int round=0;
    private int maxRound;
    private Tactician tacticianPlaying;
    private IEquipableItem selectedItem;
}

    /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers
   *     the number of players for this game
   * @param mapSize
   *     the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {
      for(int i=0; i<=numberOfPlayers; i++) {
          Tactician tactician = new Tactician();
          String name = "Player" + i;
          tactician.setName(name);
          tacticiansList.add(tactician);
      }
  }

  /**
   * @return the list of all the tacticians participating in the game.
   */
  public List<Tactician> getTacticiansList() {
    return List.copyOf(tacticiansList);
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return this.field;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
      return this.tacticianPlaying;
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return this.round;
  }

  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return this.maxRound;
  }

  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {
      for (int i = 0; i < tacticiansList.size(); i++) {
          if (this.tacticianPlaying.equals(tacticiansList.get(i))) {
              tacticianPlaying = tacticiansList.get(i+1);
              break;
          }
          if (i== tacticiansList.size()) {
              tacticianPlaying = tacticiansList.get(0);
          }
          else {}
      }
  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician
   *     the player to be removed
   */
  public void removeTactician(String tactician) {
      this.tacticiansList.remove(tactician);
  }

  /**
   * Starts the game.
   * @param maxTurns
   *  the maximum number of turns the game can last
   */
  public void initGame(final int maxTurns) {
      this.maxRound = maxTurns;
  }

  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {
      this.maxRound = -1;
  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
      List<String> winners = new ArrayList<>();
      for(int i = 0; i<this.tacticiansList.size() ; i++){
          String n = this.tacticiansList.get(i).getName();
          winners.add(n);
      }
      return winners;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
      return this.tacticianPlaying.getSelectedUnit();
  }

  /**
   * Selects a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {
      this.tacticianPlaying.selectedUnit = this.field.getCell(x,y).getUnit(); //revisarrr
  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return this.tacticianPlaying.getSelectedUnit().getItems();
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {
      this.getItems().get(index).equipTo(this.getSelectedUnit());
  }

  /**
   * Uses the equipped item on a target
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void useItemOn(int x, int y) {
      this.tacticianPlaying.getSelectedUnit().getEquippedItem().attack(field.getCell(x,y).getUnit().getEquippedItem());
      this.tacticianPlaying.getSelectedUnit().getEquippedItem().heal(field.getCell(x,y).getUnit().getEquippedItem());
      }
  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {
    this.selectedItem = this.tacticianPlaying.getSelectedUnit().getItems().get(index);
  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void giveItemTo(int x, int y) {
      this.getSelectedUnit().swap(this.selectedItem,this.field.getCell(x,y).getUnit());

  }
}
