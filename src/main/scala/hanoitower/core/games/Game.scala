package hanoitower.core.games

import hanoitower.core.boards.Board
import hanoitower.core.players.{Computer, Player}
import hanoitower.core.traits.{Controller, View}

class Game(player: Player, view: View) {
  def run(board: Board): Unit = {
    view.printBoard(board)
    if (board.isFinished)
      view.printMsg("Game is finished")
    else {
      val (start, end) = player.getMove(board)
      run(board.move(start, end))
    }

  }
}

