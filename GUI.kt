import javafx.embed.swing.JFXPanel
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.File
import javax.swing.JButton
import javax.swing.JFrame

class GUI : ActionListener {
    private val f: JFrame
    private val play: JButton
    private val pause: JButton
    private val stop: JButton
    private val mediaPlayer: MediaPlayer

    init {
        val useless = JFXPanel()

        val buddyHolly = "audio/Africa.mp3"
        val media = Media(File(buddyHolly).toURI().toString())
        mediaPlayer = MediaPlayer(media)

        f = JFrame("Weezer - Africa")
        f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        f.layout = BorderLayout()

        play = JButton("Play Africa by Weezer")
        play.size = Dimension(150, 20)
        play.addActionListener(this)
        f.add(play, BorderLayout.CENTER)

        pause = JButton("Pause Africa by Weezer")
        pause.size = Dimension(150, 20)
        pause.addActionListener(this)
        f.add(pause, BorderLayout.LINE_START)

        stop = JButton("Stop Africa by Weezer")
        stop.size = Dimension(150, 20)
        stop.addActionListener(this)
        f.add(stop, BorderLayout.LINE_END)

        f.size = Dimension(600, 100)
        f.isVisible = true
        f.isResizable = false
    }

    override fun actionPerformed(e: ActionEvent) {
        when (e.source) {
            play -> mediaPlayer.play()
            pause -> mediaPlayer.pause()
            stop -> mediaPlayer.stop()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GUI()
        }
    }
}

