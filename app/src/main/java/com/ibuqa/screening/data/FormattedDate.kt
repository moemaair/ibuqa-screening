package com.ibuqa.screening.data

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class FormattedDate {
    // Get the current date
    val currentDate = LocalDate.now()

    // Define a formatter for the desired format
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM", Locale.ENGLISH)

    // Format the date using the formatter
    val formattedDate = currentDate.format(formatter)

}
