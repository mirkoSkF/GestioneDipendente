package view

import model.*
import java.util.*

class GestoreIO {

    var input = Scanner(System.`in`)

    public fun menu() {
        println(
            "\n****MENU****" +
                    "\n1)Inserisci dipendente" +
                    "\n2)Modifica dipendente" +
                    "\n3)Elimina dipendente" +
                    "\n4)Visualizza dipendenti"
        )
    }

    public fun menuDip() {
        println(
            "\n****MENU****" +
                    "\n1)Registra dipendente" +
                    "\n2)Registra manager"
        )
    }

    public fun menuDipUp() {
        println(
            "\n****MENU****" +
                    "\n1)Modifica dipendente" +
                    "\n2)Modifica manager"
        )
    }

    public fun leggiIntero(suggerimento: String): Int {
        println(suggerimento)
        var flag: Boolean = false
        var intero: Int = 0
        do {
            try {
                flag=false
                intero = input.nextLine().trim().toInt()
            } catch (e: NumberFormatException) {
                println("Errore! Inserire un valore numerico:")
                flag=true
            }
        } while (flag)

        return intero
    }

    public fun leggiStringa(suggerimento: String): String {
        println(suggerimento)
        return input.nextLine().trim()
    }

    public fun leggiDecimale(suggerimento: String): Double {
        println(suggerimento)
        var flag: Boolean = false
        var decimale: Double = 0.0
        do {
            try {
                flag=false
                decimale = input.nextLine().trim().toDouble()
            } catch (e: NumberFormatException) {
                println("Errore! Inserire un valore numerico:")
                flag=true
            }
        } while (flag)

        return decimale
    }

    public fun mascheraInserimento(d: Dipendente) {
        d.nome = leggiStringa("Inserisci nome:")
        d.cognome = leggiStringa("Inserisci cognome:")
        d.setEta(leggiIntero("Inserisci età:"))
        d.setStipendio(leggiDecimale("Inserisci stipendio:"))
        if (d is Manager) {
            //non si usa il cast come in Java, basta la keyword "is" nella condizione dell'if
            d.setAreaResp(leggiStringa("Inserisci l'area di responsabilità"))
        }
    }

    public fun mascheraModifica(d:Dipendente){
        var nome:String=leggiStringa("Corrente:["+d.nome+"] Inserisci nome:")
        if (!nome.equals("")){
            d.nome=nome
        }
        var cognome:String=leggiStringa("Corrente:["+d.cognome+"] Inserisci cognome:")
        if (!cognome.equals("")){
            d.cognome=cognome
        }
        var confermaVal:String=leggiStringa("Corrente:["+d.getEta()+"] Premere invio per confermare l'età/n")
        if(!confermaVal.equals("")){
           d.setEta(leggiIntero("Inserisci età:"))
        }
        confermaVal=leggiStringa("Corrente:["+d.getStipendio()+"] Premere invio per confermare lo stipendio/n")
        if(!confermaVal.equals("")){
            d.setStipendio(leggiDecimale("Inserisci stipendio:"))
        }
        if (d is Manager){
            var areaResp:String=leggiStringa("Corrente:["+d.getAreaResp()+"] Inserisci area responsabilità:")
            if (!areaResp.equals("")){
                d.setAreaResp(areaResp)
            }
        }
    }

    //MutableList<Dipendente> è l'equivalente degli ArrayList<Dipendente>
    public fun visualizzaDip(db: MutableList<Dipendente>) {
        for (dip in db) {
            println(dip)
        }
    }

}