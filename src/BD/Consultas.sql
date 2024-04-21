USE appsemestre;

SELECT
    a.codigo_institucional,
    a.contraseña,
    r.nombre AS rol
FROM
    Administrador a
JOIN
    Usuario u ON a.id_usuario = u.id
JOIN
    Rol r ON u.id_rol = r.id
WHERE
    a.codigo_institucional = '02210132001';