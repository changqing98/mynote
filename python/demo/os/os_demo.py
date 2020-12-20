import os


def get_root_path():
    root_path = os.path.dirname(os.path.abspath(__file__))
    return root_path


if __name__ == '__main__':
    get_root_path()
    print(os.getcwd())
