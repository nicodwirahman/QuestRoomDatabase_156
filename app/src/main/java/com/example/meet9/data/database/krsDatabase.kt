package com.example.meet9.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.meet9.data.dao.MahasiswaDao
import com.example.meet9.data.entity.Mahasiswa
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

//Mendefinisikan database dengan tabel Mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {

    //Mendefinisikan fungsi untuk mengakses data mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile // Memastikan bahwa nilai variabel Istance selalu sama di
        private var Instance: KrsDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): KrsDatabase{
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java, //Class Database
                    "KrsDatabase"//Nama Database
                )
                    .build().also { Instance = it }
            })
        }
    }
}