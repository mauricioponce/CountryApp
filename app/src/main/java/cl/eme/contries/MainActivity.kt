package cl.eme.contries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import timber.log.Timber

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
[ ] Intent implícito para compartir
[ ] Scroll
*/
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()

        viewModel.doSomething()
    }

    private fun initLog() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}