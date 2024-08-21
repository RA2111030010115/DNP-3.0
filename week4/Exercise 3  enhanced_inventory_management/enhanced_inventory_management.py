import threading
import time
import json

class Inventory:
    def __init__(self):
        self.items = {}

    def add_item(self, item_name, quantity):
        if item_name in self.items:
            self.items[item_name] += quantity
        else:
            self.items[item_name] = quantity
        print(f"Added {quantity} of {item_name}.")

    def remove_item(self, item_name, quantity):
        if item_name in self.items and self.items[item_name] >= quantity:
            self.items[item_name] -= quantity
            print(f"Removed {quantity} of {item_name}.")
        else:
            print(f"Insufficient stock of {item_name}.")

    def check_stock(self, item_name):
        return self.items.get(item_name, 0)

    def save_to_file(self, filename):
        try:
            with open(filename, 'w') as f:
                json.dump(self.items, f)
            print("Inventory saved to file.")
        except IOError as e:
            print(f"Error saving inventory to file: {e}")
    def load_from_file(self, filename):
        try:
            with open(filename, 'r') as f:
                self.items = json.load(f)
            print("Inventory loaded from file.")
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error loading inventory from file: {e}")
    def restocking_alert(self, threshold):
        while True:
            for item_name, quantity in self.items.items():
                if quantity < threshold:
                    print(f"Restocking alert: {item_name} is low in stock (only {quantity} left).")
            time.sleep(5)
inventory = Inventory()
inventory.add_item("Apples", 100)
inventory.add_item("Bananas", 50)
inventory.remove_item("Apples", 90)
inventory.save_to_file("inventory.json")
inventory.load_from_file("inventory.json")
print(f"Current inventory: {inventory.items}")

alert_thread = threading.Thread(target=inventory.restocking_alert, args=(20,))
alert_thread.daemon = True
alert_thread.start()

time.sleep(20)
