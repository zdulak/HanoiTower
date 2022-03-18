package hanoitower.presentation

import hanoitower.core.boards.Board

object Menu {
  def mainMenu(): Unit =
    menu(List(diskAmountMenu, aboutMenu, Controller.exit), View.printMainMenu)

  def newGameMenu(diskAmount: Int): Unit = {
    menu(List(() => GameFactory(false, diskAmount).run(new Board(diskAmount)),
              () => GameFactory(true, diskAmount).run(new Board(diskAmount)), mainMenu), View.printNewGameMenu)
    mainMenu()
  }

  def diskAmountMenu(): Unit = {
    val choice = Controller.getMenuChoice(1, 10, View.printDisksAmountMenu) + 1
    newGameMenu(choice)
  }

  def aboutMenu(): Unit = {
    View.printAbout()
    mainMenu()
  }

  private def menu(options: List[() => Unit], message: () => Unit): Unit = {
    val choice = Controller.getMenuChoice(1, options.size, message)
    options(choice)()
  }
}
