package ml.wonwoo.armeriaworkshop.utils

import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor
import java.util.Locale

private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it) }

private val englishDateFormatter = DateTimeFormatterBuilder()
    .appendPattern("MMMM")
    .appendLiteral(" ")
    .appendText(ChronoField.DAY_OF_MONTH, daysLookup)
    .appendLiteral(" ")
    .appendPattern("yyyy")
    .toFormatter(Locale.ENGLISH)

private fun getOrdinal(n: Int) = when {

    n in 11..13 -> n.toString() + "th"

    n % 10 == 1 -> n.toString() + "st"

    n % 10 == 2 -> n.toString() + "nd"

    n % 10 == 3 -> n.toString() + "rd"

    else -> n.toString() + "th"

}

fun TemporalAccessor.formatToEnglish(): String = englishDateFormatter.format(this)
