package hanoitower.core.boards

class Board(val diskAmount: Int, pegs: List[List[Int]]){
  private val _pegs = pegs

  def this(diskAmount: Int) = this(diskAmount, List((1 to diskAmount).toList, List(), List()))

  def apply(pegNumber: Int, level: Int = 0): Int = _pegs(pegNumber)(level)

  def move(start: Int, end: Int): Board = {
    new Board(diskAmount, _pegs.zipWithIndex.map { case (peg, i) => i match {
      // pop
      case `start` => peg.tail
      // push
      case `end` => apply(start) :: peg
      case _ => peg
    }
    })
  }

  def isValidMove(start: Int, end: Int): Boolean = {
    if (_pegs(start).isEmpty) false
    else if (_pegs(end).isEmpty) true
    else apply(start) < apply(end)
  }

  def isFinished: Boolean = _pegs.last == (1 to diskAmount).toList

  def size(pegNumber: Int): Int = _pegs(pegNumber).size
}
