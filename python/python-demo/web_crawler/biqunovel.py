# -*- coding:UTF-8 -*-
import sys

import requests
from bs4 import BeautifulSoup


class downloader(object):

    def __init__(self):
        self.target = "http://www.biquw.com/book/3647/"
        self.names = []
        self.urls = []
        self.num = 0

    def get_urls(self):
        req = requests.get(url=self.target)
        html = req.text
        div_main_bf = BeautifulSoup(html, features="html.parser")
        div_main = div_main_bf.find_all('div', class_='book_list')
        as_bf = BeautifulSoup(str(div_main[0]), features="html.parser")
        ass = as_bf.find_all('a')
        self.num = len(ass)
        for a in ass:
            self.names.append(a.string)
            self.urls.append(self.target + a.get("href"))

    def get_content(self) -> str:
        req = requests.get(url=self.target)
        html = req.text
        bf = BeautifulSoup(html, features='html.parser')
        texts = bf.find_all('div', id='htmlContent')
        content = texts[0].text.replace('\xa0' * 8, ' ').replace("u'\n" * 2, "u'\n")
        return content

    @staticmethod
    def writer(name, path, text):
        write_flag = True
        with open(path, 'a', encoding='UTF-8') as f:
            f.write(name + '\n')
            f.write(text)
            f.write('\n\n')


if __name__ == '__main__':
    downloader = downloader()
    downloader.get_urls()
    for i in range(downloader.num):
        content = downloader.get_content(target=downloader.urls[i])
        downloader.writer(downloader.names[i], "./斗破苍穹.txt", content)
        sys.stdout.write("已下载:%.3f%%" % float(i / downloader.num) + '\r')
        sys.stdout.flush()
    print('《斗破苍穹》下载完成')
