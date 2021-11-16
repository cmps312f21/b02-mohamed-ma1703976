package cmps312.lab3.authormanagement.entity
import androidx.room.*

@Entity
class Book (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String? = null,
    var genre: String? = null,
    var autorId: Int = 0,
    )


