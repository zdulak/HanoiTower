package hanoitower.presentation

import hanoitower.core.boards.Board
import hanoitower.core.games.Game
import hanoitower.core.players.{Computer, Human}

object HanoiTower {
  def main(args: Array[String]): Unit = {
    val board = new Board(3)
//    val player = new Human(Controller)
    val player = new Computer(3)
    new Game(player, View).run(board)
//    main(args)
  }


}
