-La batalla se basa en setear un oponente con setOpponent()
-Luego el m�todo attack llama a m�todos receive(Item)Attack (Item=Axe por ejemplo)
-ese m�todo dependiendo de la debilidad, fortaleza o neutralidad llama a receiveNeutralAttack, receiveStrongAttack y receiveWeakAttack.
-en esos m�todos est� c�mo se resta la vida seg�n las condiciones.
- luego de esta llamada setoppenent realiza las mismas llamadas para un contraataque en caso de que la vida del atacado sea mayor que cero.

-swap intercambia objetos

- se implement� el sorcerer junto a sus magic book, los que conservan su nombre en espa�ol.