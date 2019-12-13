package model.factories;

import model.map.Field;
import model.units.Alpaca;
import model.units.IUnit;


public class factoryAlpaca implements IFactory {
        @Override
        public IUnit create(int hitPoints, int movement, Field map, int x, int y){
                return new Alpaca(hitPoints,movement,map.getCell(x,y));
        }
}