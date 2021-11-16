package cmps312.lab3.authormanagement.entity


import androidx.room.*

@Entity
data class Author (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val rating: String,
)