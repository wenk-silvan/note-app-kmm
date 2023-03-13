package ch.wenksi.noteappkmm.android.di

import android.app.Application
import ch.wenksi.noteappkmm.data.local.DatabaseDriverFactory
import ch.wenksi.noteappkmm.data.note.SqlDelightNoteDataSource
import ch.wenksi.noteappkmm.database.NoteDatabase
import ch.wenksi.noteappkmm.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver =
        DatabaseDriverFactory(app).createDriver()

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource =
        SqlDelightNoteDataSource(NoteDatabase(driver))
}