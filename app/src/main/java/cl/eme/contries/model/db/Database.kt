package cl.eme.contries.model.db

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import cl.eme.contries.model.pojos.Country
import timber.log.Timber

// Pojos (entities)
@Entity(tableName = "country")
data class CountryEntity(val name: String, @PrimaryKey val alpha2Code: String, val capital: String, val region: String)

@Entity(tableName = "country_detail")
data class CountryDetail(val name: String, @PrimaryKey val alpha2Code: String, val capital: String?, val region: String, val subregion:String, val population: Int, val flag: String, val gini: Double)


// Interfaz de operaciones
@Dao
interface CountryDao {

    @Insert
    suspend fun insert(counties: List<CountryEntity>)

    @Query("SELECT * FROM country")
    fun getCountries(): LiveData<List<CountryEntity>>

    @Insert
    suspend fun insert(country: CountryDetail)

    @Query("SELECT * FROM country_detail WHERE alpha2Code=:code")
    fun getCountry(code: String): LiveData<CountryDetail>

}

// Cliente de base de datos
@Database(entities = [CountryEntity::class, CountryDetail::class], version = 1)
abstract class CountryDatabase: RoomDatabase() {
    abstract fun countryDao(): CountryDao
}

// Inicialización de la base de datos
class CountryApplication : Application() {
    companion object {
        var countryDatabase : CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("onCreate de application")
        countryDatabase = Room.databaseBuilder(this, CountryDatabase::class.java, "countries_database").build()
    }
}

