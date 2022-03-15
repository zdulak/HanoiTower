package hanoitower.core.players

import hanoitower.core.boards.Board

abstract class Player {
  def getMove(board: Board): (Int, Int)
}
