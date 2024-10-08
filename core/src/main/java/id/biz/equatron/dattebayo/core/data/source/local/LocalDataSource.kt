package id.biz.equatron.dattebayo.core.data.source.local

import id.biz.equatron.dattebayo.core.data.source.local.entity.CharacterEntity
import id.biz.equatron.dattebayo.core.data.source.local.room.CharacterDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val characterDao: CharacterDao) {

    fun getAllCharacter(): Flow<List<CharacterEntity>> = characterDao.getAllCharacter()

    fun getFavoriteCharacter(): Flow<List<CharacterEntity>> = characterDao.getFavoriteTourism()

    suspend fun insertCharacter(characterList: List<CharacterEntity>) =
        characterDao.insertCharacterList(characterList)

    fun setFavoriteCharacter(character: CharacterEntity, newState: Boolean) {
        character.isFavorite = newState
        characterDao.updateFavoriteCharacter(character)
    }

    suspend fun getCharacterById(id: Int): CharacterEntity = characterDao.getCharacter(id)
}