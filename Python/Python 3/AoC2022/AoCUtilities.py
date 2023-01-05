def file_reader_to_string(filename):
    with open(filename, 'r') as f:
        lines = "".join(f.readlines())
    return lines


def file_reader_to_array(filename):
    with open(filename, 'r') as f:
        lines = f.readlines()
    return lines
