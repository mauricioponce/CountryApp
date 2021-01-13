package cl.eme.contries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.eme.contries.view.ListingFragment
import timber.log.Timber

/*
[X] Modelo (data class)
[X] Consumo API (retrofit)
[X] Repositorio
[X] ViewModel
[X] ViewBinding
[X] Fragmento de listado (listing)
[X] RecyclerView + Adapter + ViewHolder
[ ] Testing unitario para mappers
[ ] Fragmento de detalle (detail)
[ ] Persistencia de datos locales (ROOM)
[ ] Testing para la base de datos
[ ] Intent implícito para compartir
[ ] Scroll

TODO el nombre del paquete principal está equivocado
*/
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()


        supportFragmentManager.beginTransaction().add(R.id.main_container, ListingFragment()).commit()
    }

    private fun initLog() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}