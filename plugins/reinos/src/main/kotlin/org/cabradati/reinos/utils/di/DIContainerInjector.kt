package org.cabradati.reinos.utils.di

import org.bukkit.plugin.java.JavaPlugin

private lateinit var javaPlugin: JavaPlugin

fun setPluginContainerDI(plugin: JavaPlugin) {
    javaPlugin = plugin
}

fun getPluginContainerDI() = javaPlugin