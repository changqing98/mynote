create table goods
(
    goods_id    bigint      not null,
    `name`      varchar(50) not null,
    description varchar(50) not null,
    primary key (goods_id)
) charset = utf8mb4;

create table sku
(
    sku_id   bigint        not null,
    goods_id bigint        not null,
    price    decimal(9, 2) not null,
    stock    int           not null,
    primary key (sku_id)
) charset = utf8mb4;
