CREATE TABLE places (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'Chave primária',
    name varchar(100) NOT NULL,
    latitude varchar(16),
    longitude varchar(16),
    address varchar(250),
    PRIMARY KEY (`id`)
);