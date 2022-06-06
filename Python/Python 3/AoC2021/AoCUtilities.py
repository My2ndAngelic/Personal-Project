def fileReaderToString(filename):
    with open(filename, 'r') as f:
        lines = "".join(f.readlines())
    return lines


def fileReaderToArray(filename):
    with open(filename, 'r') as f:
        lines = f.readlines()
    return lines
