package repository

import model.Dipendente

interface ICrud {

    public fun insertDip(d:Dipendente)
    public fun cercaDip(idRic:Int):Dipendente
    public fun deleteDip(d:Dipendente)
    public fun getDip():MutableList<Dipendente>


}