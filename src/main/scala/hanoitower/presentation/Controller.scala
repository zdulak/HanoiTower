package hanoitower.presentation

import hanoitower.core.boards.Board
import hanoitower.core.traits.Controller
import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Controller extends Controller {

  def exit(): Nothing = {
    println("Goodbye!")
    sys.exit()
  }

  @tailrec
  def getMove(board: Board): (Int, Int) = {
    val translationTable = (for (i <- 0 until 3) yield ((97 + i).toChar, i)).toMap
    val input =
      readLine("Please enter a coordinates of a move in the format \"AB\" or write exit: \n")
        .toLowerCase
    if (input == "exit") exit()
    if (input.length == 2 && input.forall(translationTable.contains)) {
      val (start, end) = (translationTable(input(0)), translationTable(input(1)))
      if (board.isValidMove(start, end))
        (start, end)
      else {
        println("Invalid coordinates")
        getMove(board)
      }
    }
    else {
      println("Invalid input")
      getMove(board)
    }
  }

  @tailrec
  def getMenuChoice(lowerBound: Int, upperBound: Int, message: () => Unit): Int = {
    message()
    println()
    val choice = readLine().toIntOption
    choice match {
      case Some(value) if (value >= lowerBound && value <= upperBound) => value
      case _ => {
        println("Invalid input")
        getMenuChoice(lowerBound, upperBound, message)
      }
    }
  }
}
