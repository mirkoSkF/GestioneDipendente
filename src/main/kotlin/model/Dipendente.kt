package model

//dichiaro contemporaneamente:
//1)classe
//2)costruttore primario
//3)con la keyword var dichiaro inoltre gli attributi: nome e cognome)
open class Dipendente (var nome:String, var cognome:String){ //open rende una classe estendibile
    //Prova da github
    private var id:Int = 0
    private var eta:Int = 0
    private var stipendio:Double = 0.0

    public fun setId(id:Int){
        this.id=id
    }

    public fun getId():Int{
        return id
    }

    public fun setEta(eta:Int){
        this.eta=eta
    }

    public fun getEta():Int{
        return eta
    }

    public fun setStipendio(stipendio:Double){
        this.stipendio=stipendio
    }

    public fun getStipendio():Double{
        return stipendio
    }

    override fun toString():String{
        return ""+id+" "+nome+" "+cognome+" "+eta+" "+stipendio
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Dipendente) return false

        if (nome != other.nome) return false
        if (cognome != other.cognome) return false
        if (eta != other.eta) return false
        if (stipendio != other.stipendio) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + cognome.hashCode()
        result = 31 * result + eta
        result = 31 * result + stipendio.hashCode()
        return result
    }

    //costruttore secondario
    constructor(nome: String, cognome: String, eta: Int, stipendio: Double) : this(nome, cognome){
        this.eta=eta
        this.stipendio=stipendio
    }


}
