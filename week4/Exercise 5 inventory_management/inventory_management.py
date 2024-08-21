# List to store product names
product_names = ["Laptop", "Phone", "Tablet"]

# Dictionary to store product details (name, quantity, price)
product_details = {
    "Laptop": {"quantity": 10, "price": 1000},
    "Phone": {"quantity": 25, "price": 500},
    "Tablet": {"quantity": 15, "price": 700}
}

# Tuple to represent immutable product data (name, price)
product_catalog = [
    ("Laptop", 1000),
    ("Phone", 500),
    ("Tablet", 700)
]

# Set to track unique product categories
product_categories = {"Electronics", "Accessories"}


#List Operations
def add_product(name):
    product_names.append(name)

def remove_product(name):
    if name in product_names:
        product_names.remove(name)
    else:
        print(f"{name} not found in the product list.")

def update_product(old_name, new_name):
    if old_name in product_names:
        index = product_names.index(old_name)
        product_names[index] = new_name
    else:
        print(f"{old_name} not found in the product list.")


#Dictionary Operations
def add_product_details(name, quantity, price):
    product_details[name] = {"quantity": quantity, "price": price}

def update_product_details(name, quantity=None, price=None):
    if name in product_details:
        if quantity is not None:
            product_details[name]["quantity"] = quantity
        if price is not None:
            product_details[name]["price"] = price
    else:
        print(f"{name} not found in product details.")

def delete_product_details(name):
    if name in product_details:
        del product_details[name]
    else:
        print(f"{name} not found in product details.")


#Tuples operations
def display_catalog():
    for product in product_catalog:
        print(f"Product: {product[0]}, Price: {product[1]}")


# Set Operations
def add_category(category):
    product_categories.add(category)

def remove_category(category):
    if category in product_categories:
        product_categories.remove(category)
    else:
        print(f"{category} not found in categories.")


def generate_price_report():
    sorted_products = sorted(product_details.items(), key=lambda item: item[1]['price'])
    for product, details in sorted_products:
        print(f"Product: {product}, Price: {details['price']}, Quantity: {details['quantity']}")
def find_products_in_price_range(min_price, max_price):
    result = {name for name, details in product_details.items() if min_price <= details['price'] <= max_price}
    return result



if __name__ == "__main__":
    
    add_product("Smartwatch")
    print("Product Names:", product_names)

    update_product("Tablet", "E-Reader")
    print("Product Names after update:", product_names)

    remove_product("Phone")
    print("Product Names after removal:", product_names)

    add_product_details("Smartwatch", 5, 200)
    print("Product Details after addition:", product_details)

    update_product_details("Laptop", price=1200)
    print("Product Details after update:", product_details)

    delete_product_details("Phone")
    print("Product Details after deletion:", product_details)

    print("Product Catalog:")
    display_catalog()

    add_category("Wearables")
    print("Product Categories after addition:", product_categories)

    remove_category("Accessories")
    print("Product Categories after removal:", product_categories)

    print("Price Report:")
    generate_price_report()

    products_in_range = find_products_in_price_range(500, 1000)
    print(f"Products in price range 500-1000: {products_in_range}")
