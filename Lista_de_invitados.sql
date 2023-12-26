-- Crea la base de datos utilizando UTF-8
CREATE DATABASE IF NOT EXISTS lista_de_invitados CHARACTER SET utf8 COLLATE utf8_general_ci;

-- Selecciona la base de datos recién creada
USE lista_de_invitados;

-- Crea la tabla invitado con UTF-8
CREATE TABLE invitado (
    invitado_id INT AUTO_INCREMENT PRIMARY KEY,
    invitado_nombre VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci,
    invitado_estado VARCHAR(4) CHARACTER SET utf8 COLLATE utf8_general_ci
);

-- Inserta datos en la tabla invitado
INSERT INTO invitado VALUES
(1, "Noe Hidalgo", "alta"),
(2, "Wilfredo Reina", "baja"),
(3, "Ricardo Lopez", "alta"),
(4, "Agustin Lautaro", "alta");


-- SELECT invitado_id, invitado_nombre, invitado_estado FROM invitado WHERE invitado_estado = 'alta';