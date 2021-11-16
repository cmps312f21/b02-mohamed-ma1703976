package cmps312.lab3.authormanagement.data.repository

import android.content.Context
import cmps312.lab3.authormanagement.data.local.AuthorDatabase
import cmps312.lab3.authormanagement.entity.Author
import cmps312.lab3.authormanagement.entity.Book

class AuthorRepo(private val context: Context) {
    private val authorDao by lazy{
        AuthorDatabase.getDatabase(context).authorDao()
    }
    suspend fun addAuthor(author: Author)=authorDao.addAuthor(author)
    fun getAuthors()=authorDao.getAllAuthors()
    suspend fun deleteAuthor(authorid: Int) = authorDao.DeleteAuthor(authorid)
    suspend fun addBook(book: Book)=authorDao.addBook(book)
    fun getAllBooks(autorId: Int) = authorDao.getAllBooks(autorId)
    fun getItem(authorid: Int) = authorDao.getAllBooks(authorid)
    suspend fun updateBook(book: Book) {
        // Ensure that the productName and categoryId are set to null
        book.title = null
        book.genre = null

        authorDao.updateBook(book)
    }





}