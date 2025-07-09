package singleton_pattern.phone_setting.modern_pattern


enum class PhoneSettingEnum {

    SETTING_UNIQ_OBJECT;

}



fun main(){

    val object1 = PhoneSettingEnum.SETTING_UNIQ_OBJECT
    val objects2 = PhoneSettingEnum.SETTING_UNIQ_OBJECT

    println("object1 == objects2   ->  " + "${object1.equals(objects2)}")

}