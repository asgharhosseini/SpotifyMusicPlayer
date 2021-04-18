package ir.vbile.app.spotifymusicplayer.service

import android.support.v4.media.MediaMetadataCompat
import ir.vbile.app.spotifymusicplayer.data.model.Song

fun MediaMetadataCompat.toSong(): Song? {
    return description?.let {
        Song(
            it.mediaId ?: "",
            it.title.toString(),
            it.subtitle.toString(),
            it.mediaUri.toString(),
            it.iconUri.toString()
        )
    }
}