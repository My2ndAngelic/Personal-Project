def main():
    x = 0
    y = 0
    move = input("Enter a move: ").lower()

    options = {
        "up": (x, y + 1),
        "down": (x, y - 1),
        "left": (x - 1, y),
        "right": (x + 1, y)
    }
    (x, y) = options[move]
    print(f"Current position: {x}, {y}")


if __name__ == "__main__":
    main()
