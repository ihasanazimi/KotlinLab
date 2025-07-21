package iterator_pattern.invalid_approach

// فرض کنید MenuItem یک کلاس ساده برای آیتم‌های منو است
data class MenuItem(val name: String, val description: String, val vegetarian: Boolean, val price: Double)

// کلاس PancakeHouseMenu (از ArrayList استفاده می‌کند)
class PancakeHouseMenu {
    private val menuItems: ArrayList<MenuItem> = ArrayList()

    init {
        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs and toast", true, 2.99)
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99)
    }

    fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        menuItems.add(MenuItem(name, description, vegetarian, price))
    }

    // این متد لیست خام را برمی‌گرداند که مشکل‌ساز است
    fun getMenuItems(): ArrayList<MenuItem> = menuItems
}

// کلاس DinerMenu (از Array استفاده می‌کند)
class DinerMenu {
    companion object { const val MAX_ITEMS = 6 }
    private var numberOfItems = 0
    private val menuItems: Array<MenuItem?> = arrayOfNulls(MAX_ITEMS)

    init {
        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99)
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99)
    }

    fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        if (numberOfItems >= MAX_ITEMS) {
            println("Sorry, menu is full! Can't add item to menu")
        } else {
            menuItems[numberOfItems] = MenuItem(name, description, vegetarian, price)
            numberOfItems++
        }
    }

    // این متد آرایه خام را برمی‌گرداند که مشکل‌ساز است
    fun getMenuItems(): Array<MenuItem?> = menuItems
}

// کلاس Waitress که با مشکل پیمایش مواجه است
class ProblematicWaitress(
    private val pancakeHouseMenu: PancakeHouseMenu,
    private val dinerMenu: DinerMenu
) {
    fun printMenu() {
        // دریافت لیست‌ها به صورت خام
        val breakfastItems = pancakeHouseMenu.getMenuItems()
        val lunchItems = dinerMenu.getMenuItems()

        println("MENU\n----\nBREAKFAST")
        // پیمایش ArrayList
        for (i in 0 until breakfastItems.size) {
            val menuItem = breakfastItems[i]
            println("${menuItem.name}, ${menuItem.price} -- ${menuItem.description}")
        }

        println("\nLUNCH")
        // پیمایش Array
        for (i in 0 until lunchItems.size) {
            val menuItem = lunchItems[i]
            if (menuItem != null) { // برای Array باید null check کنیم
                println("${menuItem.name}, ${menuItem.price} -- ${menuItem.description}")
            }
        }
        // اگه منوی جدیدی با HashMap اضافه بشه، یه حلقه دیگه لازم داریم!
    }
}

fun main() {
    val pancakeMenu = PancakeHouseMenu()
    val dinerMenu = DinerMenu()
    val waitress = ProblematicWaitress(pancakeMenu, dinerMenu)
    waitress.printMenu()
}