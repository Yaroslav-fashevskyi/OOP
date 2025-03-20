class Form:
    def __init__(self, name, birth_year, hobby, hobby_duration, achievements, is_married, salary):
        self.name = name
        self.birth_year = birth_year
        self.hobby = hobby
        self.hobby_duration = hobby_duration
        self.achievements = achievements
        self.is_married = is_married
        self.salary = salary

    def about_myself(self):
        print("-" * 50)
        print(f"Ім'я: {self.name}")
        print(f"Рік народження: {self.birth_year}")
        print(f"Захоплення: {self.hobby} ({self.hobby_duration} років), досягнення: {self.achievements}")
        print(f"Одружений: {'Так' if self.is_married else 'Ні'}")
        print(f"Зарплата: {self.salary}")

