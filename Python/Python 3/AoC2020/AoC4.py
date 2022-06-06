import os


def isFieldExist(s, fieldname):
    return fieldname in s


def getField(s, fieldname):
    sa = s.split(" ")
    if isFieldExist(s, fieldname):
        for value in sa:
            if fieldname in value:
                return value.split(":")[1]
    return None


def isValidPassportPart1(s):
    return isFieldExist(s, 'byr') and \
           isFieldExist(s, 'iyr') and \
           isFieldExist(s, 'eyr') and \
           isFieldExist(s, 'hgt') and \
           isFieldExist(s, 'hcl') and \
           isFieldExist(s, 'ecl') and \
           isFieldExist(s, 'pid')


def isValidBirthYear(s):
    try:
        y = int(getField(s, 'byr'))
        return 1920 <= y <= 2002
    except Exception:
        return False


def isValidIssueYear(s):
    try:
        y = int(getField(s, 'iyr'))
        return 2010 <= y <= 2020
    except Exception:
        return False


def isValidExpirationYear(s):
    try:
        y = int(getField(s, 'eyr'))
        return 2020 <= y <= 2030
    except Exception:
        return False


def isValidHeight(s):
    a = getField(s, 'hgt')
    if a:
        if len(a) == 4:
            if a[2] == 'i' and a[3] == 'n':
                return 59 <= int(a[:2]) <= 76
        elif len(a) == 5:
            if a[3] == 'c' and a[4] == 'm':
                return 150 <= int(a[:3]) <= 193


def isValidHairColor(s):
    a = getField(s, 'hcl')
    if a:
        a = a.lower()
        if len(a) == 7 and a.startswith('#'):
            for c in a[1:]:
                if c not in "0123456789abcdef":
                    return False
            return True
    return False


def isValidEyeColor(s):
    return getField(s, 'ecl') in ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']


def isValidPassportNumber(s):
    a = getField(s, 'pid')
    return a and len(a) == 9 and a.isdigit()


def isValidPassportPart2(s):
    return isValidBirthYear(s) and \
           isValidIssueYear(s) and \
           isValidExpirationYear(s) and \
           isValidHeight(s) and \
           isValidHairColor(s) and \
           isValidEyeColor(s) and \
           isValidPassportNumber(s)


def main():
    with open(os.getcwd() + "/input/input4.txt", 'r') as f:
        lines = "".join(f.readlines())

    passid = lines.split("\n\n")
    for i in range(len(passid)):
        passid[i] = passid[i].replace("\n", " ")

    count = 0

    for a in passid:
        if isValidPassportPart2(a):
            count += 1
    print(count)


if __name__ == '__main__':
    main()
