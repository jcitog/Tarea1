package model.factories;

import model.map.Field;
import model.units.Fighter;
import model.units.IUnit;

public class factoryFighter implements IFactory {
    @Override
    public IUnit create(int hitPoints, int movement, Field map, int x, int y){
        return new Fighter(hitPoints,movement,map.getCell(x,y));
    }
}