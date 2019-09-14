-La batalla se basa en setear un oponente con setOpponent()
-Luego el método attack llama a métodos receive(Item)Attack (Item=Axe por ejemplo)
-ese método dependiendo de la debilidad, fortaleza o neutralidad llama a receiveNeutralAttack, receiveStrongAttack y receiveWeakAttack.
-en esos métodos está cómo se resta la vida según las condiciones.
- luego de esta llamada setoppenent realiza las mismas llamadas para un contraataque en caso de que la vida del atacado sea mayor que cero.
- adicionalmente en Staff está programada la función heal, que le permite curra al clérigo cuando tiene equipado un bastón

-swap intercambia objetos

- se implementó el sorcerer junto a sus magic book, los que conservan su nombre en español.