
def test(func) -> str:
    def fn(*args, **kw):
        print(args, kw)
        print("Hello")
    return fn

@test
def do_something(s: str):
    print("Hello World")


if __name__ == "__main__":
   do_something("HeiHei", my = "changqing")