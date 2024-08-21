class DiscountStrategy:
    def apply_discount(self, order_amount):
        return order_amount  
class RegularDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount * 0.95
class PremiumDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount * 0.90
class VIPDiscount(DiscountStrategy):
    def apply_discount(self, order_amount):
        return order_amount * 0.80  
class Order:
    def __init__(self, customer_type, order_amount):
        self.customer_type = customer_type
        self.order_amount = order_amount
        self.discount_strategy = self.get_discount_strategy()

    def get_discount_strategy(self):
        if self.customer_type == 'regular':
            return RegularDiscount()
        elif self.customer_type == 'premium':
            return PremiumDiscount()
        elif self.customer_type == 'vip':
            return VIPDiscount()
        else:
            return DiscountStrategy()  
    def final_price(self):
        return self.discount_strategy.apply_discount(self.order_amount)

order1 = Order('regular', 1000)
order2 = Order('premium', 1000)
order3 = Order('vip', 1000)

print(f"Regular customer final price: RS {order1.final_price():.2f}")
print(f"Premium customer final price: RS {order2.final_price():.2f}")
print(f"VIP customer final price: RS {order3.final_price():.2f}")
