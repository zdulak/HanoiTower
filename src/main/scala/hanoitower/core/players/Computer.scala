package hanoitower.core.players

import hanoitower.core.boards.Board
import scala.collection.mutable

class Computer extends  Player {
  private val _moves = new mutable.Queue[(Int, Int)]()

  override def getMove(board: Board): (Int, Int) = {
    if (_moves.isEmpty) generateMoves(board.diskAmount, 0, 1, 2, _moves)
    Thread.sleep(200)
    _moves.dequeue()
  }

  private def generateMoves(diskNumber: Int, start: Int, auxiliary: Int, end: Int, moves: mutable.Queue[(Int, Int)]): Unit = {
    if (diskNumber > 0) {
      generateMoves(diskNumber - 1, start = start, auxiliary = end, end = auxiliary, moves)
      moves.append((start, end))
      // println((start, end))
      generateMoves(diskNumber - 1, start = auxiliary, auxiliary = start, end = end, moves)
    }

  }
}
