package com.angerbytes.almoxarifado.resources.exceptions

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.Instant

class StandardError(
    timestamp: Instant,
    status: Int,
    error: String,
    message: String,
    path: String
    ) : Serializable {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        private val timestamp = timestamp
    }