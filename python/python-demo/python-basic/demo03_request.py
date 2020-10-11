# -*- coding: UTF-8 -*-
import datetime

import requests


def main():
    startDate = datetime.date(2020, 2, 20)
    today = datetime.date.today()
    while startDate < today:
        print(startDate)
        res = requests.get("http://localhost:8080/v1/admin/userActivities/calculate:fix?date=%s" % startDate)
        print(res.text)
        startDate = startDate + datetime.timedelta(1)


if __name__ == '__main__':
    main()
