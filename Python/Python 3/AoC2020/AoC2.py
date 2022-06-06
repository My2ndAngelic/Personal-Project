import os


def main():
    with open(os.getcwd() + "/input/input2.txt", 'r') as f:
        lines = f.readlines()

    validpass1 = 0
    validpass2 = 0
    for s in lines:
        st = s.split()
        left = int(st[0].split("-")[0])
        right = int(st[0].split("-")[1])
        letter = st[1].split(":")[0]
        le_pass = st[2]
        if passwordchecker1(left, right, letter, le_pass):
            validpass1 += 1
        if passwordchecker2(left, right, letter, le_pass):
            validpass2 += 1

    print(validpass1)
    print(validpass2)


def passwordchecker1(left, right, letter, inputpass):
    return left <= inputpass.count(letter) <= right


def passwordchecker2(left, right, letter, inputpass):
    return (inputpass[left - 1] == letter) != (inputpass[right - 1] == letter)


main()
