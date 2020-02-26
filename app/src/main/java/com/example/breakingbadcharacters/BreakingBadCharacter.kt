package com.example.breakingbadcharacters

import com.google.gson.annotations.SerializedName

data class BreakingBadCharacter (
        @SerializedName("char_id") var char_id : Int,
        @SerializedName("name") var name : String,
        @SerializedName("birthday") var birthday : String,
        @SerializedName("occupation") var occupation : List<String>,
        @SerializedName("img") var img : String,
        @SerializedName("status") var status : String,
        @SerializedName("nickname") var nickname : String,
        @SerializedName("appearance") var appearance : List<Int>,
        @SerializedName("portrayed") var portrayed : String,
        @SerializedName("category") var category : String,
        @SerializedName("better_call_saul_appearance") val better_call_saul_appearance : List<String>
){}