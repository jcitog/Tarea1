package model.factories;
import model.map.Field;

import model.units.IUnit;

public interface IFactory {

    /**
     * Create a unit.
     *
     * @param hitPoints
     *      the amount of damage this unit can receive
     * @param movement
     *      number of cells the unit can move
     * @param map
     *      the map of the game
     * @param x
     *      x is the abscissa of the unit position
     * @param y
     *      y is the ordinate of the unit position
     */
    IUnit create(int hitPoints, int movement, Field map, int x, int y);
}