package model.factories;

import model.map.Field;
import model.units.Hero;
import model.units.IUnit;

public class factoryHero implements IFactory {
    @Override
    public IUnit create(int hitPoints, int movement, Field map, int x, int y){
        return new Hero(hitPoints,movement,map.getCell(x,y));
    }
}