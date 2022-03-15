package hanoitower.presentation

import hanoitower.core.boards.Board
import hanoitower.core.traits.View

object View extends View {
  override def printBoard(board: Board): Unit = {
    val offsets = (0 until 3).map(board.diskAmount - board.size(_))

    println()
    for (row <- 0 until (board.diskAmount + 2)) {
      for (col <- 0 until 3) {
        val rowOffset = row - offsets(col)
        if (rowOffset >= 0 && row < board.diskAmount)
          print(pegLevelToString(board.diskAmount, board(col, rowOffset), '=', '|'))
        else if (row == board.diskAmount)
          print(pegLevelToString(board.diskAmount, board.diskAmount, '-', '-'))
        else if (row == board.diskAmount + 1)
          print(pegLevelToString(board.diskAmount, board.diskAmount, ' ', (65 + col).toChar))
        else
          print(pegLevelToString(board.diskAmount, board.diskAmount, ' ', '|'))
        print("  ")
      }
      println()
    }
  }

  private def pegLevelToString(maxDiskSize: Int, diskSize: Int, diskChar: Char, separator: Char): String =
    {
      val sb = new StringBuilder()
      sb ++= " " * (maxDiskSize - diskSize) ++= (diskChar.toString * diskSize) ++= separator.toString ++=
        (diskChar.toString * diskSize) ++= " " * (maxDiskSize - diskSize)
      sb.toString
    }
}
