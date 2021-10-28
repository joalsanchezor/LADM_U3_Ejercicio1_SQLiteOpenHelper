package mx.tecnm.tepic.ladm_u3_ejercicio1_sqliteopenhelper

import android.content.ContentValues

class Artista(p:MainActivity) {
    var nombre = ""
    var domicilio = ""
    var pnt = p

    fun insertar() : Boolean{
        var tablaArtista = BaseDatos(pnt, "casaArte",null, 1).writableDatabase

        val dato = ContentValues()
        dato.put("nombre",nombre)
        dato.put("domicilio",domicilio)

        val resultado = tablaArtista.insert("ARTISTA",null,dato)
        //Insert regresa un ID mayor de 0 (si se puede), dicho ID es el Número de renglón insertado
        // y regresa un -1 LONG (entero largo) en caso de que no se pueda.
        tablaArtista.close()
        if(resultado == -1L){
            return false
        }
        return true
    }

    fun consulta() : ArrayList<String>{
        //Cursor es un objeto que obtiene el resultado de un SELECT (es una especie de tabla dinámica.)

        val tablaArtista = BaseDatos(pnt, "casaArte", null, 1).readableDatabase
        val resultadoConsulta = ArrayList<String>()

        //SELECT * FROM ARTISTA (NO TIENE WHERE)
        val cursor = tablaArtista.query("ARTISTA", arrayOf("*"), null,null,null,null,null)
        if(cursor.moveToFirst()){
            //si moveToFist es verdadero, significa que AL MENOS hay 1 resultado
            var dato = ""
            do{
                dato = cursor.getString(1)+"\n"+cursor.getString(2)
                resultadoConsulta.add(dato)
            }while(cursor.moveToNext())
        }else{
            //no hay resultados de la consulta, es decir cursor está VACÍO
            resultadoConsulta.add("NO HAY DATOS EN ARTISTA")
        }
        tablaArtista.close()
        return ArrayList<String>()
    }
    //ABSTRACCION = no se comunica con el usuario final (sino la clase interfaz(MainActivity))
    //en la fomra de programación llamada modelo    -  vista         - controlador
    //                                    BASEDATOS    MAINACTIVITY    ARTISTA
}