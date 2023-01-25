package com.ferrero.appl.moicxuhd

import android.util.Log
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json


object Noisuhds {

    private val fodk = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }
    val odksdsids = HttpClient{
        install(JsonFeature){
            serializer = KotlinxSerializer(fodk)
        }

        install(Logging){
            logger = object : Logger{
                override fun log(message: String) {
                    Log.d("Network message",message)
                }

            }
            level = LogLevel.BODY
        }

        install(HttpTimeout){
            socketTimeoutMillis = 20_000
            requestTimeoutMillis = 20_000
            connectTimeoutMillis = 20_000

        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }

    }
}