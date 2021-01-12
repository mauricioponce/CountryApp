package cl.eme.contries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[X] Modelo (data class)
[X] Consumo API (retrofit)
[ ] Repositorio
[ ] ViewModel
[ ] ViewBinding
[ ] Fragmento de listado (listing)
[ ] RecyclerView + Adapter + ViewHolder
[ ] Testing unitario para mappers
[ ] Fragmento de detalle (detail)
[ ] Persistencia de datos locales (ROOM)
[ ] Testing para la base de datos
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}