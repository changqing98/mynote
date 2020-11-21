import datetime
from typing import Text, List

import pymysql.cursors

default_db_config = {
    "host": 'localhost',
    "user": 'root',
    "password": 'gllue123',
    "db": 'fakehub'
}


class MysqlConnection:
    def __init__(self, **db_config):
        self.connection = self.get_mysql_onnection(**db_config)

    @staticmethod
    def get_mysql_onnection(**db_config):
        return pymysql.connect(**db_config)

    def run_sql(self, sql: Text) -> List:
        cursor = self.connection.cursor(cursor=pymysql.cursors.DictCursor)
        cursor.execute(sql)
        res = [_ for _ in cursor.fetchall()]
        return res

    def run_sql_and_commit(self, sql: Text, values) -> List:
        cursor = self.connection.cursor(cursor=pymysql.cursors.DictCursor)
        try:
            cursor.executemany(sql, values)
            self.connection.commit()
        except:
            self.connection.rollback()

    def get_mysql_cursor(self):
        return self.connection.cursor(cursor=pymysql.cursors.DictCursor)


def main():
    conn = MysqlConnection(**default_db_config)
    now = datetime.datetime.now()
    today = datetime.date.today()
    yesterday = today - datetime.timedelta(days=1)
    print(now, today, yesterday.strftime("%Y-%m-%d 00:00:00"), sep='\n')
    start_time = yesterday.strftime("%Y-%m-%d 00:00:00")
    end_time = today.strftime("%Y-%m-%d 23:59:59")
    print(start_time, end_time)
    # result = conn.run_sql(
    #     f"select age, count(*) as sum from `user` where create_at between '{start_time}' and '{end_time}' group by age")

    x = []
    for i in range(200000):
        x.append(glist(i))

    sql = "insert into loginlog (user_id, `date`, client_id) values (%s,%s,%s)"
    conn.run_sql_and_commit(sql, x)


def glist(x):
    return (x, datetime.datetime.now(), x % 2000)


if __name__ == '__main__':
    main()
