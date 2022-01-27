package com.example.testhib.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "book")
class Book(

    val title: String,
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    @JsonIgnore
    val author: Author
):BaseEntity<Long>() {



}