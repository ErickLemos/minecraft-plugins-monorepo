package org.cabradati.reinos

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.bukkit.plugin.java.JavaPlugin
import org.cabradati.reinos.commands.AdicionarReinoCommand
import org.cabradati.reinos.commands.RemoverReinoCommand


class App : JavaPlugin() {

    override fun onEnable() {

        FirebaseApp.initializeApp(
            FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build()
        )

        getCommand("adicionar-reino")?.setExecutor(AdicionarReinoCommand())
        getCommand("remover-reino")?.setExecutor(RemoverReinoCommand())
        super.onEnable()

    }

}