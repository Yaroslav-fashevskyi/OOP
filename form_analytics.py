from collections import Counter
from datetime import datetime

class FormAnalytics:
    def __init__(self, forms):
        self.forms = forms

    def total_forms(self):
        return len(self.forms)

    def count_forms_by_birth_year(self, year):
        count = 0
        for form in self.forms:
            if form.birth_year == year:
                count += 1
        return count

    def average_age(self):
        current_year = datetime.now().year
        total_age = 0
        for form in self.forms:
            total_age += current_year - form.birth_year
        return total_age / len(self.forms)

    def owners_above_avg_salary(self):
        total_salary = 0
        for form in self.forms:
            total_salary += form.salary
        avg_salary = total_salary / len(self.forms)
        threshold = avg_salary * 1.1
        result = []
        for form in self.forms:
            if form.salary > threshold:
                result.append(form.name)
        return result

    def top_three_hobbies(self):
        hobbies = Counter()
        for form in self.forms:
            hobbies[form.hobby] += 1
        return hobbies.most_common(3)

    def hobbies_sorted_by_length(self):
        hobbies = set()
        for form in self.forms:
            hobbies.add(form.hobby)
        return sorted(hobbies, key=len)

    def top_three_hobbies_by_marital_status(self, married):
        hobbies = Counter()
        for form in self.forms:
            if form.is_married == married:
                hobbies[form.hobby] += 1
        return hobbies.most_common(3)

    def average_salary(self):
        total_salary = 0
        for form in self.forms:
            total_salary += form.salary
        return total_salary / len(self.forms) if self.forms else 0

    def count_married(self):
        married_count = 0
        for form in self.forms:
            if form.is_married:
                married_count += 1
        return married_count

    def sort_forms_by_age(self):
        return sorted(self.forms, key=lambda f: f.birth_year)

    def sort_forms_by_name(self):
        return sorted(self.forms, key=lambda f: f.name)
