//USUARIO
insert into usuario values ( 'Armenia', 12345, 'Activo', 1234, 3004556789, 'santiago', 'urlfoto')
insert into usuario values ( 'Cali', 12355, 'Activo', 3465, 3223332233, 'miguel', 'urlfoto')
insert into usuario values ( 'Bogota', 12377, 'Activo', 1289, 3202221125, 'luis', 'urlfoto')
insert into usuario values ( 'Manizales', 12348, 'Activo', 6547, 3150002266, 'ana', 'urlfoto')
insert into usuario values ( 'Pereira', 12349, 'Activo', 0909, 3105033322, 'julian', 'urlfoto')

//CUENTA
insert into usuario values (65345,  'santi@email.com', '123')
insert into usuario values (89355,  'manu@email.com', '128')
insert into usuario values (00377,  'juli@email.com', '127')
insert into usuario values (12548,  'dani@email.com', '163')
insert into usuario values (17269,  'luis@email.com', '143')

//ADMINISTRADOR
insert into administrador values ( 12345 )
insert into administrador values ( 22345 )
insert into administrador values ( 22322 )
insert into administrador values ( 22342 )
insert into administrador values ( 22341 )


//PACIENTE
insert into paciente values (12345, 'NuevaEps', 'O+',  '15-04-2002', 'Ninguna' )
insert into paciente values (33345, 'Ponal',  'A+', '25-02-2000', 'Ninguna')
insert into paciente values (12845, 'NuevaEps', 'O-', '20-04-2000', 'Polvo')
insert into paciente values (12215, 'NuevaEps', 'A-',  '15-04-2002', 'Ninguna')
insert into paciente values (12885, 'Medimas', 'O+', '15-05-2002', 'Acetaminophen')

//MEDICO
insert into medico values (11124, 'Urologo', '5pm', '8am')
insert into medico values (12224, 'Cardiologo', '1pm', '5am')
insert into medico values (17124, 'Pediatra', '12pm', '6am')
insert into medico values (11155, 'Urologo', '5pm', '9am',)
insert into medico values (23424, 'Otorrino', '10am', '2am')


//CITA
insert into cita values ( 12321, 'activo', 11124, 12345, '2022-04-15',  '2022-03-15',23456 , 'control' )
insert into cita values ( 12409, 'en proceso',12224, 33345, '2022-05-15', '2022-04-15',32154 , 'control' )
insert into cita values ( 12527, 'activo',17124, 12845, '2022-06-15', '2022-05-15',12094 , 'control' )
insert into cita values ( 12676, 'en proceso',11155, 12215, '2022-07-15', '2022-05-15',87645 , 'control' )
insert into cita values ( 12743, 'activo', 23424, 12885, '2022-08-15', '2022-06-15',43321 , 'control' )

//ATENCION
insert into atencion values ( 12345 , 23456 , 'Fiebre', 'Calor en el cuerpo y malestar general', 'Tomar ibuprofeno' )
insert into atencion values ( 12454 , 32154 , 'Vomito', 'Vomito a varias horas del dia', 'Suero intravenoso' )
insert into atencion values ( 12231 , 12094 , 'Desmayos', 'Desmayos al transcurrir el dia', 'Tratamiento intensivo' )
insert into atencion values ( 11131 , 87645 , 'Ninguno', '------------------', 'Control preventivo')
insert into atencion values ( 15055 , 43321 , 'Ceguera', 'Ve borroso de lejos', 'Remite al oftamologo' )

//DIA LIBRE
insert into dia_libre values ('2023-10-12', 11124, 12985)
insert into dia_libre values ('2023-11-12', 12224, 54321)
insert into dia_libre values ('2023-12-12', 17124, 08964)
insert into dia_libre values ('2023-03-12', 11155, 76234)
insert into dia_libre values ('2023-02-12', 23424, 76145)


//MEDICAMENTOS
insert into medicamentos values (123, '1 vez al dia', 'santa fe', 'acetaminophen')
insert into medicamentos values (133, '2 vez al dia', 'santa fe', 'loratadina')
insert into medicamentos values (163, '1 vez al dia', 'pfizer', 'acetaminophen')
insert into medicamentos values (183, '2 vez al dia', 'mk', 'ketotifeno')
insert into medicamentos values (193, '4 vez al dia', 'santa fe', 'lozartan')

//ORDENES MEDICAMENTOS
insert into ordenes_medicamentos values ('123', '2023-11-23', 123,12345)
insert into ordenes_medicamentos values ('143', '2023-11-24', 133,12454)
insert into ordenes_medicamentos values ('153', '2023-11-25',  163,12231)
insert into ordenes_medicamentos values ('163', '2023-09-23',  183,11131)
insert into ordenes_medicamentos values ('173', '2023-11-22',  193,15055)

//MENSAJE
insert into mensaje values (123, 65345, 001,  '2021-10-11','Necesito una cita urgente')
insert into mensaje values (122, 89355, 002,'2021-11-13','Necesito una cita urgente')
insert into mensaje values (124, 00377, 004,'2021-04-16','Necesito una cita urgente')
insert into mensaje values (125, 12548, 009,'2021-02-17','Necesito una cita urgente')
insert into mensaje values (126, 17269, 000,'2021-05-18','Necesito una cita urgente')



//PQRS
insert into pqrs values (001, 45612, 'Activo', '12-04-2023', 'Cita medica de urgencia', 'tipo',  234)
insert into pqrs values (002, 87609, 'Activo', '22-06-2023','Cita medica de urgencia', 'tipo', 284)
insert into pqrs values (004, 87123, 'Activo', '14-07-2023','Cita medica de urgencia',  'tipo', 974)
insert into pqrs values (009, 09569, 'Activo', '17-12-2023','Cita medica de urgencia',  'tipo', 784)
insert into pqrs values (000, 12854, 'Activo', '19-01-2023','Cita medica de urgencia',  'tipo', 254)

//RESULTADO EXAMENES
insert into resultado_examenes values (123,'12-04-2022', 00, 'Positivo' )
insert into resultado_examenes values (193,'16-04-2022', 01, 'Positivo' )
insert into resultado_examenes values (883,'17-04-2022', 02, 'Negativo' )
insert into resultado_examenes values (153,'19-04-2022', 03, 'Negativo' )
insert into resultado_examenes values (133,'11-04-2022', 04  'Positivo' )



