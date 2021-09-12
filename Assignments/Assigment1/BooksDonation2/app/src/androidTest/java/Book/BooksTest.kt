package Book

fun main() {
    println(BooksRepo.getBook("Android in Action, Second Edition"))
    BooksRepo.getBooksByPageCount(400).forEach { println(it) }
    BooksRepo.getBooksByAuthor("W. Frank Ableson").forEach { println(it) }
    BooksRepo.getBooksByCategory("Internet").forEach { println(it) }
    BooksRepo.getAuthorsBookCount().forEach { println(it) }
}