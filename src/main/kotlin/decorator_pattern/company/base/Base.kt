package decorator_pattern.company.base


abstract class Employee {

    open var description = ""

    open fun  getJobDescription(): String{
        return description
    }

    abstract fun jobTitle() : String

    abstract fun skills() : List<String>

}






abstract class EmployeeDecorator : Employee() {

    open lateinit var employee : Employee

    override fun getJobDescription(): String {
        return employee.getJobDescription()
    }

    override fun skills(): List<String> {
        return employee.skills()
    }
}
