package hanoitower.core.boards

class Board(pegs: List[List[Int]]){
  private val _pegs = pegs

  def this(diskAmount: Int) = this(List((1 to diskAmount).toList, List(), List()))

  def apply(pegNumber: Int): Int = _pegs(pegNumber).head

  def move(start: Int, end: Int): Option[Board] = {
    if (IsValidMove(start, end)) {
      Some(new Board(_pegs.zipWithIndex.map { case (peg, i) => i match {
        case `start` => peg.tail
        case `end` => apply(start) :: peg
        case _ => peg
      }
      }))
    }
    else
      None
  }


  private def IsValidMove(start: Int, end: Int): Boolean = apply(start) < apply(end)
}
