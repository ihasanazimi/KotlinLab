package decorator_pattern.company.product

import decorator_pattern.company.base.Employee
import decorator_pattern.company.base.EmployeeDecorator

class RegularEmployee : EmployeeDecorator() {

    init {
        description = "An office employee handles administrative tasks, supports daily operations, and helps maintain smooth workflow in the organization."
    }

    override fun skills(): List<String> {
        return arrayListOf<String>(
            "Organizational and time management skills",
            "Proficiency in office software (e.g., Word, Excel, Outlook)",
            "Effective communication and teamwork",
        )
    }

    override fun jobTitle(): String {
        return "RegularEmployee Position"
    }
}


class Developer : EmployeeDecorator() {

    init {
        description = "A developer is a professional who writes, tests, and maintains software applications to solve problems or deliver specific functionalities."
    }

    override fun skills(): List<String> {
        return arrayListOf<String>(
            "Design and develop Android applications",
            "Collaborate with cross-functional teams (UI/UX, backend, QA, etc.)",
            "Write clean, maintainable, and testable code using Kotlin/Java",
            "Integrate APIs and third-party libraries",
            "Fix bugs and optimize app performance"
        )
    }

    override fun jobTitle(): String {
        return "Developer Position"
    }
}



/*****************************************************************************************************************************************************/



class PromotionToDeveloper(override var employee: Employee) : EmployeeDecorator() {

    private val developerObject by lazy { Developer() }

    override fun getJobDescription(): String {
        return employee.getJobDescription() + "\n" + developerObject.getJobDescription()
    }

    override fun skills(): List<String> {
        return employee.skills() + developerObject.skills()
    }

    override fun jobTitle(): String {
        return developerObject.jobTitle()
    }
}