package hanoitower.core.boards

class Board(pegs: List[List[Int]]){
  private val _pegs = pegs
  private val _diskAmount: Int = _pegs.head.size

  def this(diskAmount: Int) = this(List((1 to diskAmount).toList, List(), List()))

  def apply(pegNumber: Int): Int = _pegs(pegNumber).head

  def move(start: Int, end: Int): Board = {
    new Board(_pegs.zipWithIndex.map { case (peg, i) => i match {
      case `start` => peg.tail
      case `end` => apply(start) :: peg
      case _ => peg
    }
    })
  }

  def IsValidMove(start: Int, end: Int): Boolean = apply(start) < apply(end)

  def IsFinished: Boolean = _pegs.last == (1 to _diskAmount).toList
}
