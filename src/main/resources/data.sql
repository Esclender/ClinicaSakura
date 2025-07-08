-- FerreteriaMas initial data script

-- Cargos (Job Positions) - Gestión de Almacén
INSERT INTO cargo (codigo, nombre_cargo, descripcion, estado) VALUES (1, 'Administrador de Sistema', 'Responsable general del sistema de gestión de almacén, supervisión de procesos y toma de decisiones estratégicas', 1);
INSERT INTO cargo (codigo, nombre_cargo, descripcion, estado) VALUES (2, 'Encargado de Compras', 'Responsable de la gestión de proveedores, evaluación de cotizaciones y autorización de compras de productos', 1);
INSERT INTO cargo (codigo, nombre_cargo, descripcion, estado) VALUES (3, 'Encargado de Almacén', 'Responsable del control de inventario, entradas y salidas de productos, gestión de stock mínimo y organización del almacén', 1);

-- Categorías de Productos
INSERT INTO categoriaproducto (codigo, nombre_categoria_producto, descripcion, estado) VALUES (1, 'Herramientas Manuales', 'Martillos, destornilladores, alicates, etc.', 1);
INSERT INTO categoriaproducto (codigo, nombre_categoria_producto, descripcion, estado) VALUES (2, 'Herramientas Eléctricas', 'Taladros, sierras, amoladoras, etc.', 1);
INSERT INTO categoriaproducto (codigo, nombre_categoria_producto, descripcion, estado) VALUES (3, 'Pinturas y Acabados', 'Látex, esmaltes, barnices, brochas, etc.', 1);
INSERT INTO categoriaproducto (codigo, nombre_categoria_producto, descripcion, estado) VALUES (4, 'Gasfitería', 'Tuberías de PVC, grifos, conexiones, etc.', 1);
INSERT INTO categoriaproducto (codigo, nombre_categoria_producto, descripcion, estado) VALUES (5, 'Electricidad', 'Cables, interruptores, tomacorrientes, focos LED, etc.', 1);
INSERT INTO categoriaproducto (codigo, nombre_categoria_producto, descripcion, estado) VALUES (6, 'Tornillería', 'Tornillos, tuercas, pernos, anclajes, etc.', 1);
INSERT INTO categoriaproducto (codigo, nombre_categoria_producto, descripcion, estado) VALUES (7, 'Materiales de Construcción', 'Cemento, arena, ladrillos, etc.', 1);

-- Tipos de Documento
INSERT INTO tipodocumento (codigo, nombre_tipo_documento, descripcion, estado) VALUES (1, 'DNI', 'Documento Nacional de Identidad', 1);
INSERT INTO tipodocumento (codigo, nombre_tipo_documento, descripcion, estado) VALUES (2, 'RUC', 'Registro Único de Contribuyentes', 1);
INSERT INTO tipodocumento (codigo, nombre_tipo_documento, descripcion, estado) VALUES (3, 'Carnet de Extranjería', 'Documento de identificación para extranjeros', 1);

-- Distritos (Algunos de Lima, Perú)
INSERT INTO distrito (codigo, nombre_distrito, descripcion, estado) VALUES (1, 'Miraflores', 'Distrito de Lima', 1);
INSERT INTO distrito (codigo, nombre_distrito, descripcion, estado) VALUES (2, 'San Isidro', 'Distrito de Lima', 1);
INSERT INTO distrito (codigo, nombre_distrito, descripcion, estado) VALUES (3, 'Santiago de Surco', 'Distrito de Lima', 1);
INSERT INTO distrito (codigo, nombre_distrito, descripcion, estado) VALUES (4, 'La Victoria', 'Distrito de Lima', 1);
INSERT INTO distrito (codigo, nombre_distrito, descripcion, estado) VALUES (5, 'San Borja', 'Distrito de Lima', 1);
INSERT INTO distrito (codigo, nombre_distrito, descripcion, estado) VALUES (6, 'Lince', 'Distrito de Lima', 1);
INSERT INTO distrito (codigo, nombre_distrito, descripcion, estado) VALUES (7, 'Cercado de Lima', 'Distrito de Lima', 1);

