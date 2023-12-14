package com.example.tvshowsappassessment.data

import com.example.tvshowsappassessment.data.models.ShowModel
import com.example.tvshowsappassessment.utils.Constants.Companion.SHOWS_ALL_ENDPOINT
import com.example.tvshowsappassessment.utils.Constants.Companion.SHOWS_SEARCH_ENDPOINT
import com.example.tvshowsappassessment.utils.Constants.Companion.SHOWS_SIMILAR_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ShowApi {

    @GET(SHOWS_ALL_ENDPOINT)
    suspend fun getShows(): Response<List<ShowModel>>

    @GET(SHOWS_SIMILAR_ENDPOINT)
    suspend fun getSimilarShows(): Response<List<ShowModel>>

    @GET(SHOWS_SEARCH_ENDPOINT)
    suspend fun getSearchedShows(): Response<List<ShowModel>>

}