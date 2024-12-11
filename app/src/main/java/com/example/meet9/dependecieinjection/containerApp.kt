package com.example.meet9.dependecieinjection

import android.content.Context
import com.example.meet9.data.database.krsDatabase
import com.example.meet9.repository.LocalRepositoryMhs
import com.example.meet9.repository.RepositoryMhs

// Interface untuk menyediakan dependensi Repository Mahasiswa
interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}


class ContainerApp(private val context: Context) : InterfaceContainerApp {

    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(krsDatabase.getDatabase(context).mahasiswaDao())
    }
}
