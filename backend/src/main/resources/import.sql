INSERT INTO tb_user (name, whatsapp, email, address, birth_date) VALUES ('João Silva', '123456789', 'joao.silva@example.com', 'Rua das Flores, 123', '1990-05-15');


CREATE TABLE tb_salon (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    whatsapp VARCHAR(50),
    img_url VARCHAR(255),
    opening_time TIME NOT NULL,
    closing_time TIME NOT NULL,
    service_interval INT NOT NULL
);

CREATE TABLE tb_salon_working_days (
    salon_id BIGINT NOT NULL,
    working_day VARCHAR(10) NOT NULL,
    PRIMARY KEY (salon_id, working_day),
    FOREIGN KEY (salon_id) REFERENCES tb_salon(id)
);

CREATE TABLE tb_salon_holidays (
    salon_id BIGINT NOT NULL,
    holiday_date DATE NOT NULL, -- Alteração para DATE
    PRIMARY KEY (salon_id, holiday_date),
    FOREIGN KEY (salon_id) REFERENCES tb_salon(id)
);


SHOW TABLES;
