-- Script SQL para crear la base de datos y tablas del CRUD Agenda
-- Ejecutar en MySQL Workbench o desde línea de comandos

-- Crear base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS agenda2;
USE agenda2;

-- Eliminar tablas si ya existen (para limpiar)
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS categoria;

-- Crear tabla CATEGORIA
CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Crear tabla PERSONA
CREATE TABLE persona (
    id_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insertar datos de ejemplo en CATEGORIA
INSERT INTO categoria (nombre) VALUES
    ('Amigos'),
    ('Familia'),
    ('Compañeros de trabajo'),
    ('Clientes'),
    ('Proveedores'),
    ('Estudios'),
    ('Deportes'),
    ('Ocio');

-- Insertar datos de ejemplo en PERSONA
INSERT INTO persona (nombre, edad, id_categoria) VALUES
    ('Carlos García', 25, 1),
    ('María López', 30, 1),
    ('Juan Rodríguez', 45, 2),
    ('Ana Martínez', 50, 2),
    ('Pedro Sánchez', 35, 2),
    ('Laura Fernández', 28, 3),
    ('Miguel Torres', 40, 3),
    ('Sofía Ruiz', 33, 4),
    ('Antonio Díaz', 55, 4),
    ('Carmen Moreno', 22, 5),
    ('Francisco Navarro', 38, 6),
    ('Isabel García', 27, 6),
    ('David López', 31, 7),
    ('Elena Martín', 29, 8),
    ('Roberto Sánchez', 42, NULL);

-- Consultas de verificación
SELECT '=== CATEGORÍAS ===' AS '';
SELECT * FROM categoria ORDER BY nombre;

SELECT '' AS '';
SELECT '=== PERSONAS ===' AS '';
SELECT p.id_persona, p.nombre, p.edad, c.nombre AS categoria
FROM persona p
LEFT JOIN categoria c ON p.id_categoria = c.id
ORDER BY p.nombre;
