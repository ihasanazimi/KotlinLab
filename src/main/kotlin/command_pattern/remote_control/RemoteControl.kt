package command_pattern.remote_control


/** Commands */
private interface Command {
    fun executeCommand()
    fun undo()
}

private class NoCommand : Command {
    override fun executeCommand() { /* do nothing */ }
    override fun undo() {}
}


/** Receivers */
private class Light(val location: String) {
    fun on() {
        println("$location light is on")
    }

    fun off() {
        println("$location light is off")
    }
}

private class GarageDoor(val location: String) {
    fun up() {
        println("$location garage door is up")
    }

    fun down() {
        println("$location garage door is down")
    }
}




/** Concrete Command */
private class LightOnCommand(private val light: Light) : Command {
    override fun executeCommand() {
        light.on() // متد on را روی شیء Light فراخوانی می‌کند
    }

    override fun undo() {
        light.off()
    }
}

private class LightOffCommand(private val light: Light) : Command {
    override fun executeCommand() {
        light.off()
    }

    override fun undo() {
        light.on()
    }
}

private class GarageDoorOpenCommand(private val garageDoor: GarageDoor) : Command {
    override fun executeCommand() {
        garageDoor.up()
    }

    override fun undo() {
        garageDoor.down()
    }
}


private class MacroCommand(private val commands : Array<Command>) : Command {
    override fun executeCommand() {
        commands.forEach {
            it.executeCommand()
        }
    }
    override fun undo() {
        for (i in commands.indices.reversed())  {
            commands[i].undo()
        }
    }
}





/** Invoker */
private class RemoteControl {

    private val onCommands: Array<Command> = Array(7) { NoCommand() }
    private val offCommands: Array<Command> = Array(7) { NoCommand() }
    private var undoCommand : Command = NoCommand()

    fun setCommand(index: Int, onCommand: Command, offCommand: Command) {
        onCommands[index] = onCommand
        offCommands[index] = offCommand
    }

    fun onButtonWasPushed(index: Int) {
        onCommands[index].executeCommand()
        undoCommand = onCommands[index]
    }

    fun offButtonWasPushed(index: Int) {
        offCommands[index].executeCommand()
        undoCommand = offCommands[index]
    }


    override fun toString(): String {
        val stringBuff = StringBuilder()
        stringBuff.append("\n------ Remote Control -------\n")
        for (i in 0 until onCommands.size) {
            stringBuff.append("[index $i] ${onCommands[i].javaClass.simpleName} ${offCommands[i].javaClass.simpleName}\n")
        }
        return stringBuff.toString()
    }
}



/** Client  */
fun main() {
    val remote = RemoteControl()

    val livingRoomLight = Light("Living Room")
    val garageDoor = GarageDoor("Garage")


    val livingRoomLightOn = LightOnCommand(livingRoomLight)
    val livingRoomLightOff = LightOffCommand(livingRoomLight)
    val garageDoorOpen = GarageDoorOpenCommand(garageDoor)


    remote.setCommand(0, livingRoomLightOn, livingRoomLightOff)
    remote.setCommand(1, garageDoorOpen, NoCommand())

    println(remote)

    remote.onButtonWasPushed(0)
    remote.offButtonWasPushed(0)
    remote.onButtonWasPushed(1)
}






