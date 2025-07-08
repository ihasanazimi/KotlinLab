package decorator_pattern.company

import decorator_pattern.company.base.Employee
import decorator_pattern.company.product.PromotionToDeveloper
import decorator_pattern.company.product.RegularEmployee


fun main(){


    println("\nBefore promotion ---------------------------------------------------------------------------------------------------------------------------")
    var employee : Employee = RegularEmployee()
    println(employee.jobTitle() + "\nskills : ${employee.skills().size} \n" + employee.skills().joinToString("\n"))


    println("\nAfter promotion -----------------------------------------------------------------------------------------------------------------------------")
    employee = PromotionToDeveloper(employee)
    println(employee.jobTitle() + "\nskills : ${employee.skills().size} \n" + employee.skills().joinToString("\n"))

}