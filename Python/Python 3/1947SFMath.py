# a679b
def main():
    a = int(input("Enter number: "))

    a = 10 * a

    a = div8(a)
    a = div9(a)

    print("Total cost: " + str(a))
    print("Per item: " + str(a // 72))


def digitcount(a):
    digit = 0
    b = a
    while True:
        b = b // 10
        digit += 1
        if b == 0:
            return digit


def div8(a):
    for i in range(0, 10):
        b = a + i
        if b % 8 == 0:
            return b


def div9(a):
    tmp = digitcount(a)
    for i in range(0, 10):
        b = a + 10 ** tmp * i
        if b % 9 == 0:
            return b