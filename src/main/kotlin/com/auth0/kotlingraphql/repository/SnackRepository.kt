// ./src/main/kotlin/com/auth0/kotlingraphql/repository/SnackRepository.kt

package com.auth0.kotlingraphql.repository

import com.auth0.kotlingraphql.entity.Snack
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SnackRepository : MongoRepository<Snack, String>