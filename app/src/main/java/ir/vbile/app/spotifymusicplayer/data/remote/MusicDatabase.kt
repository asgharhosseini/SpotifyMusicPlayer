package ir.vbile.app.spotifymusicplayer.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import ir.vbile.app.spotifymusicplayer.data.model.Song
import ir.vbile.app.spotifymusicplayer.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val fireStore = FirebaseFirestore.getInstance()
    private val songCollection = fireStore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}