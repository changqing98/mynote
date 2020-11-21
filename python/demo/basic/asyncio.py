import asyncio


async def do_print(i):
    print(f'Start to run:{i}')
    await asyncio.sleep(1000)
    print(f'End: {i}')

if __name__ == '__main__':
    asyncio.run(do_print(1))
