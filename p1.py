from phone import Phone

def main():

    phone = Phone()
    phone.brand = "Apple"
    phone.model = "iPhone 90"
    phone.price = 75812

    phone.display_info()

if __name__ == "__main__":
    main()
