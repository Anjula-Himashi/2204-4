object InventoryManagement {

  var itemNames = Array("apple", "banana", "orange")
  var itemQuantities = Array(10, 5, 8)

  // Function to display the inventory
  def displayInventory(): Unit = {
    println("Inventory:")
    for ((name, quantity) <- itemNames zip itemQuantities) {
      println(s"$name: $quantity")
    }
    println()
  }


  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index >= 0) {
      itemQuantities(index) += quantity
      println(s"Restocked $quantity of $itemName. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
    println()
  }


  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index >= 0) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough quantity of $itemName to sell. Available quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
    println()
  }


  def main(args: Array[String]): Unit = {
    displayInventory()
    restockItem("banana", 10)
    sellItem("orange", 5)
    sellItem("apple", 15)
    displayInventory()
  }
}
