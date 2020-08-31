
class QueueByTwoStacks:
    def replacespace(self, s: str) -> str:
        result = []
        for i in s:
            if i == ' ':
                result.append("%20")
            else:
                result.append(i)
        return "".join(result)


if __name__ == '__main__':
    case1 = "Hello world"

    print(Main05().replacespace(case1))
