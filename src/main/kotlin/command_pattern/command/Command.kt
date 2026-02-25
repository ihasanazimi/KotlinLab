package command_pattern.command

/*--------------------------------------------------------------------------------------------------------------------*/

interface Command {
    fun executeCommand()
    fun undo()
}

/*--------------------------------------------------------------------------------------------------------------------*/
class NoCommand: Command {
    override fun executeCommand(){}
    override fun undo(){}
}