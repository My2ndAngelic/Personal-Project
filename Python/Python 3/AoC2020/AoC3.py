import os


def main():
    with open(os.getcwd() + "/input/input3.txt", 'r') as f:
        lines = f.readlines()
        lines = list(map(lambda elem: elem[:-1], lines))

        j = 0
        count = 0
        for i in range(len(lines)):
            if j >= len(lines[i]):
                j = j % len(lines[i])
            if lines[i][j] == '#':
                count += 1
            j += 3
        print(count)

main()
