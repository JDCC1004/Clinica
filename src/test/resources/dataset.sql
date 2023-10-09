//ADMINISTRADOR
insert into administrador values ('12345', 'Armenia', 'santi@email.com', '123')
insert into administrador values ('22345', 'Calarca', 'dani@email.com', '124')
insert into administrador values ('22322', 'Quimbaya', 'juli@email.com', '125')
insert into administrador values ('22342', 'Salento', 'mati@email.com', '128')
insert into administrador values ('22341', 'Tebaida', 'ana@email.com', '122')

//PACIENTE
insert into paciente values ('12345', 'Armenia', 'santi@email.com', '1212', 'NuevaEps', 'Ninguna', '15-04-2002', 'Santiago', '3002323322', 'O+')
insert into paciente values ('33345', 'Medellin', 'manu@email.com', '1214', 'Ponal', 'Ninguna', '25-02-2000', 'Manuel', '3002325522', 'A+')
insert into paciente values ('12845', 'Armenia', 'ana@email.com', '2312', 'NuevaEps', 'Polvo', '20-04-2000', 'Ana', '3002123322', 'O-')
insert into paciente values ('12215', 'Armenia', 'santi@email.com', '1812', 'NuevaEps', 'Ninguna', '15-04-2002', 'Santiago', '3222323322', 'A-')
insert into paciente values ('12885', 'Bogota', 'julie@email.com', '1712', 'Medimas', 'Acetaminophen', '15-05-2002', 'Julieta', '3112323322', 'O+')

//MEDICO
insert into medico values ('11124', 'AXM', 'daniel@email.com', '123', 'Urologo', '5pm', '8am', 'Daniel', '3224442233')
insert into medico values ('12224', 'MED', 'carlos@email.com', '113', 'Cardiologo', '1pm', '5am', 'Carlos', '3224442232')
insert into medico values ('17124', 'AXM', 'santi@email.com', '143', 'Pediatra', '12pm', '6am', 'Santiago', '3224442211')
insert into medico values ('11155', 'BOG', 'dani@email.com', '163', 'Urologo', '5pm', '9am', 'Daniela', '3223442233')
insert into medico values ('23424', 'CAL', 'juli@email.com', '173', 'Otorrino', '10am', '2am', 'Julian', '3227772233')

//USUARIO
insert into usuario values ('12345', 'Armenia', 'santi@email.com', '123' )
insert into usuario values ('12355', 'Cali', 'manu@email.com', '128' )
insert into usuario values ('12377', 'Bogota', 'juli@email.com', '127' )
insert into usuario values ('12348', 'Manizales', 'dani@email.com', '163' )
insert into usuario values ('12349', 'Pereira', 'luis@email.com', '143' )

//CITA
insert into cita values ('123', '2022-04-15', 'activo', '2022-03-15', '10am', 'control' )
insert into cita values ('124', '2022-05-15', 'en proceso', '2022-04-15', '9am', 'control' )
insert into cita values ('125', '2022-06-15', 'activo', '2022-05-15', '11am', 'control' )
insert into cita values ('126', '2022-07-15', 'en proceso', '2022-05-15', '8am', 'control' )
insert into cita values ('127', '2022-08-15', 'activo', '2022-06-15', '7am', 'control' )

//ATENCION MEDICA
insert into atencion_medica values ('123', 'Fiebre', '2022-10-12', 'Calor en el cuerpo y malestar general', 'Tomar ibuprofeno', '01' )
insert into atencion_medica values ('124', 'Vomito', '2022-10-22', 'Vomito a varias horas del dia', 'Suero intravenoso', '02' )
insert into atencion_medica values ('122', 'Mareos', '2021-09-15', 'Desmayos al transcurrir el dia', 'Tratamiento intensivo', '03' )
insert into atencion_medica values ('111', 'Ninguno', '2022-12-30', '------------------', 'Control preventivo', '04' )
insert into atencion_medica values ('150', 'Seguera leve', '2023-11-21', 'Ve borroso de lejos', 'Remite al oftamologo', '05' )

//DIA LIBRE
insert into dia_libre values ('123', '2023-10-12', '123456')
insert into dia_libre values ('133', '2023-11-12', '123436')
insert into dia_libre values ('143', '2023-12-12', '123446')
insert into dia_libre values ('123', '2023-03-12', '113446')
insert into dia_libre values ('113', '2023-02-12', '133446')

//MEDICAMENTOS
insert into medicamentos values ('123', '1 vez al dia', 'santa fe', 'acetaminophen')
insert into medicamentos values ('133', '2 vez al dia', 'santa fe', 'loratadina')
insert into medicamentos values ('163', '1 vez al dia', 'pfizer', 'acetaminophen')
insert into medicamentos values ('183', '2 vez al dia', 'mk', 'ketotifeno')
insert into medicamentos values ('193', '4 vez al dia', 'santa fe', 'lozartan')

//MENSAJE
insert into mensaje values ('123', '2021-10-11','Necesito una cita urgente', '012', '12345')
insert into mensaje values ('122', '2021-11-13','Necesito una cita urgente', '014', '12355')
insert into mensaje values ('124', '2021-04-16','Necesito una cita urgente', '016', '12335')
insert into mensaje values ('125', '2021-02-17','Necesito una cita urgente', '017', '12335')
insert into mensaje values ('126', '2021-05-18','Necesito una cita urgente', '018', '12325')

//ORDENES MEDICAMENTOS
insert into ordenes_medicamentos values ('123', '2023-11-23', 'si', '1234','4321')
insert into ordenes_medicamentos values ('143', '2023-11-24', 'si', '1774','6321')
insert into ordenes_medicamentos values ('153', '2023-11-25', 'no', '1224','7321')
insert into ordenes_medicamentos values ('163', '2023-09-23', 'no', '1334','8321')
insert into ordenes_medicamentos values ('173', '2023-11-22', 'si', '1884','9321')

//PQRS
insert into pqrs values ('001', 'Cita medica de urgencia', 'Activo', '12-04-2023','234')
insert into pqrs values ('002', 'Cita medica de urgencia', 'Activo', '22-06-2023','284')
insert into pqrs values ('004', 'Cita medica de urgencia', 'Activo', '14-07-2023','974')
insert into pqrs values ('009', 'Cita medica de urgencia', 'Activo', '17-12-2023','784')
insert into pqrs values ('000', 'Cita medica de urgencia', 'Activo', '19-01-2023','254')

//RESULTADO EXAMENES
insert into resultado_examenes values ('123','12-04-2022', 'Positivo', '00')
insert into resultado_examenes values ('193','16-04-2022', 'Positivo', '01')
insert into resultado_examenes values ('883','17-04-2022', 'Negativo', '02')
insert into resultado_examenes values ('153','19-04-2022', 'Negativo', '03')
insert into resultado_examenes values ('133','11-04-2022', 'Positivo', '04')



