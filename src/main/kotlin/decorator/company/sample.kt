package decorator.company

import decorator.company.base.Employee
import decorator.company.product.PromotionToDeveloper
import decorator.company.product.RegularEmployee


fun main(){


    println("\nBefore promotion ---------------------------------------------------------------------------------------------------------------------------")
    var employee : Employee = RegularEmployee()
    println(employee.jobTitle() + "\nskills : ${employee.skill().size} \n" + employee.skill().joinToString("\n"))


    println("\nAfter promotion -----------------------------------------------------------------------------------------------------------------------------")

    employee = PromotionToDeveloper(employee)
    println(employee.jobTitle() + "\nskills : ${employee.skill().size} \n" + employee.skill().joinToString("\n"))

}