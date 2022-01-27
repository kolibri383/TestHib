package com.example.testhib.service

import com.example.testhib.model.Book
import org.hibernate.annotations.OrderBy


interface BookService {
    fun findAllBooks():List<Book>
    fun findBookById(id:Long):Book
    fun findBooksByAuthor(firsName:String,lastName:String):List<Book>
    fun addBook(newBook: Book)
    fun deleteBookById(id: Long)
    fun findAllBookSorting(firsName: String, lastName: String): List<Book>

}