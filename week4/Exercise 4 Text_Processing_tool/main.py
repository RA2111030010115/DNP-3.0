from text_processing_tool import count_words, find_unique_words, convert_to_uppercase

def main():
    text = input("Enter a text string: ")

    choice = input("Choose an option:\n1. Count Words\n2. Find Unique Words\n3. Convert to Uppercase\n")

    if choice == '1':
        print(f"Number of words: {count_words(text)}")
    elif choice == '2':
        print(f"Unique words: {find_unique_words(text)}")
    elif choice == '3':
        print(f"Uppercase text: {convert_to_uppercase(text)}")
    else:
        print("Invalid choice.")

if __name__ == "__main__":
    main()
