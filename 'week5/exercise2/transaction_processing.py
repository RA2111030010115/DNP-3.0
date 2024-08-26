import datetime

def log_error(error_message):
    timestamp = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    with open("error_log.txt", "a") as file:
        file.write(f"[{timestamp}] {error_message}\n")

def validate_transaction_data(transaction_data):
    if not isinstance(transaction_data, dict):
        raise ValueError("Transaction data must be a dictionary.")
    
    required_keys = ['amount', 'type', 'account']
    for key in required_keys:
        if key not in transaction_data:
            raise ValueError(f"Missing required field: {key}")
    
    if not isinstance(transaction_data['amount'], (int, float)) or transaction_data['amount'] <= 0:
        raise ValueError("Invalid transaction amount. Must be a positive number.")
    
    if transaction_data['type'] not in ['deposit', 'withdrawal']:
        raise ValueError("Invalid transaction type. Must be 'deposit' or 'withdrawal'.")
    
    if not isinstance(transaction_data['account'], str) or not transaction_data['account']:
        raise ValueError("Invalid account information. Must be a non-empty string.")

def process_transaction(transaction_data):
    try:
        validate_transaction_data(transaction_data)
        # Simulate processing (e.g., updating a database, etc.)
        print(f"Processing {transaction_data['type']} of {transaction_data['amount']} to account {transaction_data['account']}")
        print("Transaction processed successfully.")
    except ValueError as ve:
        error_message = f"Validation Error: {ve}"
        log_error(error_message)
        print(error_message)
    except Exception as e:
        error_message = f"An unexpected error occurred: {e}"
        log_error(error_message)
        print(error_message)
    else:
        # This block runs if no exceptions occur
        print("Transaction completed without errors.")
    finally:
        # This block always runs, regardless of exceptions
        print("Transaction processing complete.")

def main():
    while True:
        print("\nEnter transaction details:")
        try:
            amount = float(input("Enter amount: "))
            transaction_type = input("Enter type (deposit/withdrawal): ").lower()
            account = input("Enter account number: ")
            transaction_data = {
                "amount": amount,
                "type": transaction_type,
                "account": account
            }
            process_transaction(transaction_data)
        except ValueError as ve:
            print(f"Input Error: {ve}")
        except Exception as e:
            log_error(f"Unexpected error during input: {e}")
            print(f"An unexpected error occurred: {e}")
        
        # Ask if the user wants to process another transaction
        another = input("Do you want to process another transaction? (yes/no): ").lower()
        if another != 'yes':
            break

if __name__ == "__main__":
    main()
