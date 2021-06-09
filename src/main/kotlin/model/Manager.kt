package model

class Manager(nome: String, cognome: String) :Dipendente(nome,cognome) {

    private var areaResp:String=""

    public fun setAreaResp(areaResp:String){
        this.areaResp=areaResp
    }

    public fun getAreaResp():String{
        return areaResp
    }

    override fun toString():String{
        return super.toString()+" "+areaResp
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Manager) return false
        if (!super.equals(other)) return false

        if (areaResp != other.areaResp) return false

        return true
    }

    override fun hashCode(): Int {

        var result = super.hashCode()
        result = 31 * result + areaResp.hashCode()
        return result
    }

    constructor(nome: String, cognome: String, eta:Int, stipendio:Double, areaResp: String) : this(nome,cognome){
        super.setEta(eta)
        super.setStipendio(stipendio)
        this.areaResp=areaResp
    }


}