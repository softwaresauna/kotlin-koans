package i_introduction._11_SAM_Conversions

import util.TODO
import util.doc11
import java.util.*

fun todoTask11(): Nothing = TODO(
        """
        Task 11.
        When an object implements a SAM interface (one with a Single Abstract Method), you can pass a lambda instead.
        Rewrite the previous example changing an object expression to a lambda.
    """,
        documentation = doc11()
)

fun task11(list: List<Int>): List<Int> {
    Collections.sort(list, { x, y -> y - x })
    return list
}
