package cmps312.lab3.authormanagement.viewModle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cmps312.lab3.authormanagement.data.repository.AuthorRepo
import cmps312.lab3.authormanagement.entity.Author
import cmps312.lab3.authormanagement.entity.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorViewModel(appContext: Application): AndroidViewModel(appContext){


    private val authorRepo by lazy { AuthorRepo(appContext) }
    private val bookRating = listOf(
        "1",
        "2",
        "3",
        "4",
        "5"
    )
    private val genere = listOf(
        "Romance",
        "Comady",
        "Thriller",
    )

    var authors : LiveData<List<Author>> =authorRepo.getAuthors()

    lateinit var books: LiveData<List<Book>>

    lateinit var selectedAuthor:Author

    fun addAuthor(author: Author){
        viewModelScope.launch(Dispatchers.IO) {
           authorRepo.addAuthor(author)
        }

    }

    fun addBook(book: Book){

        viewModelScope.launch(Dispatchers.IO) {
           authorRepo.addBook(book)
        }
    }

    fun getallBooks(book: Book){
        books=authorRepo.getAllBooks(book.autorId)
    }
    fun updateBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        authorRepo.updateBook(book)
    }
    fun deleteAuthor(authordId:Int) = viewModelScope.launch(Dispatchers.IO) {
        authorRepo.deleteAuthor(authordId)
    }
    @JvmName("getauthorRating")
    fun getautorRating(): List<String> {
        return bookRating
    }
    @JvmName("getbookgenere")
    fun getbookgenere(): List<String> {
        return genere
    }


}