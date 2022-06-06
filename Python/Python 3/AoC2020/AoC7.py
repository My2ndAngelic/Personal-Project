import os
import AoCUtilities


def main():
    lines = AoCUtilities.fileReaderToArray(os.getcwd() + "/input/input7.txt");
    for line in lines:
        lin = line.split('contain')
        print(lin)


if __name__ == '__main__':
    main()
