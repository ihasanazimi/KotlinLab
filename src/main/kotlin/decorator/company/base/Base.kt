package decorator.company.base


abstract class Employee {

    open var description = ""

    open fun  getJobDescription(): String{
        return description
    }

    abstract fun jobTitle() : String

    abstract fun skill() : List<String>

}






abstract class EmployeeDecorator : Employee() {

    open lateinit var employee : Employee

    override fun getJobDescription(): String {
        return employee.getJobDescription()
    }

    override fun skill(): List<String> {
        return employee.skill()
    }
}
