// ./src/main/kotlin/com/auth0/kotlingraphql/entity/Review.kt

package com.auth0.kotlingraphql.entity

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "reviews")
data class Review(
        var snackId: String,
        var rating: Int,
        var text: String
)