package mk.project.mywishlist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import mk.project.mywishlist.Data.WishDatabase
import mk.project.mywishlist.Data.Wishrepository

object Graph {
    lateinit var database: WishDatabase

    val wishrepository by lazy {
        Wishrepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase :: class.java,"wishlist.db").build()
    }
}