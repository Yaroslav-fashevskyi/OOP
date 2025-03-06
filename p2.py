from fraction import Fraction


def main():
    f1 = Fraction(7, 9)
    f2 = Fraction(1, 2)

    print("Fraction 1:", f1)
    print("Fraction 2:", f2)

    print("Addition:", f1.addition(f2))
    print("Subtraction:", f1.subtraction(f2))
    print("Multiplication:", f1.multiplication(f2))
    print("Division:", f1.division(f2))


if __name__ == "__main__":
    main()
