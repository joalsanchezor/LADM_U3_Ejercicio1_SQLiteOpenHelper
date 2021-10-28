package mx.tecnm.tepic.ladm_u3_ejercicio1_sqliteopenhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val artista = Artista(this)

            artista.nombre = campoNombre.text.toString()
            artista.domicilio = campoDomicilio.text.toString()

            val resultado = artista.insertar()
            if(resultado){
                Toast.makeText(this, "SE CAPTURO DATO", Toast.LENGTH_LONG).show()
                campoDomicilio.setText("")
                campoNombre.setText("")
                listaCaptura()
            }else{
                Toast.makeText(this, "ERROR! NO SE CAPTURÓ", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun listaCaptura(){
        val resultado = Artista(this).consulta()
        //resultado = ARRAYLIST<String> contiene nombre, domicilio
        listaCapturados.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado)
    }
}