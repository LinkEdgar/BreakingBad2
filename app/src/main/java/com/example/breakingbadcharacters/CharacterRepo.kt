package com.example.breakingbadcharacters

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class CharacterRepo (){

    private var characters = MutableLiveData<List<BreakingBadCharacter>>()

    private var retroFit = Retrofit.Builder().baseUrl("https://www.breakingbadapi.com/api/").addConverterFactory(GsonConverterFactory.create()).addConverterFactory(GsonConverterFactory.create())
            .build()


    fun getCharacters():MutableLiveData<List<BreakingBadCharacter>>{
        characters = MutableLiveData()
        val characterList = retroFit.create(CharacterInterface::class.java)
        characterList.getCharacters().enqueue(object : Callback<List<BreakingBadCharacter>>{
            override fun onFailure(call: Call<List<BreakingBadCharacter>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<BreakingBadCharacter>>, response: Response<List<BreakingBadCharacter>>) {
                if(response.isSuccessful){
                    characters.postValue(response.body())
                }
            }

        })
        return characters
    }

    interface CharacterInterface{
        @GET("characters")
        fun getCharacters(): Call<List<BreakingBadCharacter>>

    }
}