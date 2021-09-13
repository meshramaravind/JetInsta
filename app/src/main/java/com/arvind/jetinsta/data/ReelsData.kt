package com.arvind.jetinsta.data

import android.net.Uri

object ReelsData {

    val reels = listOf<Reel>(
        Reel(
            id = 0,
            video = "castle.mp4",
            userImage = "https://via.placeholder.com/300.png/09f/fff",
            userName = "Arvind Meshram",
            isLiked = true,
            likesCount = 2000,
            commentsCount = 156
        ),
        Reel(
            id = 0,
            video = "food.mp4",
            userImage = "https://via.placeholder.com/300.png/09f/fff",
            userName = "Arvind Meshram",
            isLiked = true,
            likesCount = 2000,
            commentsCount = 156
        ),
        Reel(
            id = 0,
            video = "icecream.mp4",
            userImage = "https://via.placeholder.com/300.png/09f/fff",
            userName = "Arvind Meshram",
            isLiked = true,
            likesCount = 2000,
            commentsCount = 156
        ),
        Reel(
            id = 0,
            video = "lake.mp4",
            userImage = "https://via.placeholder.com/300.png/09f/fff",
            userName = "Arvind Meshram",
            isLiked = true,
            likesCount = 2000,
            commentsCount = 156
        ),
        Reel(
            id = 0,
            video = "soap-bubbles.mp4",
            userImage = "https://via.placeholder.com/300.png/09f/fff",
            userName = "Arvind Meshram",
            isLiked = true,
            likesCount = 2000,
            commentsCount = 156
        )
    )
}

data class Reel(
    val id: Int,
    private val video: String,
    val userImage: String,
    val userName: String,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val commentsCount: Int
) {

    fun getVideoUrl(): Uri {
        return Uri.parse("asset:///${video}")
    }

}