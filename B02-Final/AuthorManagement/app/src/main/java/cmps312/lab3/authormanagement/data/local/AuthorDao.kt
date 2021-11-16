package cmps312.lab3.authormanagement.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import cmps312.lab3.authormanagement.entity.Author
import cmps312.lab3.authormanagement.entity.Book


@Dao
interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAuthor(author:Author)

    @Query("SELECT * FROM Author")
    fun getAllAuthors(): LiveData<List<Author>>

    @Query("Delete FROM Book where autorId = :autorId")
    suspend fun DeleteAuthor(autorId: Int)

    @Delete
    suspend fun DeleteAuthor(author: Author)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBook(book: Book)

    @Query("SELECT * FROM Book where  autorId = :autorId")
    fun getAllBooks(autorId: Int): LiveData<List<Book>>

    @Update
    suspend fun updateBook(book: Book)

}