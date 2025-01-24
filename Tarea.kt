import kotlin.random.Random
import kotlin.random.nextInt
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(
    val descripcion: String
) {
    var estado = "Pendiente"
    private val fechaHoraActual: LocalDateTime = LocalDateTime.now()
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    private val fechaFormateada: String = fechaHoraActual.format(formatter)

    var identificador:Int = Random.nextInt(10000,50000) + Random.nextInt(70,90)

    constructor(descripcion: String,identificador: Int,estado: String = "Pendiente"):this(descripcion){
        this.identificador = identificador
        this.estado = estado
    }

    constructor(descripcion: String, identificador: Int):this(descripcion){
        if(identificador != 0){
            this.identificador = identificador
        }
    }

    override fun toString(): String {
        return "Identificador: $identificador Descripción: $descripcion Estado: $estado ${if(estado =="Realizada")fechaFormateada else ""}"
    }
}