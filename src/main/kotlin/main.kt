import model.*
import repository.Crud
import view.GestoreIO

fun main(args: Array<String>) {
    var g = GestoreIO()
    var c = Crud()
    do {
        g.menu()
        var scelta: Int = g.leggiIntero("Scegli un'opzione:")
        //il when sostituisce lo switch-case; invece dei case usiamo l'operatore freccia (non si usa il break)
        when (scelta) {
            1 -> {
                g.menuDip()
                scelta = g.leggiIntero("Scegli un'opzione:")
                when (scelta) {
                    1 -> {
                        var d = Dipendente("", "")
                        g.mascheraInserimento(d)
                        c.insertDip(d)
                    }
                    2 -> {
                        var m = Manager("", "")
                        g.mascheraInserimento(m)
                        c.insertDip(m)
                    }
                }
            }
            2->{
                g.mascheraModifica(c.cercaDip(g.leggiIntero("Inserisci l'id della persona da modificare:")))
            }
            3 -> c.deleteDip(c.cercaDip(g.leggiIntero("Inserisci l'id della persona da rimuovere:")))
            4 -> g.visualizzaDip(c.getDip())
        }
    } while (g.leggiStringa("Rimanere nell'app? s/tasto qualsiasi").equals("s"))

}