package com.example.meet9.dependecieinjection

import android.content.Context
import com.example.meet9.data.database.KrsDatabase

import com.example.meet9.repository.LocalRepositoryMhs
import com.example.meet9.repository.RepositoryMhs

// Interface untuk menyediakan dependensi Repository Mahasiswa
interface InterfaceContainerApp {
    //Semua repository masukan ke inteface ini
    val RepositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val RepositoryMhs: RepositoryMhs by lazy {
        //repository berhubungan dengan room database dan berhubungan dengan Dao, bekerja dalam satu container
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}