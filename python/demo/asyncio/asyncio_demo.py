import asyncio


async def do_print(i):
    print(f'Start to run:{i}')
    await asyncio.sleep(3)
    print(f'End: {i}')


async def main():
    task1 = asyncio.create_task(do_print(1))
    task2 = asyncio.create_task(do_print(2))
    await asyncio.sleep(1)
    print("test print")
    await task1
    await task2


if __name__ == '__main__':
    asyncio.run(main())
