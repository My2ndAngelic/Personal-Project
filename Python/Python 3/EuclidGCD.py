def gcd(a, b):
    if (a <= 0) or (b <= 0):
        raise Exception("Sorry, we don't do that here.")
    else:
        while a != b:
            if a > b:
                a = a - b
            else:
                b = b - a
        return a


def main():
    a = int(input("Enter a: "))
    b = int(input("Enter b: "))
    c = gcd(a, b)
    print("GCD of " + str(a) + " and " + str(b) + " is: " + str(c))