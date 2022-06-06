class ClassExample {
    var name: String

    constructor() {
        this.name = ""
    }

    constructor(name: String) {
        this.name = name
    }

    fun sayHello() {
        println("Hello $name")
    }
}

fun main() {
    val uie = ClassExample("John")
    uie.sayHello()

    uie.name = "Cena"
    uie.sayHello()

}