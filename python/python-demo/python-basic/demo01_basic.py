import collections
import pack.test as test

Student = collections.namedtuple('Student', ['name', 'age'])


class Demo:
    def __init__(self):
        self.value = 0

    @staticmethod
    def __test__(self):
        print("hello world")
        return 3

    def __add__(self, a):
        self.value += a

    def __len__(self):
        return self.value


def main():
    student = Student(name="test", age=21)
    print(student)
    if student is not None:
        print(student)
    demo = Demo()
    demo + 10
    print(len(demo))


if __name__ == '__main__':
    main()
    print(test.a)
    print("%s %d world" % ("hello", 1))
