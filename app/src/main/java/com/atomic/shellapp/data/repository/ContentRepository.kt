package com.atomic.shellapp.data.repository

import com.atomic.shellapp.data.model.Sport
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentRepository @Inject constructor() {
    suspend fun getFeaturedSports(): List<Sport> {
        delay(5000)
        return Sport.createMockedSports()
    }
}