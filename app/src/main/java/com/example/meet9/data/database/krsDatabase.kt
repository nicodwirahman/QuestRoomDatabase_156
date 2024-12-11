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
abstract class krsDatabase : RoomDatabase(){

    //Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao


    companion object{
        @Volatile //Memastikan bahwa nilai variabel Instance selalu sama di
        private var Instance: krsDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): krsDatabase{
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    krsDatabase::class.java,
                    "krsdatabase"
             )
                    .build().also { Instance = it }

                })
        }
    }
}