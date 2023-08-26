package org.cabradati.reinos

import com.google.firebase.FirebaseApp
import org.bukkit.plugin.java.JavaPlugin

class App : JavaPlugin() {

    override fun onEnable() {
        FirebaseApp.initializeApp();
        
        super.onEnable()
    }

}