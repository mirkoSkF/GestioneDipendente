package repository

import model.Dipendente

class Crud : ICrud {

    //La lista mutabile è l'equivalente degli ArrayList<>
    var db = mutableListOf<Dipendente>()

    override fun insertDip(d: Dipendente) {
        var idLast:Int=0
        for(dip in db){
            idLast=dip.getId()+1
        }
        if(idLast==0)
            idLast=1
        d.setId(idLast)
        db.add(d)
    }

    override fun cercaDip(idRic:Int): Dipendente {
        var d = Dipendente("","")
        for (dip in db){
            if(dip.getId()==idRic){
                d=dip
            }
        }
        return d
    }

    override fun deleteDip(d: Dipendente) {
        db.remove(d)
    }

    override fun getDip(): MutableList<Dipendente> {
        return db
    }


}