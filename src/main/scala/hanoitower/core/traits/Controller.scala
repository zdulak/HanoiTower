package hanoitower.core.traits

import hanoitower.core.boards.Board

trait Controller {
  def exit(): Nothing
  def getMove(board: Board): (Int, Int)

}
