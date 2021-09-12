package Book

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

object BooksRepo {
    var books = listOf<Book>()

    init {
        val filePath = "data/catalog-books.json"
        val data = getFileContent(filePath)
        //println(fileContent)

        val json = Json { ignoreUnknownKeys = true }
        books = Json { ignoreUnknownKeys = true }.decodeFromString(data)
    }
    fun getBook(name: String): String {
        var res = "Not Found"
        val book = books.filter { it.title == name }
        if (book.isNotEmpty()) res = book[0].toString()
        return res
    }
    fun getBooksByPageCount(pageCount: Int): List<Book> {
        return books.filter { it.pageCount ?: 0 >= pageCount }
    }

    fun getBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author!!.contains(author) }
    }

    fun getBooksByCategory(category: String): List<Book> {
        return books.filter { it.categories!!.contains(category) }
    }
    fun getAuthorsBookCount(): MutableMap<String, Int> {
        val Authors = mutableSetOf<String>()
        val AuMap = mutableMapOf<String, Int>()
        books.map { it.author }
            .forEach { authors -> authors?.forEach { author -> Authors.add(author) } }
        Authors.forEach { AuMap[it] = getBooksByAuthor(it).size }
        return AuMap
    }
    private fun getFileContent(filePath: String): String {
        File(filePath).bufferedReader().use {
            return it.readText()
        }

    }
}
