# -*- coding: UTF-8 -*-
import datetime


def main():
    start_date = datetime.date(2020, 2, 20)
    today = datetime.date.today()
    while start_date < today:
        print(start_date)
        start_date = start_date + datetime.timedelta(1)


if __name__ == '__main__':
    main()
