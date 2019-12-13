package model.factories;

import model.map.Field;
import model.units.IUnit;
import model.units.SwordMaster;

public class factorySwordMaster implements IFactory {
    @Override
    public IUnit create(int hitPoints, int movement, Field map, int x, int y){
        return new SwordMaster(hitPoints,movement,map.getCell(x,y));
    }
}