#Alpaca Emblem

This consists in a 
-La batalla se basa en setear un oponente con setOpponent()
-Luego el metodo attack llama a metodos receive(Item)Attack (Item=Axe por ejemplo)
-ese m�todo dependiendo de la debilidad, fortaleza o neutralidad llama a receiveNeutralAttack, receiveStrongAttack y receiveWeakAttack.
-en esos metodos est� c�mo se resta la vida seg�n las condiciones.
- luego de esta llamada setoppenent realiza las mismas llamadas para un contraataque en caso de que la vida del atacado sea mayor que cero.
- adicionalmente en Staff est� programada la funci�n heal, que le permite curra al cl�rigo cuando tiene equipado un bast�n

-swap intercambia objetos

- se implement� el sorcerer junto a sus magic book, los que conservan su nombre en espanol.