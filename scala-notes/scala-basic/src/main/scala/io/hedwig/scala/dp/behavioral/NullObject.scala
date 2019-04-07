/**
  * @@author: patrick
  */
trait Sound {
  def play()
}

class Music extends Sound {
  def play() { /* ... */ }
}

object SoundSource {
  def getSound(available:Boolean,music: Music): Option[Sound] =
    if (available) Some(music) else None
}

for (sound <- SoundSource.getSound(true,new Music)) {
  sound.play()
}