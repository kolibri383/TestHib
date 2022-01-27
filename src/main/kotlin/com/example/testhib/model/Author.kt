package com.example.testhib.model

import javax.persistence.*

@Entity
@Table(name="author")
class Author (
    @Column(nullable = false)
    val firstName: String,
    @Column(nullable = false)
    val lastName: String,
    @OneToMany(mappedBy = "author")
    val books:MutableSet<Book> = mutableSetOf()
):BaseEntity<Long>(){

    fun addBook(block: Author.()->Book) {
        books.add(block())
    }
    fun setBooks(block: Author.() -> MutableSet<Book>){
        books.clear()
        books.addAll(block())
    }
}