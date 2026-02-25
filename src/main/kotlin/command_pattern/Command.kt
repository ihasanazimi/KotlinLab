package command_pattern

/** Commands */
interface Command {
    fun executeCommand()
    fun undo()
}