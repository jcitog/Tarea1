#Alpaca Emblem - Tarea 456
kk

En esta nueva versión:
- Se implementó la clase Tactician en model.tactician.Tactician
- Se hicieron los métodos pedidos en el controlador
- Se hicieron métodos adicionales para el controlador
- Para añadir unidades se implementó el patrón de diseño Factory, esto se puede ver en model.factories
- Se usó el patrón de diseño Observer entre GameController, Tactician y Field
- Además arreglé las funciones swap y setOpponent (esta última aún no se logra a cabalidad)

Cómo iniciar el juego (planeo hacer una interfaz en un futuro para realizar estas acciones):

- Lo primero es utilizar gameController, entregandole el tamaño del mapa y la cantidad de jugadores
. Luego se inicia el juego con initGame (o initEndlessGame si se quiere jugar con turnos ilimitados)

Cómo jugar:

-El tactician (o jugador) posee distintas acciones, las que puede realizar en su turno, como por ejemplo,
seleccionar unidades, mover unidades, atacar/curar con ellas (para estos dos últimos solo 1 por turno), 
terminar el turno, rendirse, etc.


