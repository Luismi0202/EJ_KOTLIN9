import kotlin.concurrent.thread

fun mostrarMenu(){
    println("""
        LISTA DE TAREAS POO
        -------------------
        1.- Agregar tarea
        2.- Eliminar tarea
        3.- Cambiar estado de una tarea
        4.- Mostrar todas las tareas
        5.- Mostrar tareas pendientes
        6.- Mostrar tareas realizadas
        0.- Salir
        ---------------------------------
    """.trimIndent())
}

fun pedirOpcion():Int{
    var numValido = false
    var opcion = -1
    do{
        try{
            println(">> ")
            opcion = readln().toInt()
            if(opcion > 6 || opcion < 0){
                throw Exception("El número está fuera del rango 0-6")
            }
            else{
                numValido = true
            }
        }catch(e:Exception){
            println("¡Error! ${e.message}, vuelve a introducir.")
        }
    }while(!numValido)
    return opcion
}

fun pedirMensaje(msj:String):String{
    println("Dame $msj de su tarea")
    println(">> ")
    return readln().toString()
}

fun pedirIdentificador():Int{
    var numValido = true
    var numero = 0
    do{
        try {
            numValido = true
            println("Ingresa un número de identificación para su tarea")
            println(">> ")
            numero = readln().toInt()
        }catch(e: IllegalArgumentException){
            println("¡Error! Numero inválido. Vuelva a introducir")
            numValido = false
        }
    }while(!numValido)
    return numero
}

fun limpiarPantalla(){
    repeat(20){ println() }
}

fun main(){
    var opcion = -1
    var lista = ListaTareas()
    
    do{
        limpiarPantalla()
        mostrarMenu()
        opcion = pedirOpcion()
        when(opcion){
            1-> {
                limpiarPantalla()
                lista.agregarTarea(Tarea(pedirMensaje("la descripcion"),pedirIdentificador()))
                Thread.sleep(2000)
            }
            2-> {
                limpiarPantalla()
                println(if (lista.eliminarTarea(pedirIdentificador())) "¡Tarea eliminada!" else "Tarea no encontrada")
                Thread.sleep(2000)
            }
            3-> {
                limpiarPantalla()
                lista.cambiarEstado(pedirIdentificador())
                Thread.sleep(2000)
            }
            4-> {
                limpiarPantalla()
                lista.mostrarTareas()
                Thread.sleep(2000)
            }
            5-> {
                limpiarPantalla()
                lista.mostrarPendientes()
                Thread.sleep(2000)
            }
            6->{
                limpiarPantalla()
                lista.mostrarRealizadas()
                Thread.sleep(2000)
            }
        }
    }while(opcion != 0)
}