package model.factories;

import model.map.Field;
import model.units.Archer;
import model.units.IUnit;

public class factoryArcher implements IFactory {
    @Override
    public IUnit create(int hitPoints, int movement, Field map, int x, int y){
        return new Archer(hitPoints,movement,map.getCell(x,y));
    }
}