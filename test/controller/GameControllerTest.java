package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import model.factories.factoryFighter;
import model.items.Axe;
import model.items.Bow;
import model.items.IEquipableItem;
import model.items.Sword;
import model.map.Location;
import model.tacticians.Tactician;
import model.map.Field;
import model.units.Alpaca;
import model.units.Fighter;
import model.units.Fighter;
import model.units.SwordMaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 * @since v2.0
 */
class GameControllerTest {

  private GameController controller;
  private long randomSeed;
  private List<String> testTacticians;

  @BeforeEach
  void setUp() {
    // Se define la semilla como un número aleatorio para generar variedad en los tests
    randomSeed = new Random().nextLong();
    controller = new GameController(4, 128);
    testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
  }

  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {
      assertEquals("Player " + i, tacticians.get(i).getName());
    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(128, gameMap.getSize());
    assertTrue(controller.getGameMap().isConnected());
    Random testRandom = new Random(randomSeed);
    testRandom.setSeed(randomSeed);
    // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
    //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
    //    las dimensiones definidas y que sea conexo.
    //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
    //    secuencia de números generada sea siempre la misma, así pueden predecir los
    //    resultados que van a obtener.
    //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
    //    usar el método setSeed de Random.
    //
  }

  @Test
  void getTurnOwner() {
    Random testRandom = new Random(randomSeed);
    int j= testRandom.nextInt();
    Tactician tactician = controller.getTacticians().get(testRandom.nextInt(controller.getTacticians().size()));
    controller.initGame(j);
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(controller.getTacticians().size(),4);
    for(int i = 0;i<controller.getTacticians().size();i++){
      assertTrue(testTacticians.contains(tacticians.get(i).getName()));
    }
    controller.endTurn();
    controller.endTurn();
    assertEquals(controller.getTurnOwner(),controller.getTacticians().get(2));
  }

  @Test
  void getRoundNumber() {
    controller.initGame(10);
    for (int i = 1; i < 10; i++) {
      assertEquals(i, controller.getRoundNumber());
      for (int j = 0; j < 4; j++) {
        controller.endTurn();
      }
    }
  }

  @Test
  void getMaxRounds() {
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    controller.initEndlessGame();
    controller.endTurn();

    assertEquals(controller.getTacticianPlaying().getName(), "Player 1");
  }

  @Test
  void removeTactician() {
    assertEquals(4, controller.getTacticians().size());
    controller.removeTactician("Player 0");
    assertEquals(3, controller.getTacticians().size());
  }

  @Test
  void getWinners() {
    controller.initGame(2);
    assertEquals(4, controller.getWinners().size());
    controller.removeTactician("Player 0");
    controller.removeTactician("Player 3");

    List<String> winners = controller.getWinners();

    assertTrue(List.of("Player 1", "Player 2").containsAll(winners));
  }

  // Desde aquí en adelante, los tests deben definirlos completamente ustedes
  @Test
  void getSelectedUnit() {
  }//Aquí tengo un error que no logro encontrar uwu

  @Test
  void selectUnitIn() {
    controller.initGame(10);
    controller.getTacticians().get(0).addUnit(14,1,1,2);
    controller.selectUnitIn(1,2);
    //assertEquals(controller.getTacticiansList().get(0).getSelectedUnit().getCurrentHitPoints(),14);
    //controller.getTacticiansList().get(0).getSelectedUnit().getCurrentHitPoints();
  }

  @Test
  void selectTactician(){
    assertEquals(controller.selectTactician("Player 1"), controller.getTacticians().get(1));
    assertEquals(controller.selectTactician("Player 3"), controller.getTacticians().get(3));
  }
  @Test
  void getItems() {
    controller = new GameController(1,40);
    controller.setTacticianPlaying(controller.getTacticians().get(0));
    Fighter fighter = new Fighter(140,4,controller.getGameMap().getCell(1,1));
    Axe axe = new Axe("hacha para leña",14,1,1);
    fighter.setItems(axe);
    controller.selectUnitIn(1,1);
    controller.getTacticianPlaying().getUnitList().add(fighter);
    controller.getTacticianPlaying().setSelectedUnit(fighter);
    assertEquals(controller.getSelectedUnit(),fighter);
    controller.getGameMap().getCell(1,1).setUnit(fighter);
    controller.selectUnitIn(1,1);
    ArrayList<IEquipableItem> list = new ArrayList<>();
    list.add(axe);
    assertEquals(controller.getItems(),list);
  }

  @Test
  void equipItem() {
    controller = new GameController(2,40);
    controller.setTacticianPlaying(controller.getTacticians().get(0));
    Axe axe = new Axe("Hacha para leña",5,1,1);
    Fighter fighter = new Fighter(100,1,controller.getGameMap().getCell(1,7),axe);
    controller.selectUnitIn(1,7);
    controller.getTacticianPlaying().getUnitList().add(fighter);
    controller.getGameMap().getCell(1,7).setUnit(fighter);
    controller.selectUnitIn(1,7);
    ArrayList<IEquipableItem> list = new ArrayList<>();
    controller.equipItem(0);
    assertEquals(controller.getSelectedUnit().getEquippedItem(),axe);
  }

  @Test
  void useItemOn() {
    controller.setTacticianPlaying(controller.getTacticians().get(0));
    Axe axe1 = new Axe("Hacha dura",1,3,50);
    Fighter fighter1 = new Fighter(170,6,controller.getGameMap().getCell(1,2),axe1);
    fighter1.equipItem(axe1);
    controller.selectUnitIn(1,2);
    controller.getGameMap().getCell(1,2).setUnit(fighter1);
    controller.getTacticianPlaying().getUnitList().add(fighter1);
    controller.selectUnitIn(1,2);
    Axe axe = new Axe("",1,1,1);
    Fighter fighter = new Fighter(100,1,controller.getGameMap().getCell(3,7),axe);
    fighter.equipItem(axe);
    controller.getGameMap().getCell(3,7).setUnit(fighter);
  }

  @Test
  void selectItem() {
    controller.setTacticianPlaying(controller.getTacticians().get(0));
    Sword espada = new Sword("exkalibur",35,1,1);
    SwordMaster espadachin = new SwordMaster(180,1,controller.getGameMap().getCell(1,2),espada);
    controller.selectUnitIn(1,2);
    controller.getTacticianPlaying().getUnitList().add(espadachin);
    controller.getGameMap().getCell(1,2).setUnit(espadachin);
    controller.selectUnitIn(1,2);
    ArrayList<IEquipableItem> list = new ArrayList<>();
    controller.selectItem(0);
    assertEquals(controller.getSelectedItem(),espada);

  }

  @Test
  void giveItemTo() {
    controller.setTacticianPlaying(controller.getTacticians().get(0));
    Axe axe1 = new Axe("Hacha dura",1,3,50);
    Fighter fighter1 = new Fighter(170,6,controller.getGameMap().getCell(1,2),axe1);
    fighter1.equipItem(axe1);
    controller.selectUnitIn(1,2);
    controller.getGameMap().getCell(1,2).setUnit(fighter1);
    controller.getTacticianPlaying().getUnitList().add(fighter1);
    controller.selectUnitIn(1,2);
    Axe axe = new Axe("Hacha de chicle",1,1,1);
    Fighter fighter = new Fighter(100,1,controller.getGameMap().getCell(1,3),axe);
    controller.giveItemTo(1,3);
    controller.getGameMap().getCell(1,3).setUnit(fighter);
  }
}