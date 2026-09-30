# Order Management System (com.proyecto_gestion_pedidos)

## Overview
This project is an object-oriented Java web/backend application developed for managing customer orders, product catalogs (both physical and digital items), tax calculations (dynamic VAT rates), loyalty discounts, and automated invoice generation.

The codebase implements a clean, modular architecture using Java features such as abstract classes, interface inheritance, string templates, dynamic polymorphism, and UUID generation.

## Features
* **Customer Loyalty Discount Calculation:** Automated discount evaluation based on customer seniority and VIP status.
* **Polymorphic Product Catalog:**
  * **Digital Products (`ProductoDigital`):** Dynamic tax calculation based on tax categories (`GENERAL`, `REDUCIDO`, `SUPER`).
  * **Physical Products (`ProductoFisico`):** Weight tracking and destination-based shipping fee calculation (Spain, EU, International).
* **Order Processing (`Pedido`):** Shopping cart calculation with dynamic price updates and shipping fee handling.
* **Invoice Generation (`Tienda` & `Factura`):** Automated invoice generation with unique UUID identifiers, emission timestamps, and detailed itemized price breakdowns.

## Prerequisites
Before running or building this application, ensure you have the following installed:
* **Java Development Kit (JDK):** Version 17 or higher.
* **Build Tool:** Apache Maven or Gradle (optional, standard Java compilation supported).
* **IDE:** IntelliJ IDEA, Eclipse, or Visual Studio Code with Java Extension Pack.
* **Version Control:** Git 2.x or higher.

## Installation & Setup Instructions

1. **Clone the repository:**
   git clone [https://github.com/DiegoSotodelaFlor/Proyecto-Sistema-de-Gesti-n-de-Pedidos-Final.git](https://github.com/DiegoSotodelaFlor/Proyecto-Sistema-de-Gesti-n-de-Pedidos-Final.git)

Navigate to the project root directory:
cd "place where you cloned the repository"/Proyecto-Sistema-de-Gesti-n-de-Pedidos-Final
Compile the project:

Using javac directly:
javac -d bin src/com/proyecto_gestion_pedidos/*.java

Or using Maven (if applicable):
mvn clean compile

Run the Application:
Using Java CLI:
java -cp bin com.proyecto_gestion_pedidos.Main

Or using Maven:
mvn exec:java -Dexec.mainClass="com.proyecto_gestion_pedidos.Main"