object InventoryManagement {

  var itemNames: Array[String] = Array("Apples", "Bananas", "Oranges")
  var itemQuantities: Array[Int] = Array(10, 20, 15)

  def displayInventory(): Unit = {
    println("Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"$quantity units of $itemName added. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"$itemName does not exist in the inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"$quantity units of $itemName sold. Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough $itemName in stock to sell $quantity units.")
      }
    } else {
      println(s"$itemName does not exist in the inventory.")
    }
  }

  def main(args: Array[String]): Unit = {
    
    displayInventory()

    restockItem("Apples", 5)

    restockItem("Grapes", 10)

    sellItem("Bananas", 10)

    sellItem("Oranges", 20)

    displayInventory()
  }
}

