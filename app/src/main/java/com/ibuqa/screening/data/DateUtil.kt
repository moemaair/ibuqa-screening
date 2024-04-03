package com.ibuqa.screening.data

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


fun DateUtil(date: String): String {
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
    val zonedDateTime = ZonedDateTime.parse(date)
    val localDateTime = zonedDateTime.toLocalDateTime()
    return localDateTime.format(formatter)
}