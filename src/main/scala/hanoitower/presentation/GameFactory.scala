package hanoitower.presentation

import hanoitower.core.games.Game
import hanoitower.core.players.{Computer, Human}

object GameFactory {
  def apply(isComputer: Boolean, diskAmount: Int): Game = {
    val player = if (isComputer) new Computer() else new Human(Controller)
    new Game(player, View)
  }

}
