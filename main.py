from form import Form


def average_salary(forms):           # середня_зарплата
    total_salary = 0
    for form in forms:
        total_salary += form.salary
    return total_salary / len(forms) if forms else 0


def count_married(forms):               # кількість одружених людей у списку об'єктів Form
    married_count = 0
    for form in forms:
        if form.is_married:
            married_count += 1
    return married_count


def sort_forms_by_age(forms):           # сортувати_форми_за_віком
    return sorted(forms, key=lambda f: f.birth_year)


def sort_forms_by_name(forms):                   # сортувати форми за іменем
    return sorted(forms, key=lambda f: f.name)


def main():
    forms = [
        Form("Ярослав-1", 1900, "Футбол", 2, "Кращий гравець року", False, 1500.0),
        Form("Ярослав-2", 1995, "ChatGPT", 5, "Магістр gpt-шних наук", False, 1200.0)
    ]

    print("""
    Введіть дані третьої форми:
    """)

    name = input("Ім'я: ")
    birth_year = int(input("Рік народження: "))
    hobby = input("Захоплення: ")
    hobby_duration = int(input("Тривалість захоплення (років): "))
    achievements = input("Досягнення: ")
    is_married = input("Одружений (так/ні): ").strip().lower() == "так"
    salary = float(input("Зарплата: "))

    forms.append(Form(name, birth_year, hobby, hobby_duration, achievements, is_married, salary))

    print("*" * 50)
    print("""
    Інформація про всі анкети:
    """)

    for form in forms:
        form.about_myself()
    print("*" * 50)

    print("""
       Статистика:
       """)

    print(f"Середня зарплата: {average_salary(forms):.2f}")
    print(f"Кількість одружених людей: {count_married(forms)}")
    print()
    print("*" * 50)
    print("""
    Анкети після сортування за віком:
    """)
    for form in sort_forms_by_age(forms):
        form.about_myself()
    print("*" * 50)
    print("""
    Анкети після сортування за ім'ям:
    """)
    for form in sort_forms_by_name(forms):
        form.about_myself()


if __name__ == "__main__":
    main()
