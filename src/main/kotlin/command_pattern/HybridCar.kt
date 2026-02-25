package command_pattern

/*---------------------------------------------------------------------------------------------------------------------*/


private interface Command{
    fun executeCommand()
    fun undo()
}

/*---------------------------------------------------------------------------------------------------------------------*/


private class NoCommand: Command{
    override fun executeCommand(){}
    override fun undo(){}
}

/*---------------------------------------------------------------------------------------------------------------------*/


private class Car(val carName : String){

    fun startEngine(){
        println("Starting engine on $carName" + "car")
    }

    fun stopEngine(){
        println( "stoping engine on $carName" + "car")
    }

    fun moveForward(){
        println("$carName  Move forward")
    }

    fun moveBackward(){
        println("$carName Move backward")
    }

    fun brake(){
        println("$carName brake")
    }

    fun turnOnLight(){
        println("$carName Turn on light on")
    }

    fun turnOffLight(){
        println("$carName Turn on light off")
    }

    fun openDoor(){
        println("$carName Open door")
    }

    fun closeDoor(){
        println("$carName Close door")
    }

}


/*---------------------------------------------------------------------------------------------------------------------*/


private class MovementToForward(val car: Car) : Command{

    override fun executeCommand() {
        car.moveForward()
    }

    override fun undo() {
        car.moveBackward()
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


private class MovementToBackward(val car: Car) : Command{

    override fun executeCommand() {
        car.moveBackward()
    }

    override fun undo() {
        car.moveForward()
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


private class TurnOnLight(val car: Car) : Command{
    override fun executeCommand() {
        car.turnOnLight()
    }

    override fun undo() {
        car.turnOffLight()
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/


private class TurnOffLight(val car: Car) : Command{
    override fun executeCommand() {
        car.turnOffLight()
    }

    override fun undo() {
        car.turnOffLight()
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/


private class StartEngine(val car: Car) : Command{
    override fun executeCommand() {
        car.startEngine()
    }

    override fun undo() {
        car.stopEngine()
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/


private class StopEngine(val car: Car) : Command{
    override fun executeCommand() {
        car.stopEngine()
    }

    override fun undo() {
        car.startEngine()
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/

/** Invoker */
private class CarOptionsInvoker{

    private val commands : Array<Command> = Array(10) {NoCommand()}
    private val reverseCommands : Array<Command> = Array(10){NoCommand()}
    private var undoCommand : Command = NoCommand()

    fun setCommand(index : Int , command : Command , reverseCommand: Command = NoCommand()){
        commands[index] = command
        reverseCommands[index] = reverseCommand
    }

    fun doCommand(index : Int){
        commands[index].executeCommand()
        undoCommand = commands[index]
    }

    fun reverseCommand(index : Int){
        reverseCommands[index].executeCommand()
        undoCommand = reverseCommands[index]
    }

    fun undo(){
        undoCommand.undo()
    }


    override fun toString(): String {
        val stringBuff = StringBuilder()
        stringBuff.append("\n------ Hybrid Car -------\n")
        for (i in 0 until commands.size) {
            stringBuff.append("[index $i] ${commands[i].javaClass.simpleName} ${reverseCommands[i].javaClass.simpleName}\n")
        }
        return stringBuff.toString()
    }

}

/*---------------------------------------------------------------------------------------------------------------------*/



fun main(){

    val carOptionsInvoker = CarOptionsInvoker()

    carOptionsInvoker.setCommand(0,MovementToForward(Car("Benz")), MovementToBackward(Car("Benz")))
    carOptionsInvoker.setCommand(1, TurnOnLight(Car("ICKO")), TurnOffLight(Car("ICKO")))
    carOptionsInvoker.setCommand(2, TurnOnLight(Car("Toyota")), TurnOffLight(Car("Toyota")))

    println(carOptionsInvoker)

    println(carOptionsInvoker.doCommand(0))

    println(carOptionsInvoker.doCommand(1))

    println(carOptionsInvoker.doCommand(2)).also {
        println(carOptionsInvoker.undo())
    }

}