-- Proveedores
INSERT INTO proveedores (codigo, ruc, razonsocial, direccion, telefono, email, contacto, sitioweb, descripcion, estado, coddistrito) VALUES (1, '20100070970', 'Aceros Arequipa S.A.', 'Av. Enrique Meiggs 297', '015193000', 'ventas@aasa.com.pe', 'Ricardo Cilloniz', 'www.acerosarequipa.com', 'Proveedor de materiales de acero', 1, 7);
INSERT INTO proveedores (codigo, ruc, razonsocial, direccion, telefono, email, contacto, sitioweb, descripcion, estado, coddistrito) VALUES (2, '20100123456', 'PAVCO VINDUIT', 'Av. Los Frutales 248', '016143434', 'contacto@pavco.com.pe', 'Carlos Almendrades', 'www.pavco.com.pe', 'Proveedor de tuberías y conexiones', 1, 4);
INSERT INTO proveedores (codigo, ruc, razonsocial, direccion, telefono, email, contacto, sitioweb, descripcion, estado, coddistrito) VALUES (3, '20100234567', '3M Perú S.A.', 'Av. Canaval y Moreyra 641', '014302600', 'ventas.pe@3m.com', 'Maria Fernanda Lopez', 'www.3m.com.pe', 'Proveedor de productos industriales', 1, 2);
INSERT INTO proveedores (codigo, ruc, razonsocial, direccion, telefono, email, contacto, sitioweb, descripcion, estado, coddistrito) VALUES (4, '20100345678', 'Pinturas Vencedor', 'Av. Argentina 2855', '013155700', 'servicioalcliente@vencedor.com.pe', 'Luis Rodriguez', 'www.vencedor.com.pe', 'Proveedor de pinturas y acabados', 1, 7);

-- Empleados
INSERT INTO empleados (codigo, nombre, apepat, apemat, fechanac, nrodocumento, telefono, direccion, sexo, descripcion, estado, codcargo, coddistrito, codtipdoc) VALUES (1, 'Roberto', 'Sanchez', 'Martinez', '1985-03-15', '12345678', '014445566', 'Av. Principal 123', 'M', 'Administrador del sistema', 1, 1, 1, 1);
INSERT INTO empleados (codigo, nombre, apepat, apemat, fechanac, nrodocumento, telefono, direccion, sexo, descripcion, estado, codcargo, coddistrito, codtipdoc) VALUES (2, 'Carlos', 'Gomez', 'Perez', '1988-05-15', '23456789', '012223344', 'Calle Las Begonias 123', 'M', 'Encargado de compras', 1, 2, 2, 1);
INSERT INTO empleados (codigo, nombre, apepat, apemat, fechanac, nrodocumento, telefono, direccion, sexo, descripcion, estado, codcargo, coddistrito, codtipdoc) VALUES (3, 'Ana', 'Torres', 'Salas', '1992-11-20', '34567890', '015556677', 'Av. El Sol 456', 'F', 'Encargada de almacén', 1, 3, 3, 1);

-- Credenciales (usuario/clave). Contraseñas de desarrollo
-- rsanchez: admin123, cgomez: compras123, atorres: almacen123
INSERT INTO credenciales (codigo, usuario, clave, rol, descripcion, estado, codemp) VALUES (1, 'rsanchez', '$2a$10$N9qo8uLOickgx2ZMRZoMye.1YEtj5y/8LyNR7vG3p8jGb1vXC7g.', 'ADMIN', 'Credenciales de administrador', 1, 1);
INSERT INTO credenciales (codigo, usuario, clave, rol, descripcion, estado, codemp) VALUES (2, 'cgomez', '$2a$10$xN7/B7JhVX8QgSy8hPiXIe.1YUt2j5x/8RyNR7vG3k8jGb1vXC7h.', 'USER', 'Credenciales de usuario compras', 1, 2);
INSERT INTO credenciales (codigo, usuario, clave, rol, descripcion, estado, codemp) VALUES (3, 'atorres', '$2a$10$mK6/A8JhVX8QgSy8hPiXIe.1YUt2j5x/8RyNR7vG3k8jGb1vXC7i.', 'USER', 'Credenciales de usuario almacén', 1, 3);

-- Productos
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (1, 'Martillo de Uña 16 oz Truper', 'Cabeza de acero forjado y mango de madera.', 150, 12.50, 18.00, 1, 1);
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (2, 'Taladro Percutor 550W Bosch', 'Mandril de 13mm, velocidad variable y reversible.', 75, 95.00, 140.00, 1, 2);
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (3, 'Pintura Látex Vencedor Blanco 1 Galón', 'Lavable, para interiores y exteriores.', 200, 25.00, 35.00, 1, 3);
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (4, 'Tubo de Desagüe PVC 2" x 3m Pavco', 'Para sistemas de desagüe domiciliario.', 300, 8.50, 12.00, 1, 4);
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (5, 'Interruptor Simple Bticino', 'Línea Mátix, color blanco.', 500, 3.20, 5.50, 1, 5);
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (6, 'Tornillo Autorroscante Phillips 6x1"', 'Punta fina, para madera o metal.', 1000, 0.05, 0.10, 1, 6);
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (7, 'Bolsa de Cemento Sol 42.5 kg', 'Cemento Portland Tipo I.', 80, 22.00, 28.00, 1, 7);
INSERT INTO productos (codigo, nompro, descripcion, stock, preciocompra, precioventa, estado, codcat) VALUES (8, 'Alicate Universal 8" Stanley', 'Corte, apriete y sujeción.', 120, 15.00, 22.00, 1, 1); 