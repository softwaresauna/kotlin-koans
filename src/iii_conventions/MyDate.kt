package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = toInt() - other.toInt()

    private fun toInt(): Int = year * 40 * 12 + month * 40 + dayOfMonth

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(start = this, endInclusive = other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

data class RepeatedTimeInterval(val timeInterval: TimeInterval, val number:Int)

class DateRange(override val endInclusive: MyDate, override val start: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {

            var currentDate = start

            override fun hasNext(): Boolean = currentDate <= endInclusive

            override fun next(): MyDate {

                if (!hasNext()) {
                    throw IndexOutOfBoundsException("Out of date range!")
                }

                val result = currentDate

                currentDate = currentDate.nextDay()

                return result
            }

        }
    }
}
