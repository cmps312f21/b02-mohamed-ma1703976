package Book

import kotlinx.serialization.Serializable
import java.net.URL
import java.util.*

data class Book (
        val id: Int,
        val title: String,
        val isbn: Int,
        val pageCount: Int,
        val publishedDate: Date,
        val thumbnailUrl: URL,
        val status: String,
        val author: List<String>?,
        val categories : List<String>?,

    )
