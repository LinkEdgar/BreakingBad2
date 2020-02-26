package com.example.breakingbadcharacters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel(){

    private var characterRepo = CharacterRepo()

    fun getCharacters():MutableLiveData<List<BreakingBadCharacter>>{
        return characterRepo.getCharacters()
    }
}