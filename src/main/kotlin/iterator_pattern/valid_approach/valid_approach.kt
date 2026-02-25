package iterator_pattern.valid_approach

import iterator_pattern.invalid_approach.MenuItem



/*---------------------------------------------------------------------------------------------------------------------*/
interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

interface Menu {
    fun createIterator(): Iterator<MenuItem>
}




/*---------------------------------------------------------------------------------------------------------------------*/

class PancakeHouseMenuIterator(private val items: List<MenuItem>) : iterator_pattern.valid_approach.Iterator<MenuItem> {
    private var position = 0

    override fun hasNext(): Boolean {
        return position < items.size
    }

    override fun next(): MenuItem {
        return items[position++]
    }
}



/*---------------------------------------------------------------------------------------------------------------------*/

class DinerMenuIterator(private val items: Array<MenuItem?>) : Iterator<MenuItem> {
    private var position = 0

    override fun hasNext(): Boolean {
        return position < items.size && items[position] != null
    }

    override fun next(): MenuItem {
        val menuItem = items[position]
        position++
        return menuItem!!
    }
}


/*---------------------------------------------------------------------------------------------------------------------*/
class PancakeHouseMenuV2 : Menu {
    private val menuItems: ArrayList<MenuItem> = ArrayList()

    init {
        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs and toast", true, 2.99)
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99)
    }

    fun addItem(name: String, description: String, vegetarian: Boolean, price: Double) {
        menuItems.add(MenuItem(name, description, vegetarian, price))
    }

    override fun createIterator(): Iterator<MenuItem> {
        return PancakeHouseMenuIterator(menuItems)
    }
}

/*---------------------------------------------------------------------------------------------------------------------*/

class DinerMenuV2 : Menu {
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

    override fun createIterator(): Iterator<MenuItem> {
        return DinerMenuIterator(menuItems)
    }
}



/*---------------------------------------------------------------------------------------------------------------------*/
class Waitress(
    private val pancakeHouseMenu: Menu,
    private val dinerMenu: Menu
) {
    fun printMenu() {
        val pancakeIterator = pancakeHouseMenu.createIterator()
        val dinerIterator = dinerMenu.createIterator()

        println("MENU\n----\nBREAKFAST")
        printMenu(pancakeIterator)
        println("\nLUNCH")
        printMenu(dinerIterator)
    }

    private fun printMenu(iterator: Iterator<MenuItem>) {
        while (iterator.hasNext()) {
            val menuItem = iterator.next()
            println("${menuItem.name}, ${menuItem.price} -- ${menuItem.description}")
        }
    }
}



/*---------------------------------------------------------------------------------------------------------------------*/
fun main() {
    val pancakeMenu = PancakeHouseMenuV2()
    val dinerMenu = DinerMenuV2()
    val waitress = Waitress(pancakeMenu, dinerMenu)
    waitress.printMenu()
}