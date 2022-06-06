import os
import AoCUtilities


def seatID(s):
    highRow = int(127)
    lowRow = int(0)

    highColumn = int(7)
    lowColumn = int(0)

    for value in s[:-3]:
        if value == 'F':
            highRow = (highRow + lowRow) // 2
        else:
            lowRow = (highRow + lowRow + 1) // 2

    for value in s[-3:]:
        if value == 'L':
            highColumn = (highColumn + lowColumn) // 2
        else:
            lowColumn = (highColumn + lowColumn + 1) // 2

    return highRow * 8 + highColumn


def main():
    lines = AoCUtilities.fileReaderToArray(os.getcwd() + "/input/input5.txt")
    lines = list(map(lambda elem: elem[:-1], lines))
    sID = list(map(seatID, lines))
    print(lines)
    print(sID)

    test = "BFFFFFFRLL"
    print(seatID(test))

    temp = sID[0]
    for i in sID:
        if i > temp:
            temp = i
    print(temp)

    sID.sort()
    temp = sID[0]
    print(sID)

    low = sID[0]
    high = max(sID)
    for i in sID:
        if temp == i:
            temp += 1
        else:
            print(temp)
            break


if __name__ == '__main__':
    main()
