CREATE TABLE `roki`.`users`
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    email      VARCHAR(100) NOT NULL UNIQUE,
    blogUrl    VARCHAR(255) NOT NULL,
    avatarUrl  VARCHAR(255) NOT NULL,
    auth_token VARCHAR(200) NULL,
    role       VARCHAR(30)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `roki`.`posts`
(
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    title     VARCHAR(200) NOT NULL,
    content   TEXT         NOT NULL,
    version   INT          NOT NULL DEFAULT 1,
    createdAt DATETIME     NULL     DEFAULT CURRENT_TIMESTAMP,
    updatedAt DATETIME     NULL     DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `roki`.`contributes_logs`
(
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    email   BIGINT       NOT NULL,
    title   VARCHAR(255) NOT NULL,
    content TEXT         NULL,
    postId  BIGINT       NOT NULL,
    postUrl VARCHAR(255) NOT NULL COMMENT 'Join 을 하지 않고 POST 를 보여주기 위한 용도',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;