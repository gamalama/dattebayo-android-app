package id.biz.equatron.dattebayo.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CharactersItem(

//	@field:SerializedName("debut")
//	val debut: Debut,
//
    @field:SerializedName("images")
    val images: List<String>,
//
//	@field:SerializedName("voiceActors")
//	val voiceActors: VoiceActors,

    @field:SerializedName("jutsu")
    val jutsu: List<String>,

    @field:SerializedName("name")
    val name: String,

	@field:SerializedName("personal.titles")
	val personal: Personal,

    @field:SerializedName("id")
    val id: Int,

//	@field:SerializedName("family")
//	val family: Family,
//
//	@field:SerializedName("natureType")
//	val natureType: List<String>,
//
//	@field:SerializedName("rank")
//	val rank: Rank,
//
//	@field:SerializedName("tools")
//	val tools: List<String>,
//
//	@field:SerializedName("uniqueTraits")
//	val uniqueTraits: List<String>
)

data class Personal(

    @field:SerializedName("occupation")
    val occupation: List<String>,

    @field:SerializedName("affiliation")
    val affiliation: List<String>,

    @field:SerializedName("sex")
    val sex: String,

    @field:SerializedName("classification")
    val classification: List<String>,

    @field:SerializedName("birthdate")
    val birthdate: String,

    @field:SerializedName("clan")
    val clan: String,

    @field:SerializedName("weight")
    val weight: Weight,

    @field:SerializedName("team")
    val team: List<String>,

    @field:SerializedName("bloodType")
    val bloodType: String,

    @field:SerializedName("age")
    val age: Age,

    @field:SerializedName("height")
    val height: Height,

    @field:SerializedName("kekkeiGenkai")
    val kekkeiGenkai: List<String>,

    @field:SerializedName("titles")
    val titles: List<String>,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("partner")
    val partner: List<String>,

    @field:SerializedName("species")
    val species: String,

    @field:SerializedName("tailedBeast")
    val tailedBeast: String,

    @field:SerializedName("kekkeiMōra")
    val kekkeiMRa: String
)