import xlrd


def main():
    file = xlrd.open_workbook("./query_result.xlsx")
    sheet = file.sheet_by_index(0)
    cols = sheet.col_values(0)
    cols.__delitem__(0)

    result = [int(_) for _ in cols]

    ids = tuple(result)

    print(len(ids))
    print(ids)


if __name__ == '__main__':
    main()
