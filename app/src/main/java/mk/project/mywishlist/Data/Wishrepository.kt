package mk.project.mywishlist.Data

import kotlinx.coroutines.flow.Flow

class Wishrepository(private val wishDao: WishDao) {

    suspend fun addWish(wish:Wish){
        wishDao.addWish(wish)
    }
    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id:Long) : Flow<Wish>{
        return wishDao.getAWishe(id)
    }
    suspend fun updateAWish(wish: Wish){
        wishDao.updateAWish(wish)
    }
    suspend fun deleteWish(wish:Wish){
        wishDao.deleteAWish(wish)
    }
}