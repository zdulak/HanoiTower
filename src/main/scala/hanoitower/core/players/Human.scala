package hanoitower.core.players
import hanoitower.core.boards.Board
import hanoitower.core.traits.Controller

class Human(controller: Controller) extends Player {
  override def getMove(board: Board): (Int, Int) = controller.getMove(board)
}
