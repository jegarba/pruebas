INSERT IGNORE INTO `rol` (`id_rol`, `nombre`) VALUES (1, 'ADMINISTRADOR');
INSERT IGNORE INTO `rol` (`id_rol`, `nombre`) VALUES (2, 'AUDITOR');
INSERT IGNORE INTO `rol` (`id_rol`, `nombre`) VALUES (3, 'AUXILIAR');


INSERT IGNORE INTO `usuarios` (`id_usuario`, `activo`, `nombre`, `id_rol`) VALUES (1, '1', 'Jesus', 1);
INSERT IGNORE INTO `usuarios` (`id_usuario`, `activo`, `nombre`, `id_rol`) VALUES (2, '1', 'Maria', 2);
INSERT IGNORE INTO `usuarios` (`id_usuario`, `activo`, `nombre`, `id_rol`) VALUES (3, '1', 'Jose', 3);

