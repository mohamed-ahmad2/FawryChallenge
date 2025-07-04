# 🛒 E-Commerce System

This is a simple Java-based console application that simulates an e-commerce shopping and checkout experience.

The system allows:
- Defining products with various properties (price, quantity, expiration, shipping, weight)
- Adding products to a customer's cart
- Validating expiration, stock, and customer balance
- Calculating shipping fees and order subtotal
- Simulating a shipping service for shippable products
- Generating a clear and structured receipt

---

## ✅ Features

- 📦 **Products**
  - Each product has: name, price, quantity, expiration status, shippable flag, weight (if shippable), and shipping fee.
  
- 👤 **Customer**
  - Can add products to a cart with quantity checks.
  - Can perform checkout with full validation (empty cart, stock, balance, expiration).
  - Receives a printed **Checkout Receipt** and **Shipping Notice**.
  
- 🚚 **ShippingService**
  - Handles all shippable products.
  - Outputs total shipping weight and itemized shipment details.

---

## 📄 Sample Output

```text
** Shipment notice **
TV					15000g
Cheese				2000g
Total package weight 17.0kg

** Checkout receipt **
1x TV						3000.0
2x Cheese					40.0
5x Mobile Scratch Card		50.0
----------------------
Subtotal		3090.0
Shipping		110.0
Amount			3200.0
