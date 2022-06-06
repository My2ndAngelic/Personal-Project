import os
import itertools


def main():
    lines = []
    with open(os.getcwd() + "/input/input1.txt", 'r') as f:
        for line in f.readlines():
            lines.append(int(line.rstrip('\n')))
            f.close()
    print(lines)

    # part 1
    for i, j in itertools.combinations(lines, 2):
        if i + j == 2020:
            print(i, "+", j, "=", i + j)
            print(i * j)
            break

    # part 2
    for i, j, k in itertools.combinations(lines, 3):
        if i + j + k == 2020:
            print(i, "+", j, "+", k, "=", i + j + k)
            print(i * j)
            break


main()
