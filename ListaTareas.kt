class ListaTareas() {
    var tareas: MutableList<Tarea> = mutableListOf()

    fun agregarTarea(tarea:Tarea){
        tareas.add(tarea)
        println("¡Tarea agregada con éxito!")
    }

    fun eliminarTarea(identificador:Int):Boolean{
        var eliminada = false
        var contador = -1
        for(tarea in tareas){
            contador++
            if(tarea.identificador == identificador){
                tareas.removeAt(contador)
                eliminada = true
            }
        }
        return eliminada
    }

    private fun mostrarEstados(estado:String){
        for(tarea in tareas){
            if(tarea.estado == estado){
                println(tarea)
            }
        }
    }

    fun cambiarEstado(identificador: Int):Boolean{
        var estadoCambiado = false
        for(tarea in tareas){
            if(tarea.identificador == identificador){
                estadoCambiado = true
                if(tarea.estado == "Pendiente"){
                    tarea.estado = "Realizada"
                }
                else{
                    tarea.estado = "Pendiente"
                }
            }
        }
        return estadoCambiado
    }

    fun mostrarTareas(){
        for(tarea in tareas){
            println(tarea)
        }
    }
    fun mostrarPendientes(){
        mostrarEstados("Pendiente")
    }

    fun mostrarRealizadas(){
        mostrarEstados("Realizada")
    }

}