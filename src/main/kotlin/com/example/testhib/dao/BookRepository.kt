package com.example.testhib.dao

import com.example.testhib.model.Book
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BookRepository:CrudRepository<Book,Long> {
    @Query("select b from Book b where b.author.firstName = ?1 and b.author.lastName = ?2 ")
    fun allBooksByAuthor(firstName: String, lastName: String): List<Book>

    fun findBookByAuthor_FirstNameAndAuthor_LastNameOrderByTitle(firstName: String, lastName: String) : List<Book>

    @Query("select b from Book b")
    fun findAllBook(sort: Sort.Order):List<Book>

}