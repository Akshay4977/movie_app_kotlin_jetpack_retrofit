package com.example.tvshowsappassessment.data

import com.example.tvshowsappassessment.data.models.ShowModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShowService (private val showApi: ShowApi) {

    suspend fun getShows(): List<ShowModel> {

        return withContext(Dispatchers.IO) {
            val shows = showApi.getShows()
            shows.body() ?: emptyList()
        }
    }

    suspend fun getSearchShows(): List<ShowModel> {

        return withContext(Dispatchers.IO) {
            val shows = showApi.getSearchedShows()
            shows.body() ?: emptyList()
        }
    }

    suspend fun getSimilarShows(): List<ShowModel> {

        return withContext(Dispatchers.IO) {
            val shows = showApi.getSimilarShows()
            shows.body() ?: emptyList()
        }
    }
}