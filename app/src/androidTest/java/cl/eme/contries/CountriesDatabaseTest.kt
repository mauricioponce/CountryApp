package cl.eme.contries

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import cl.eme.contries.model.db.CountryDao
import cl.eme.contries.model.db.CountryDatabase
import cl.eme.contries.model.db.CountryEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CountriesDatabaseTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var countryDao: CountryDao
    private lateinit var database : CountryDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, CountryDatabase::class.java).build()
        countryDao = database.countryDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertCountries_empty() = runBlocking {
        // Given
        val countryList = listOf<CountryEntity>()

        // When
        countryDao.insert(countryList)

        // Then
        countryDao.getCountries().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEmpty()
        }
    }

    @Test
    fun insertCountries_1country() = runBlocking {
        // Given
        val countryList = listOf(CountryEntity("name", "code", "capital", "region"))

        // When
        countryDao.insert(countryList)

        // Then
        countryDao.getCountries().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(1)
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat("cl.eme.contries").isEqualTo(appContext.packageName)
    }
}