package com.ibrahimharoon.gitautocommit.cli

import java.io.File
import java.util.Properties

object CliConfig {
    private val CONFIG_FILE_NAME = System.getProperty("user.home") + "/.local/bin/autocommit-config.env"
    private val configFile = File(CONFIG_FILE_NAME)
    private val properties = Properties()

    init {
        if (!configFile.exists()) {
            configFile.parentFile.mkdirs()
            configFile.createNewFile()
        }
        properties.load(configFile.inputStream())
    }

    fun createConfigIfNotExists() { return }

    fun setDefaultLlmService(llm: String) {
        properties.setProperty("DEFAULT_LLM", llm)
        properties.store(configFile.outputStream(), null)
    }

    fun setOpenaiApiKey(apiKey: String) {
        properties.setProperty("OPENAI_API_KEY", apiKey)
        properties.store(configFile.outputStream(), null)
    }
}
