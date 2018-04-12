package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> =
// Return the set of customers who ordered the specified product
        customers.filter { customer -> customer.orders.flatMap(Order::products).any { orderedProduct -> orderedProduct == product } }.toSet()

fun Customer.getMostExpensiveDeliveredProduct(): Product? =
// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
        orders
                .filter(Order::isDelivered)
                .flatMap(Order::products)
                .maxBy(Product::price)

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
// Return the number of times the given product was ordered.
// Note: a customer may order the same product for several times.
        customers
                .flatMap(Customer::orders)
                .flatMap(Order::products)
                .count { orderedProduct -> orderedProduct == product }

