class BankAccount:
    def __init__(self, account_number, owner_name, owner_age, initial_balance=0):

        self.__account_number = account_number
        self.__balance = initial_balance
        self.__transaction_history = {}
        self.__owner = {"name": owner_name, "age": owner_age}
        self.__transaction_counter = 0

    # Геттери та сеттери для приватних цих штук
    def get_account_number(self):
        return self.__account_number

    def get_balance(self):
        return self.__balance

    def get_transaction_history(self):

        return self.__transaction_history.copy()

    def get_owner(self):

        return self.__owner.copy()

    def set_owner(self, name, age):
        self.__owner["name"] = name
        self.__owner["age"] = age
        self.__record_transaction("Редагування інформації про власника", None)

    def deposit(self, amount):
        if amount > 0:
            self.__balance += amount
            self.__record_transaction("Поповнення рахунку", amount)
        else:
            print("Сума поповнення має бути позитивною.")

    def withdraw(self, amount):
        if amount <= 0:
            print("Сума зняття має бути позитивною.")
        elif amount > self.__balance:
            print("Недостатньо коштів на рахунку.")
        else:
            self.__balance -= amount
            self.__record_transaction("Зняття коштів", amount)

    def __record_transaction(self, transaction_type, amount):
        self.__transaction_counter += 1
        self.__transaction_history[self.__transaction_counter] = {
            "type": transaction_type,
            "amount": amount,
            "balance": self.__balance
        }
    def view_transaction_history(self):
        return self.get_transaction_history()


class Bank:
    def __init__(self):
        # це  словник для зберігання рахунків: ключ = номер рахунку, значення = обєкт BankAccount
        self.__accounts = {}

    def create_account(self, account_number, owner_name, owner_age, initial_balance=0):
        if account_number in self.__accounts:
            print(f"Рахунок з номером {account_number} вже існує.")
        else:
            account = BankAccount(account_number, owner_name, owner_age, initial_balance)
            self.__accounts[account_number] = account
            print(f"Рахунок {account_number} створено.")

    # Метод для отримання рахунку за номером
    def get_account(self, account_number):
        return self.__accounts.get(account_number, None)

    def list_accounts(self):
        print("Список рахунків:")
        for acc in self.__accounts.values():
            owner_info = acc.get_owner()
            print(f"Номер: {acc.get_account_number()}, Власник: {owner_info['name']}, Баланс: {acc.get_balance()}")

    def transfer(self, from_account_number, to_account_number, amount):
        from_acc = self.get_account(from_account_number)
        to_acc = self.get_account(to_account_number)
        if from_acc is None or to_acc is None:
            print("Один з рахунків не існує.")
        else:
            if from_acc.get_balance() >= amount:
                from_acc.withdraw(amount)
                to_acc.deposit(amount)
                print(f"Переказано {amount} з рахунку {from_account_number} на рахунок {to_account_number}.")
            else:
                print("Недостатньо коштів для переказу.")


class Main:
    @staticmethod
    def run():
        bank = Bank()


        bank.create_account("001", "Yaroslav F", 17, 1000)
        bank.create_account("002", "Yaroslav FF", 22, 500)


        account1 = bank.get_account("001")
        account2 = bank.get_account("002")


        print("\nПочатковий баланс:")
        print(f"Рахунок {account1.get_account_number()} - Баланс: {account1.get_balance()}")
        print(f"Рахунок {account2.get_account_number()} - Баланс: {account2.get_balance()}")


        account1.deposit(200)

        account2.withdraw(100)


        account1.set_owner("Yaroslav F", 31)


        bank.transfer("001", "002", 300)


        print("\nОновлений список рахунків:")
        bank.list_accounts()


        print("\nІсторія транзакцій для рахунку 001:")
        history = account1.view_transaction_history()
        for trans_id, details in history.items():
            print(f"Транзакція {trans_id}: {details}")


if __name__ == "__main__":
    Main.run()
