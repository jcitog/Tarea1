package model.factories;

import model.map.Field;
import model.units.Sorcerer;
import model.units.IUnit;

public class factorySorcerer implements IFactory {
    @Override
    public IUnit create(int hitPoints, int movement, Field map, int x, int y){
        return new Sorcerer(hitPoints,movement,map.getCell(x,y));
    }
}