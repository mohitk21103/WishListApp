package mk.project.mywishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import mk.project.mywishlist.Data.Wish
import mk.project.mywishlist.Data.Wishrepository

class WishViewModel(
    private val WishRepository: Wishrepository = Graph.wishrepository
): ViewModel() {
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes : Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = WishRepository.getWishes()
        }
    }

    fun addWish(wish:Wish){
        viewModelScope.launch {
            WishRepository.addWish(wish=wish)
        }
    }
    fun getAWishById(id:Long): Flow<Wish>{
        return WishRepository.getWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            WishRepository.updateAWish(wish=wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            WishRepository.deleteWish(wish=wish)
        }
    }
}