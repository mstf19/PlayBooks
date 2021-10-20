package com.goodwy.audiobooklite.uitools

import android.graphics.drawable.AnimatedVectorDrawable
import android.widget.ImageView
import com.goodwy.audiobooklite.R

class PlayPauseColorDrawableSetter(private val fab: ImageView) {

  private val playToPause =
    fab.context.getDrawable(R.drawable.avd_play_to_pause_color)!! as AnimatedVectorDrawable
  private val pauseToPlay =
    fab.context.getDrawable(R.drawable.avd_pause_to_play_color)!! as AnimatedVectorDrawable

  private var playing = false

  init {
    fab.setImageDrawable(playToPause)
  }

  fun setPlaying(playing: Boolean) {
    if (this.playing == playing) {
      return
    }
    this.playing = playing

    if (fab.isLaidOut) {
      val drawable = if (playing) {
        playToPause
      } else {
        pauseToPlay
      }
      fab.setImageDrawable(drawable)
      drawable.start()
    } else {
      val drawable = if (playing) {
        pauseToPlay
      } else {
        playToPause
      }
      fab.setImageDrawable(drawable)
    }
  }
}
