USE appsemestre;

SELECT 
    u.id,
    u.nombre_completo,
    ti.nombre AS tipo_identificacion,
    u.numero_identificacion,
    u.correo_personal,
    u.telefono,
    u.fecha_nacimiento,
    u.edad,
    s.nombre AS sexo,
    e.nombre AS eps
FROM 
    Usuario u
    LEFT JOIN Tipo_identificacion ti ON u.id_tipo_identificacion = ti.id
    LEFT JOIN Sexo s ON u.id_sexo = s.id
    LEFT JOIN Eps e ON u.id_eps = e.id;


UPDATE Usuario
SET
    nombre_completo = 'Nuevo Nombre Completo',
    id_tipo_identificacion = (
        SELECT id FROM Tipo_identificacion WHERE nombre = 'Cedula'
    ),
    correo_personal = 'nuevo.correo@ejemplo.com',
    telefono = '1234567890',
    id_sexo = (
        SELECT id FROM Sexo WHERE nombre = 'Masculino'
    ),
    id_eps = (
        SELECT id FROM Eps WHERE nombre = 'E.P.S. SANITAS S.A.'
    )
WHERE id = (
    SELECT id_usuario 
    FROM Administrador 
    WHERE codigo_institucional = '02210132001'
);


SELECT 
    u.nombre_completo AS nombre,
    ti.nombre AS tipo_identificacion,
    u.numero_identificacion,
    u.correo_personal,
    u.telefono,
    DATE_FORMAT(u.fecha_nacimiento, '%Y-%m-%d') AS fecha_nacimiento,
    s.nombre AS sexo,
    e.nombre AS eps,
    a.codigo_institucional,
    a.correo_institucional,
    a.contraseña
FROM 
    Administrador a
JOIN 
    Usuario u ON a.id_usuario = u.id
JOIN 
    Tipo_identificacion ti ON u.id_tipo_identificacion = ti.id
JOIN 
    Sexo s ON u.id_sexo = s.id
JOIN 
    Eps e ON u.id_eps = e.id
WHERE 
    a.codigo_institucional = '02210132001';



Select *from Sexo;
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