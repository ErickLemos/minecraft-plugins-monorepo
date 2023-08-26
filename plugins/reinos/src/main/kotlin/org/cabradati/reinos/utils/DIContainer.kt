package org.cabradati.reinos.utils

import org.bukkit.Server
import org.bukkit.configuration.file.FileConfiguration
import java.util.logging.Logger

class DIContainer {

    val server: Server
        get() = getPluginContainerDI().server

    val config: FileConfiguration
        get() = getPluginContainerDI().config

    val logger: Logger
        get() = getPluginContainerDI().logger

}
