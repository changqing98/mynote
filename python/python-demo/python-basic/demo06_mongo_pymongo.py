import datetime

import pymongo

myclient = pymongo.MongoClient("mongodb://yechangqing.com:27017/")
mydb = myclient["glluecsm"]

mycol = mydb['user_activity']

if __name__ == '__main__':
    date = datetime.datetime.now()
    print(date)
    data = {
        'clientId': 6,
        'date': date
    }
    mycol.insert_one(data)
