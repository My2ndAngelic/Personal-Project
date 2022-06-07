class Employee:
    def __init__(self, idNo, name, age):
        self.idNo = idNo
        self.name = name
        self.age = age

    def __str__(self):
        return f"Employee number {self.idNo}: {self.name}, {self.age} years old."
    

def main():
    print("Hello ", sep="", end="")
    ee = Employee(10, "John", 69)
    print(ee.__str__())


if __name__ == "__main__":
    main()
