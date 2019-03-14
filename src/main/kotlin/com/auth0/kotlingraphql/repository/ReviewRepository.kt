// ./src/main/kotlin/com/auth0/kotlingraphql/repository/ReviewRepository.kt

package com.auth0.kotlingraphql.repository

import com.auth0.kotlingraphql.entity.Review
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : MongoRepository<Review, String>