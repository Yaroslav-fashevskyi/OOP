import math

class Fraction:
    def __init__(self, numerator, denominator):
        if denominator == 0:
            raise ValueError("Denominator cannot be zero!")
        self.numerator = numerator
        self.denominator = denominator

    def addition(self, other):
        # (a/b + c/d) = (ad + bc)/bd
        num = self.numerator * other.denominator + other.numerator * self.denominator
        den = self.denominator * other.denominator
        return Fraction(num, den).reductionFraction()

    def subtraction(self, other):
        # (a/b - c/d) = (ad - bc)/bd
        num = self.numerator * other.denominator - other.numerator * self.denominator
        den = self.denominator * other.denominator
        return Fraction(num, den).reductionFraction()

    def multiplication(self, other):
        # (a/b * c/d) = (ac)/(bd)
        num = self.numerator * other.numerator
        den = self.denominator * other.denominator
        return Fraction(num, den).reductionFraction()

    def division(self, other):
        # (a/b) / (c/d) = (a*d)/(b*c)
        if other.numerator == 0:
            raise ZeroDivisionError("Cannot divide by a fraction with numerator 0!")
        num = self.numerator * other.denominator
        den = self.denominator * other.numerator
        return Fraction(num, den).reductionFraction()

    def reductionFraction(self):
        # Скорочення дробу
        gcd_value = math.gcd(self.numerator, self.denominator)
        # Якщо знаменник від'ємний – виправляємо знак
        if self.denominator < 0:
            gcd_value = -gcd_value
        return Fraction(self.numerator // gcd_value, self.denominator // gcd_value)

    def __str__(self):
        return f"{self.numerator}/{self.denominator}"
