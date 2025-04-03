from form import Form
from form_analytics import FormAnalytics

def main():
    forms = [
        Form("Ярослав-1", 1900, "Футбол", 2, "Кращий гравець року", False, 1500.0),
        Form("Ярослав-2", 1995, "ChatGPT", 5, "Магістр gpt-шних наук", False, 1200.0),

        # generated
        Form("Імя", 1985, "Футбол", 10, "Чемпіон області", True, 2500.0),
        Form("Петро", 1975, "Біг", 4, "Переможець марафону", True, 3200.0),
        Form("Олександр", 1990, "Футбол", 6, "Кубок регіону", False, 2700.0),
        Form("Alex", 1988, "Читання", 8, "100 прочитаних книг", True, 2200.0),
        Form("Ahmet", 1992, "Немає", 3, "Нема", False, 1800.0),
    ]

    analytics = FormAnalytics(forms)

    print("""Кількість зібраних анкет:""", analytics.total_forms())
    print()
    print("Кількість власників форм за 1990 рік:", analytics.count_forms_by_birth_year(1990))
    print()
    print("Середній вік власників:", analytics.average_age())
    print()
    print("Власники із зарплатою вище середньої на 10%:", analytics.owners_above_avg_salary())
    print()
    print("Топ 3 найпопулярніших захоплень:", analytics.top_three_hobbies())
    print()
    print("Захоплення, відсортовані за довжиною:", analytics.hobbies_sorted_by_length())
    print()
    print("Топ 3 захоплення одружених:", analytics.top_three_hobbies_by_marital_status(True))
    print()
    print("Топ 3 захоплення неодружених:", analytics.top_three_hobbies_by_marital_status(False))
    print()
    print("Середня зарплата:", analytics.average_salary())
    print()
    print("Кількість одружених людей:", analytics.count_married())
    print()
    print("""
    Анкети після сортування за віком:
    """)
    for form in analytics.sort_forms_by_age():
        form.about_myself()

    # ps сортування не за українським алфавітом а  Unicode-кодами
    print("""
    Анкети після сортування за іменем:
    """)
    for form in analytics.sort_forms_by_name():
        form.about_myself()

if __name__ == "__main__":
    main()
