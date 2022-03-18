package hanoitower.presentation

object Menu {
  def mainMenu(): Unit =
    menu(List(newGameMenu, aboutMenu, Controller.exit), View.printMainMenu)

  def newGameMenu(): Unit = ???

  def aboutMenu(): Unit = {
    View.printAbout()
    mainMenu()
  }

  private def menu(options: List[() => Unit], message: () => Unit): Unit = {
    val choice = Controller.getMenuChoice(0, options.size - 1, message)
    options(choice)()
  }
}
