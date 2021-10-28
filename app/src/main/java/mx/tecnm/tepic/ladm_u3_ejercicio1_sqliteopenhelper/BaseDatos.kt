package mx.tecnm.tepic.ladm_u3_ejercicio1_sqliteopenhelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(p: SQLiteDatabase) {
        //Se ejecuta cuando se instala la APP en el CEL y corre por 1ra vez
        //En Kotlin puedes hacer el CRUD de 2 maneras diferentes:
        //  1. tradicional con instrucciones SQL (insert into, update, delete from, select * from )
        //  2. La POO que maneja métodos que ejecutan instrucciones SQL

        p.execSQL("CREATE TABLE ARTISTA(ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE VARCHAR(200),DOMICILIO VARCHAR(200))")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        //Se ejecuta cuando hay un cambio de version (cuando hay cambio en la estructura de la bd)

    }

}