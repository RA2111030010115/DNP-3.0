import pickle

def read_contacts(filename):
    try:
        with open(filename, 'r') as file:
            contacts = file.readlines()
        return [contact.strip() for contact in contacts]
    except FileNotFoundError:
        print("Text file not found. Returning empty list.")
        return []
    except Exception as e:
        print(f"An error occurred: {e}")
        return []

def write_contacts(filename, contacts):
    try:
        with open(filename, 'w') as file:
            for contact in contacts:
                file.write(contact + '\n')
    except Exception as e:
        print(f"An error occurred: {e}")

def save_contacts_binary(filename, contacts):
    try:
        with open(filename, 'wb') as file:
            pickle.dump(contacts, file)
    except Exception as e:
        print(f"An error occurred: {e}")

def load_contacts_binary(filename):
    try:
        with open(filename, 'rb') as file:
            return pickle.load(file)
    except FileNotFoundError:
        print("Binary file not found. Returning empty list.")
        return []
    except Exception as e:
        print(f"An error occurred: {e}")
        return []

def add_contact(filename, contact, is_binary=False):
    if is_binary:
        contacts = load_contacts_binary(filename)
        contacts.append(contact)
        save_contacts_binary(filename, contacts)
    else:
        contacts = read_contacts(filename)
        contacts.append(contact)
        write_contacts(filename, contacts)

def remove_contact(filename, contact, is_binary=False):
    if is_binary:
        contacts = load_contacts_binary(filename)
        if contact in contacts:
            contacts.remove(contact)
            save_contacts_binary(filename, contacts)
        else:
            print("Contact not found.")
    else:
        contacts = read_contacts(filename)
        if contact in contacts:
            contacts.remove(contact)
            write_contacts(filename, contacts)
        else:
            print("Contact not found.")

def display_contacts(filename, is_binary=False):
    if is_binary:
        contacts = load_contacts_binary(filename)
    else:
        contacts = read_contacts(filename)
    for contact in contacts:
        print(contact)

def main():
    text_filename = 'contacts.txt'
    binary_filename = 'contacts_binary.dat'
    
    while True:
        print("\n1. Add Contact (Text)")
        print("2. Remove Contact (Text)")
        print("3. Display Contacts (Text)")
        print("4. Add Contact (Binary)")
        print("5. Remove Contact (Binary)")
        print("6. Display Contacts (Binary)")
        print("7. Exit")
        choice = input("Enter your choice: ")
        
        if choice == '1':
            contact = input("Enter contact name: ")
            add_contact(text_filename, contact, is_binary=False)
        elif choice == '2':
            contact = input("Enter contact name to remove: ")
            remove_contact(text_filename, contact, is_binary=False)
        elif choice == '3':
            display_contacts(text_filename, is_binary=False)
        elif choice == '4':
            contact = input("Enter contact name: ")
            add_contact(binary_filename, contact, is_binary=True)
        elif choice == '5':
            contact = input("Enter contact name to remove: ")
            remove_contact(binary_filename, contact, is_binary=True)
        elif choice == '6':
            display_contacts(binary_filename, is_binary=True)
        elif choice == '7':
            break
        else:
            print("Invalid choice.")

if __name__ == "__main__":
    main()
