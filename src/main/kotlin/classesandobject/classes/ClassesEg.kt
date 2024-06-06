package classesandobject.classes

interface MediaPlayer {
    fun play()
    fun pause()
    fun stop()
    fun restart()
}

enum class MediaType {
    AUDIO, VIDEO, STREAMING
}

open class BaseMediaPlayer(val type: MediaType) : MediaPlayer {
    protected var isPlaying: Boolean = false

    override fun play() {
        isPlaying = true
        println("$type Player is playing.")
    }

    override fun pause() {
        isPlaying = false
        println("$type Player is paused.")
    }

    override fun stop() {
        isPlaying = false
        println("$type Player is stopped.")
    }

    override fun restart() {
        stop()
        play()
    }
}

class AudioPlayer : BaseMediaPlayer(MediaType.AUDIO)
class VideoPlayer : BaseMediaPlayer(MediaType.VIDEO)
class StreamingPlayer : BaseMediaPlayer(MediaType.STREAMING)

fun main() {

    val audioPlayer = AudioPlayer()
    val videoPlayer = VideoPlayer()
    val streamingPlayer = StreamingPlayer()

    audioPlayer.play()
    videoPlayer.play()
    streamingPlayer.play()

    // Restart media
    audioPlayer.restart()
    videoPlayer.restart()
    streamingPlayer.restart()

}
