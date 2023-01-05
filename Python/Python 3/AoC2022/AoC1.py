import AoCUtilities


def main():
    output = AoCUtilities.file_reader_to_string("input/input1.txt")
    output2 = output.split('\n\n')
    output3 = [item.split('\n') for item in output2]
    output3[-1] = output3[-1][:-1] # for some reasons it adds an empty element here

    # output4 = [[int(y) for y in x] for x in output3]
    output4 = []
    for x in output3:
        temp = list(map(int, x))
        print(temp)
        output4.append(list(map(int, x)))


if __name__ == "__main__":
    main()
else:
    quit(69)
