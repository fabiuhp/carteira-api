CREATE TABLE `transacao`
(
    `id`         int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `ticker`     varchar(6)      NOT NULL,
    `preco`      decimal(18, 2)  NOT NULL,
    `quantidade` int             NOT NULL,
    `tipo`       varchar(100)    NOT NULL,
    `data`       date            NOT NULL,
    `usuario_id` int             NOT NULL
);

CREATE TABLE `usuario`
(
    `id`    int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `nome`  varchar(100)    NOT NULL,
    `login` varchar(100)    NOT NULL,
    `senha` varchar(100)    NOT NULL
);

ALTER TABLE `transacao`
    ADD FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);