def main():
    num = int(input("Enter number:"))
    temp = num
    s = 0.0
    while num > 0:
        digit = num % 10
        num //= 10
        s += pow(digit, digit)

    if s == temp:
        print("Munchausen Number")
    else:
        print("Not Munchausen Number")


if __name__ == "__main__":
    main()