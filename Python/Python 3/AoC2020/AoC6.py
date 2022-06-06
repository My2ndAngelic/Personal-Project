import AoCUtilities
import os


def main():
    lines = AoCUtilities.fileReaderToArray(os.getcwd() + "/input/input6.txt")
    lines = list(map(lambda elem: elem[:-1], lines))
    lines.append('')

    # Part 1
    output = ""
    temp1 = []
    for line in lines:
        if line != "":
            output += line
        else:
            temp1.append(output)
            output = ""
    counter = 0
    temp11 = []
    for i in range(len(temp1)):
        my_str = temp1[i]
        my_list = []
        for j in my_str:
            if not (j in my_list):
                my_list.append(j)
        newStr = ''.join(my_list)
        temp11.append(newStr)
    for i in temp11:
        counter += len(i)
    print(counter)

    # Part 2
    temp1 = []
    counter2 = 0
    for line in lines:
        if line == '':
            tempString = temp1[0]
            for j in tempString:
                counter = 0
                for k in range(len(temp1)):
                    if j in temp1[k]:
                        counter += 1
                if counter == len(temp1):
                    counter2 += 1
            print(temp1, counter2)
            temp1 = []
        else:
            temp1.append(line)
    print(counter2)


if __name__ == '__main__':
    main()
