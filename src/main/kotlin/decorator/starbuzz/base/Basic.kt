package decorator.starbuzz.base


// کلاس پایه Beverage (نوشیدنی) - این همون Component ماست
abstract class Beverage {
    open var description: String = "Unknown Beverage" // توضیحات نوشیدنی

    open fun getBeverageDescription(): String {
        return description
    }

    abstract fun cost(): Double // متد انتزاعی برای محاسبه قیمت
}



// کلاس پایه CondimentDecorator (چاشنی) - این همون Decorator انتزاعی ماست
// از Beverage ارث‌بری می‌کنه تا هم‌نوع Beverage باشه
abstract class CondimentDecorator : Beverage() {
    // هر Decorator باید مرجعی به Beverage (که داره تزیینش می‌کنه) داشته باشه
    // این متغیر در سازنده Decoratorهای خاص مقداردهی می‌شود
    abstract var beverage: Beverage

    // این متد باید توسط Decoratorهای خاص پیاده‌سازی شود
    // تا توضیحات نوشیدنی تزیین شده را برگرداند
    abstract override fun getBeverageDescription(): String
}




/***********************************************************************************************************************/







