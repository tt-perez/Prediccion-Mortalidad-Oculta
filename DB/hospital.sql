PGDMP         0                {            hospital    15.2    15.2 }    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    18423    hospital    DATABASE     �   CREATE DATABASE hospital WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE hospital;
                postgres    false            �           0    0    DATABASE hospital    ACL     +   GRANT CONNECT ON DATABASE hospital TO adm;
                   postgres    false    3553            �           1247    18425 
   enfermedad    DOMAIN     :   CREATE DOMAIN public.enfermedad AS character varying(50);
    DROP DOMAIN public.enfermedad;
       public          postgres    false            �           1247    18707    rango    TYPE     F   CREATE TYPE public.rango AS (
	inferior integer,
	superior integer
);
    DROP TYPE public.rango;
       public          postgres    false            �            1255    18426 #   actualizar_apache(integer, integer)    FUNCTION     '  CREATE FUNCTION public.actualizar_apache(idp integer, valorapache integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set apache = valorapache where id_pacuci = idp;
if not found then raise exception 'No se encuentran registros del paciente %',idp;
end if;
end; $$;
 J   DROP FUNCTION public.actualizar_apache(idp integer, valorapache integer);
       public          postgres    false            �            1255    18427 0   actualizar_clasifvia(integer, character varying)    FUNCTION     "  CREATE FUNCTION public.actualizar_clasifvia(idp integer, clasif character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set clasif_via = clasif where id_pacuci = idp;
if not found then raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 R   DROP FUNCTION public.actualizar_clasifvia(idp integer, clasif character varying);
       public          postgres    false            �            1255    18428 )   actualizar_edadpaciente(integer, integer)    FUNCTION       CREATE FUNCTION public.actualizar_edadpaciente(idpac integer, anhos integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update paciente set edad = anhos where id_pac = idpac;
if not found then raise exception 'No se encuentra el paciente %',idpac;
end if;
return;
end;$$;
 L   DROP FUNCTION public.actualizar_edadpaciente(idpac integer, anhos integer);
       public          postgres    false            �            1255    18429 -   actualizar_egreso(integer, character varying)    FUNCTION       CREATE FUNCTION public.actualizar_egreso(idp integer, sala character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set sala_egreso = sala where id_pacuci = idp;
if not found then raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 M   DROP FUNCTION public.actualizar_egreso(idp integer, sala character varying);
       public          postgres    false            �            1255    18430 %   actualizar_fechaegruci(integer, date)    FUNCTION       CREATE FUNCTION public.actualizar_fechaegruci(idp integer, fecha date) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set fechaegreuci = fecha where id_pacuci = idp;
if not found then raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 F   DROP FUNCTION public.actualizar_fechaegruci(idp integer, fecha date);
       public          postgres    false            �            1255    18431 %   actualizar_fechainguci(integer, date)    FUNCTION       CREATE FUNCTION public.actualizar_fechainguci(idp integer, fecha date) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set fechainguci = fecha where id_pacuci = idp;
if not found then raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 F   DROP FUNCTION public.actualizar_fechainguci(idp integer, fecha date);
       public          postgres    false            �            1255    18432 )   actualizar_fegresopaciente(integer, date)    FUNCTION       CREATE FUNCTION public.actualizar_fegresopaciente(idpac integer, fecha date) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update paciente set fechaegreso = fecha where id_pac=idpac;
if not found then raise exception 'No se encuentra el paciente %',idpac;
end if;
return;
end;$$;
 L   DROP FUNCTION public.actualizar_fegresopaciente(idpac integer, fecha date);
       public          postgres    false            �            1255    18433 *   actualizar_fingresopaciente(integer, date)    FUNCTION       CREATE FUNCTION public.actualizar_fingresopaciente(idpac integer, fecha date) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update paciente set fechaingreso = fecha where id_pac=idpac;
if not found then raise exception 'No se encuentra el paciente %',idpac;
end if;
return;
end;$$;
 M   DROP FUNCTION public.actualizar_fingresopaciente(idpac integer, fecha date);
       public          postgres    false            �            1255    18434 '   actualizar_limitacion(integer, boolean)    FUNCTION       CREATE FUNCTION public.actualizar_limitacion(idp integer, lim boolean) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set limitacion = lim where id_pacuci = idp;
if not found then  raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 F   DROP FUNCTION public.actualizar_limitacion(idp integer, lim boolean);
       public          postgres    false            �            1255    18435 /   actualizar_mortalidadpaciente(integer, numeric)    FUNCTION     "  CREATE FUNCTION public.actualizar_mortalidadpaciente(idpac integer, dato numeric) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update paciente set mort_oculta = dato where id_pac = idpac;
if not found then raise exception 'No se encuentra el paciente %',idpac;
end if;
return;
end;$$;
 Q   DROP FUNCTION public.actualizar_mortalidadpaciente(idpac integer, dato numeric);
       public          postgres    false            �            1255    18436 3   actualizar_razapaciente(integer, character varying)    FUNCTION       CREATE FUNCTION public.actualizar_razapaciente(idpac integer, piel character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update paciente set raza = piel where id_pac=idpac;
if not found then raise exception 'No se encuentra el paciente %',idpac;
end if;
return;
end;$$;
 U   DROP FUNCTION public.actualizar_razapaciente(idpac integer, piel character varying);
       public          postgres    false            �            1255    18437 9   actualizar_salamuertepaciente(integer, character varying)    FUNCTION     ,  CREATE FUNCTION public.actualizar_salamuertepaciente(idpac integer, sala character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update paciente set sala_muerte = sala where id_pac = idpac;
if not found then raise exception 'No se encuentra el paciente %',idpac;
end if;
return;
end;$$;
 [   DROP FUNCTION public.actualizar_salamuertepaciente(idpac integer, sala character varying);
       public          postgres    false            �            1255    18438 +   actualizar_sexopaciente(integer, character)    FUNCTION       CREATE FUNCTION public.actualizar_sexopaciente(idpac integer, sex character) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update paciente set sexo = sex where id_pac=idpac;
if not found then raise exception 'No se encuentra el paciente %',idpac;
end if;
return;
end;$$;
 L   DROP FUNCTION public.actualizar_sexopaciente(idpac integer, sex character);
       public          postgres    false                        1255    18439 7   actualizar_tcausa(public.enfermedad, character varying)    FUNCTION     #  CREATE FUNCTION public.actualizar_tcausa(nombrec public.enfermedad, tipo character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
update causa set tipo_causa = tipo where nombre = nombrec;
if not found then raise exception 'No se encuentra la causa %',nombrec;
end if;
end; $$;
 [   DROP FUNCTION public.actualizar_tcausa(nombrec public.enfermedad, tipo character varying);
       public          postgres    false    905                       1255    18440 &   actualizar_tiempovam(integer, integer)    FUNCTION       CREATE FUNCTION public.actualizar_tiempovam(idp integer, tiempo integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set tiempovam = tiempo where id_pacuci = idp;
if not found then raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 H   DROP FUNCTION public.actualizar_tiempovam(idp integer, tiempo integer);
       public          postgres    false                       1255    18441 +   actualizar_tvia(integer, character varying)    FUNCTION       CREATE FUNCTION public.actualizar_tvia(idp integer, tipo character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
update pacienteinguci set tipo_via = tipo where id_pacuci = idp;
if not found then raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 K   DROP FUNCTION public.actualizar_tvia(idp integer, tipo character varying);
       public          postgres    false            $           1255    18716 q   calcularmortalidad(integer, character varying, integer, character varying, character varying, character, integer)    FUNCTION     �  CREATE FUNCTION public.calcularmortalidad(apache integer, destino character varying, edad integer, motivo character varying, raza character varying, sexo character, tiempo integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $$declare resultado numeric;
begin
resultado=calcularxapache(apache)+calcularxdestino(destino)+calcularxedad(edad)+calcularxmotivo(motivo)+calcularxraza(raza)+calcularxsexo(sexo)+calcularxtiempo(tiempo);
resultado=resultado/7;
end;$$;
 �   DROP FUNCTION public.calcularmortalidad(apache integer, destino character varying, edad integer, motivo character varying, raza character varying, sexo character, tiempo integer);
       public          postgres    false                        1255    18712    calcularxapache(integer)    FUNCTION     W  CREATE FUNCTION public.calcularxapache(apach integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $$declare 
cantidad integer;
declare 
total integer;
declare vector rango;
begin 
if apach<=10 then 
vector.inferior=1;
vector.superior=apach+10;
else 
vector.inferior=apach-10;
vector.superior=apach+10;
end if;
select count(DISTINCT todofallecido.apache) into cantidad from todofallecido 
where todofallecido.apache>=vector.inferior and todofallecido.apache<=vector.superior;
select count(DISTINCT todofallecido.apache) into total from todofallecido;
return cantidad::numeric/total::numeric;
end;$$;
 5   DROP FUNCTION public.calcularxapache(apach integer);
       public          postgres    false            !           1255    18704 #   calcularxdestino(character varying)    FUNCTION     �  CREATE FUNCTION public.calcularxdestino(destino character varying) RETURNS character varying
    LANGUAGE plpgsql
    AS $$declare 
cantidad integer;
declare 
total integer;
begin 
select count(DISTINCT todofallecido.id_pac) into cantidad from todofallecido 
where todofallecido.sala_egreso=destino;
select count(DISTINCT todofallecido.id_pac) into total from todofallecido;
return cantidad::numeric/total::numeric;
end;$$;
 B   DROP FUNCTION public.calcularxdestino(destino character varying);
       public          postgres    false                       1255    18711    calcularxedad(integer)    FUNCTION     f  CREATE FUNCTION public.calcularxedad(edad integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $$declare 
cantidad integer;
declare 
total integer;
declare vector rango;
begin 
if edad<=10 then 
vector.inferior=1;
vector.superior=edad+10;
else 
vector.inferior=edad-10;
vector.superior=edad+10;
end if;
select count(DISTINCT evolucion.id_pac) into cantidad from evolucion 
where evolucion.edad>=vector.inferior and evolucion.edad<=vector.superior and evolucion.evolucion='fallecido';
select count(*) into total from evolucion where evolucion.evolucion='fallecido';
return cantidad::numeric/total::numeric;
end;$$;
 2   DROP FUNCTION public.calcularxedad(edad integer);
       public          postgres    false            "           1255    18700 "   calcularxmotivo(character varying)    FUNCTION     �  CREATE FUNCTION public.calcularxmotivo(motivo character varying) RETURNS numeric
    LANGUAGE plpgsql
    AS $$declare 
cantidad integer;
declare 
total integer;
begin 
select count(DISTINCT todofallecido.id_pac) into cantidad from todofallecido 
where todofallecido.tipo_causa=motivo;
select count(DISTINCT todofallecido.id_pac) into total from todofallecido;
return cantidad::numeric/total::numeric;
end;$$;
 @   DROP FUNCTION public.calcularxmotivo(motivo character varying);
       public          postgres    false                       1255    18699     calcularxraza(character varying)    FUNCTION     �  CREATE FUNCTION public.calcularxraza(raza character varying) RETURNS numeric
    LANGUAGE plpgsql
    AS $$declare 
cantidad integer;
declare 
total integer;
begin 
select count(*) into cantidad from evolucion 
where evolucion.raza=raza and evolucion.evolucion='fallecido';
select count(*) into total from evolucion where evolucion.evolucion='fallecido';
return cantidad::numeric/total::numeric;
end;$$;
 <   DROP FUNCTION public.calcularxraza(raza character varying);
       public          postgres    false                       1255    18698    calcularxsexo("char")    FUNCTION     �  CREATE FUNCTION public.calcularxsexo(sexo "char") RETURNS numeric
    LANGUAGE plpgsql
    AS $$declare 
cantidad integer;
declare 
total integer;
begin 
select count(*) into cantidad from evolucion 
where evolucion.sexo=sexo and evolucion.evolucion='fallecido';
select count(*) into total from evolucion where evolucion.evolucion='fallecido';
return cantidad::numeric/total::numeric;
end;
$$;
 1   DROP FUNCTION public.calcularxsexo(sexo "char");
       public          postgres    false                       1255    18714    calcularxtiempo(integer)    FUNCTION     �  CREATE FUNCTION public.calcularxtiempo(tiempo integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $$declare 
cantidad integer;
declare 
total integer;
declare 
vector rango;
begin
select count(DISTINCT todofallecido.id_pac) into cantidad from todofallecido 
where todofallecido.tiempovam<=tiempo+10;
select count(DISTINCT todofallecido.id_pac) into total from todofallecido;
return cantidad::numeric/total::numeric;
end;$$;
 6   DROP FUNCTION public.calcularxtiempo(tiempo integer);
       public          postgres    false            #           1255    18713    calcularxvia(character varying)    FUNCTION     �  CREATE FUNCTION public.calcularxvia(via character varying) RETURNS numeric
    LANGUAGE plpgsql
    AS $$
declare 
cantidad integer;
declare 
total integer;
begin 
select count(DISTINCT todofallecido.id_pac) into cantidad from todofallecido 
where todofallecido.tipo_via=via;
select count(DISTINCT todofallecido.id_pac) into total from todofallecido;
return cantidad::numeric/total::numeric;
end;
$$;
 :   DROP FUNCTION public.calcularxvia(via character varying);
       public          postgres    false                       1255    18442    cambiar_password(text, text)    FUNCTION     �   CREATE FUNCTION public.cambiar_password(usuario text, clave text) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
execute 'alter role ' ||usuario|| ' with password '|| quote_literal(clave);
end; $$;
 A   DROP FUNCTION public.cambiar_password(usuario text, clave text);
       public          postgres    false            �           0    0 3   FUNCTION cambiar_password(usuario text, clave text)    ACL     l   GRANT ALL ON FUNCTION public.cambiar_password(usuario text, clave text) TO administrador WITH GRANT OPTION;
          public          postgres    false    282                       1255    18443    crearcsvvivos(text)    FUNCTION     �   CREATE FUNCTION public.crearcsvvivos(ruta text) RETURNS void
    LANGUAGE plpgsql
    AS $$
 declare query text;
 begin
query:='copy (Select * from vistatodoslospacientes) to '''||ruta||''' DELIMITER '','' CSV HEADER;';  
execute query;
end;
$$;
 /   DROP FUNCTION public.crearcsvvivos(ruta text);
       public          postgres    false            �           0    0 !   FUNCTION crearcsvvivos(ruta text)    ACL     �   GRANT ALL ON FUNCTION public.crearcsvvivos(ruta text) TO administrador WITH GRANT OPTION;
GRANT ALL ON FUNCTION public.crearcsvvivos(ruta text) TO adm;
          public          postgres    false    284                       1255    18444 !   eliminar_causa(public.enfermedad)    FUNCTION     �   CREATE FUNCTION public.eliminar_causa(causaelim public.enfermedad) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
delete from causa where nombre = causaelim;
if not found then raise exception 'No se encuentra la causa %', causaelim;
end if;
end; $$;
 B   DROP FUNCTION public.eliminar_causa(causaelim public.enfermedad);
       public          postgres    false    905                       1255    18445 '   eliminar_diagnostico(public.enfermedad)    FUNCTION       CREATE FUNCTION public.eliminar_diagnostico(diagelim public.enfermedad) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
delete from diagnostico where enfermedad = diagelim;
if not found then raise exception 'No se encuentra el dagnostico %',diagelim;
end if;
end; $$;
 G   DROP FUNCTION public.eliminar_diagnostico(diagelim public.enfermedad);
       public          postgres    false    905                       1255    18446    eliminar_paciente(integer)    FUNCTION     I  CREATE FUNCTION public.eliminar_paciente(idp integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
delete from en_uci_se_realiza where id_pacdt = idp;
delete from paciente where id_pac = idp;
delete from pacientefallecido where id_pacf = idp;
delete from pacienteinguci where id_pacuci = idp;
delete from por_defuncion where id_pacd = idp;
delete from por_necropsia where id_pacn = idp;
delete from post_uci_se_realiza where id_pacpost = idp;
delete from utiliza_vam_por where id_pacp = idp;
if not found then raise exception 'No se encuentra el paciente %',idp;
end if;
end; $$;
 5   DROP FUNCTION public.eliminar_paciente(idp integer);
       public          postgres    false                       1255    18447 <   eliminar_procedimiento(public.enfermedad, character varying)    FUNCTION     X  CREATE FUNCTION public.eliminar_procedimiento(causa public.enfermedad, tipo character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
delete from procedimiento where causaproc = causa and tipo_causaproc = tipo;
if not found then raise exception 'No se encuentra el procedimiento con causa % de tipo %', causa, tipo;
end if;
end; $$;
 ^   DROP FUNCTION public.eliminar_procedimiento(causa public.enfermedad, tipo character varying);
       public          postgres    false    905                       1255    18448     eliminar_sala(character varying)    FUNCTION     �   CREATE FUNCTION public.eliminar_sala(nombre character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
delete from sala where especialidad = nombre;
if not found then raise exception 'No se encuentra la sala %',nombre;
end if;
end; $$;
 >   DROP FUNCTION public.eliminar_sala(nombre character varying);
       public          postgres    false                       1255    18449    fechas_pac_pacuci()    FUNCTION     C  CREATE FUNCTION public.fechas_pac_pacuci() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
if new.fechainguci >= (select fechaingreso from paciente where id_pac = new.id_pacuci)
then
return new;
else raise exception 'La fecha de ingreso a la UCI debe ser posterior a la fecha de ingreso al Hospital';
end if;
end; $$;
 *   DROP FUNCTION public.fechas_pac_pacuci();
       public          postgres    false            	           1255    18450 4   insertar_causa(public.enfermedad, character varying)    FUNCTION     �   CREATE FUNCTION public.insertar_causa(nombrec public.enfermedad, tipo character varying) RETURNS void
    LANGUAGE sql
    AS $$
insert into Causa values (nombrec,tipo)
$$;
 X   DROP FUNCTION public.insertar_causa(nombrec public.enfermedad, tipo character varying);
       public          postgres    false    905            
           1255    18451 '   insertar_diagnostico(public.enfermedad)    FUNCTION     �   CREATE FUNCTION public.insertar_diagnostico(diag public.enfermedad) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
insert into diagnostico values (diag);
end; $$;
 C   DROP FUNCTION public.insertar_diagnostico(diag public.enfermedad);
       public          postgres    false    905                       1255    18452 <   insertar_procedimiento(public.enfermedad, character varying)    FUNCTION     �   CREATE FUNCTION public.insertar_procedimiento(causa public.enfermedad, tipo character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
insert into procedimiento values(causa, tipo);
end; $$;
 ^   DROP FUNCTION public.insertar_procedimiento(causa public.enfermedad, tipo character varying);
       public          postgres    false    905                       1255    18453     insertar_sala(character varying)    FUNCTION     �   CREATE FUNCTION public.insertar_sala(nombre character varying) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin
insert into sala values(nombre);
end;$$;
 >   DROP FUNCTION public.insertar_sala(nombre character varying);
       public          postgres    false            %           1255    18454 D  insertarpaciente(character, character varying, date, date, numeric, character varying, integer, integer, boolean, date, date, character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying)    FUNCTION     &  CREATE FUNCTION public.insertarpaciente(sexop character, razap character varying, fechaingresop date, fechaegresop date, mort_ocultap numeric, sala_muertep character varying, edadp integer, apachep integer, limitacionp boolean, fechaingucip date, fechaegreuci date, sala_egresop character varying, tiempovamp integer, tipo_viap character varying, clasif_viap character varying, enfermedadpreucip character varying, causadefun character varying, tipo_causadefun character varying, causanecro character varying, tipo_causanecro character varying, enfermedadpostucip character varying, nombrecp character varying) RETURNS integer
    LANGUAGE plpgsql
    AS $$
declare 
cantidad integer;
idpaciente integer;
fila record;
verifico boolean;
mortalidad numeric;
tipo character varying;
begin 
select tipo_causa into tipo from causa where causa.nombre=nombrecp;
mortalidad=calcularmortalidad(apachep,
	sala_egresop,
	edadp,
tipo,
	razap,
	sexop,
	tiempovamp);
if sala_muertep is null then 
        select * into verifico from public.verificarvivo(sexop, razap, fechaingresop, fechaegresop, mort_ocultap, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, enfermedadpostucip, nombrecp);
    --retorna true si si se puede anadir
     if verifico=true then
        select count(*) into cantidad from  paciente;
        if cantidad=0 then
       insert into todovivo values(1,sexop, razap, fechaingresop, fechaegresop, mort_ocultap, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, enfermedadpostucip, nombrecp);
	   return 1;
      else
       SELECT MAX(id_pac) into  idpaciente from paciente;
       if(idpaciente=cantidad) then
            insert into todovivo values(idpaciente+1,sexop, razap, fechaingresop, fechaegresop, mort_ocultap, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, enfermedadpostucip, nombrecp);
            return idpaciente+1;
       else
             cantidad=0;
              for fila in select * from paciente order by id_pac loop
              cantidad=cantidad+1;
              continue when cantidad=fila.id_pac;
              insert into todovivo values(cantidad,sexop, razap, fechaingresop, fechaegresop, mort_ocultap, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, enfermedadpostucip, nombrecp);
              return cantidad;
              end loop;
       end if;
     end if;
     else
        raise exception 'Paciente ya existe';
	 end if;
else
     select * into verifico from public.verificarFallecido(sexop, razap, fechaingresop, fechaegresop, mort_ocultap, sala_muertep, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, causadefun, tipo_causadefun, causanecro, tipo_causanecro, enfermedadpostucip, nombrecp);
    if verifico=true then
     select count(*) into cantidad from  paciente;
   if cantidad=0 then
       insert into todofallecido values(1,sexop, razap, fechaingresop, fechaegresop, mort_ocultap, sala_muertep, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, causadefun, tipo_causadefun, causanecro, tipo_causanecro, enfermedadpostucip, nombrecp);
	   return 1;
    else
       SELECT MAX(id_pac) into  idpaciente from paciente;
       if(idpaciente=cantidad) then
            insert into todofallecido values(idpaciente+1,sexop, razap, fechaingresop, fechaegresop, mort_ocultap, sala_muertep, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, causadefun, tipo_causadefun, causanecro, tipo_causanecro, enfermedadpostucip, nombrecp);
            return idpaciente+1;
       else
             cantidad=0;
              for fila in select * from paciente order by id_pac loop
              cantidad=cantidad+1;
              continue when cantidad=fila.id_pac;
              insert into todofallecido values(cantidad,sexop, razap, fechaingresop, fechaegresop, mort_ocultap, sala_muertep, edadp, apachep, limitacionp, fechaingucip, fechaegreuci, sala_egresop, tiempovamp, tipo_viap, clasif_viap, enfermedadpreucip, causadefun, tipo_causadefun, causanecro, tipo_causanecro, enfermedadpostucip, nombrecp);
              return cantidad;
              end loop;
       end if;
     end if;
    else raise exception 'Paciente ya existe';
	 end if;
	  end if;
	 END;
$$;
 b  DROP FUNCTION public.insertarpaciente(sexop character, razap character varying, fechaingresop date, fechaegresop date, mort_ocultap numeric, sala_muertep character varying, edadp integer, apachep integer, limitacionp boolean, fechaingucip date, fechaegreuci date, sala_egresop character varying, tiempovamp integer, tipo_viap character varying, clasif_viap character varying, enfermedadpreucip character varying, causadefun character varying, tipo_causadefun character varying, causanecro character varying, tipo_causanecro character varying, enfermedadpostucip character varying, nombrecp character varying);
       public          postgres    false                       1255    18455 F  verificarfallecido(character, character varying, date, date, numeric, character varying, integer, integer, boolean, date, date, character varying, integer, character varying, character varying, public.enfermedad, public.enfermedad, character varying, public.enfermedad, character varying, public.enfermedad, public.enfermedad)    FUNCTION     �  CREATE FUNCTION public.verificarfallecido(sexop character, razap character varying, fechaingresop date, fechaegresop date, mort_ocultap numeric, sala_muertep character varying, edadp integer, apachep integer, limitacionp boolean, fechaingucip date, fechaegreucip date, sala_egresop character varying, tiempovamp integer, tipo_viap character varying, clasif_viap character varying, enfermedadpreucip public.enfermedad, causadefun public.enfermedad, tipo_causadefun character varying, causanecro public.enfermedad, tipo_causanecro character varying, enfermedadpostucip public.enfermedad, nombrecp public.enfermedad) RETURNS boolean
    LANGUAGE plpgsql
    AS $$
declare resultado integer;

begin
select id_pac into resultado from todofallecido where
      sexop=todofallecido.sexo and razap=todofallecido.raza and
    fechaingresop=todofallecido.fechaingreso and
    fechaegresop=todofallecido.fechaegreso and
    mort_ocultap=todofallecido.mort_oculta and
    sala_muertep=todofallecido.sala_muerte and
    edadp=todofallecido.edad and
apachep=todofallecido.apache and 
limitacionp=todofallecido.limitacion and
fechaingucip=todofallecido.fechainguci and 
fechaegreucip=todofallecido.fechaegreuci and 
sala_egresop=todofallecido.sala_egreso and 
tiempovamp=todofallecido.tiempovam and
	tipo_viap=todofallecido.tipo_via and 
	clasif_viap=todofallecido.clasif_via and
	enfermedadpreUcip=todofallecido.enfermedaduci 	and 
causaDefun=todofallecido.causad and 
tipo_causaDefun=todofallecido.tipo_causad and
	 causaNecro=todofallecido.causan and
	tipo_causaNecro=todofallecido.tipo_causan and 
	enfermedadpostUcip=todofallecido.enfermedadpost and 
	nombrecP=todofallecido.nombrec;
	if resultado is null then return true;
	else return false;
	end if;
	END;
$$;
 e  DROP FUNCTION public.verificarfallecido(sexop character, razap character varying, fechaingresop date, fechaegresop date, mort_ocultap numeric, sala_muertep character varying, edadp integer, apachep integer, limitacionp boolean, fechaingucip date, fechaegreucip date, sala_egresop character varying, tiempovamp integer, tipo_viap character varying, clasif_viap character varying, enfermedadpreucip public.enfermedad, causadefun public.enfermedad, tipo_causadefun character varying, causanecro public.enfermedad, tipo_causanecro character varying, enfermedadpostucip public.enfermedad, nombrecp public.enfermedad);
       public          postgres    false    905                       1255    18456 �   verificarvivo(character, character varying, date, date, numeric, integer, integer, boolean, date, date, character varying, integer, character varying, character varying, character varying, character varying, character varying)    FUNCTION       CREATE FUNCTION public.verificarvivo(sexop character, razap character varying, fechaingresop date, fechaegresop date, mort_ocultap numeric, edadp integer, apachep integer, limitacionp boolean, fechaingucip date, fechaegreucip date, sala_egresop character varying, tiempovamp integer, tipo_viap character varying, clasif_viap character varying, enfermedadpreucip character varying, enfermedadpostucip character varying, nombrecp character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$
declare identificador integer;
begin
select id_pac into identificador from todovivo where
      sexop=todovivo.sexo and razap=todovivo.raza and
    fechaingresop=todovivo.fechaingreso and
    fechaegresop=todovivo.fechaegreso and
    mort_ocultap=todovivo.mort_oculta and
    edadp=todovivo.edad and
apachep=todovivo.apache and limitacionp=todovivo.limitacion and
fechaingucip=todovivo.fechainguci and fechaegreucip=todovivo.fechaegreuci 
and sala_egresop=todovivo.sala_egreso and 
tiempovamp=todovivo.tiempovam and
	tipo_viap=todovivo.tipo_via and clasif_viap=todovivo.clasif_via 
	and enfermedadpreUcip=todovivo.enfermedaduci and
 enfermedadpostUcip=todovivo.enfermedadpost 
	and nombrecp=todovivo.nombrec;
	if identificador is null then return true;
	else return false;
	end if;
	end;
$$;
 �  DROP FUNCTION public.verificarvivo(sexop character, razap character varying, fechaingresop date, fechaegresop date, mort_ocultap numeric, edadp integer, apachep integer, limitacionp boolean, fechaingucip date, fechaegreucip date, sala_egresop character varying, tiempovamp integer, tipo_viap character varying, clasif_viap character varying, enfermedadpreucip character varying, enfermedadpostucip character varying, nombrecp character varying);
       public          postgres    false            �            1259    18457    causa    TABLE       CREATE TABLE public.causa (
    nombre public.enfermedad NOT NULL,
    tipo_causa character varying(20) NOT NULL,
    CONSTRAINT check_tipoc CHECK (((tipo_causa)::text = ANY (ARRAY[('respiratoria'::character varying)::text, ('no respiratoria'::character varying)::text])))
);
    DROP TABLE public.causa;
       public         heap    postgres    false    905            �            1259    18463    diagnostico    TABLE     O   CREATE TABLE public.diagnostico (
    enfermedad public.enfermedad NOT NULL
);
    DROP TABLE public.diagnostico;
       public         heap    postgres    false    905            �            1259    18468    paciente    TABLE     2  CREATE TABLE public.paciente (
    id_pac integer NOT NULL,
    sexo character(1) NOT NULL,
    raza character varying(8) NOT NULL,
    fechaingreso date NOT NULL,
    fechaegreso date,
    mort_oculta numeric,
    sala_muerte character varying(50),
    edad integer NOT NULL,
    CONSTRAINT check_raza CHECK (((raza)::text = ANY (ARRAY[('blanco'::character varying)::text, ('negro'::character varying)::text, ('mestizo'::character varying)::text]))),
    CONSTRAINT check_sexo CHECK ((sexo = ANY (ARRAY['f'::bpchar, 'm'::bpchar, 'F'::bpchar, 'M'::bpchar])))
);
    DROP TABLE public.paciente;
       public         heap    postgres    false            �            1259    18475    pacienteinguci    TABLE     
  CREATE TABLE public.pacienteinguci (
    apache integer NOT NULL,
    limitacion boolean,
    fechainguci date NOT NULL,
    fechaegreuci date NOT NULL,
    id_pacuci integer NOT NULL,
    sala_egreso character varying(50) NOT NULL,
    tiempovam integer NOT NULL,
    tipo_via character varying(50) NOT NULL,
    clasif_via character varying(50) NOT NULL,
    CONSTRAINT check_clasif CHECK (((clasif_via)::text = ANY (ARRAY[('con traqueotomia'::character varying)::text, ('sin traqueotomia'::character varying)::text]))),
    CONSTRAINT check_tiempo CHECK ((tiempovam > 0)),
    CONSTRAINT check_tipov CHECK (((tipo_via)::text = ANY (ARRAY[('tubo endotraqueal'::character varying)::text, ('traqueotomia TQ'::character varying)::text, ('TET-TQ'::character varying)::text])))
);
 "   DROP TABLE public.pacienteinguci;
       public         heap    postgres    false            �            1259    18481    post_uci_se_realiza    TABLE     |   CREATE TABLE public.post_uci_se_realiza (
    id_pacpost integer NOT NULL,
    enfermedadpost public.enfermedad NOT NULL
);
 '   DROP TABLE public.post_uci_se_realiza;
       public         heap    postgres    false    905            �            1259    18486    egresos    VIEW     1  CREATE VIEW public.egresos AS
 SELECT x.id_pac,
    x.fechaegreso,
    y.fechaegreuci,
    w.enfermedadpost,
    y.sala_egreso
   FROM public.paciente x,
    public.pacienteinguci y,
    public.post_uci_se_realiza w
  WHERE ((x.id_pac = y.id_pacuci) AND (y.id_pacuci = w.id_pacpost))
  ORDER BY x.id_pac;
    DROP VIEW public.egresos;
       public          postgres    false    216    216    218    218    217    217    217    905            �            1259    18490    en_uci_se_realiza    TABLE     w   CREATE TABLE public.en_uci_se_realiza (
    id_pacdt integer NOT NULL,
    enfermedaduci public.enfermedad NOT NULL
);
 %   DROP TABLE public.en_uci_se_realiza;
       public         heap    postgres    false    905            �            1259    18495    estadiaalta    VIEW     +  CREATE VIEW public.estadiaalta AS
 SELECT paciente.id_pac,
    paciente.sexo,
    paciente.raza,
    paciente.edad,
    paciente.fechaingreso,
    paciente.fechaegreso,
    (paciente.fechaegreso - paciente.fechaingreso) AS estadia
   FROM public.paciente
  WHERE (paciente.fechaegreso IS NOT NULL);
    DROP VIEW public.estadiaalta;
       public          postgres    false    216    216    216    216    216    216            �            1259    18499    estadiapresentes    VIEW     
  CREATE VIEW public.estadiapresentes AS
 SELECT paciente.id_pac,
    paciente.sexo,
    paciente.raza,
    paciente.edad,
    paciente.fechaingreso,
    (CURRENT_DATE - paciente.fechaingreso) AS estadia
   FROM public.paciente
  WHERE (paciente.fechaegreso IS NULL);
 #   DROP VIEW public.estadiapresentes;
       public          postgres    false    216    216    216    216    216    216            �            1259    18503 
   estadiauci    VIEW     �   CREATE VIEW public.estadiauci AS
 SELECT x.id_pacuci,
    y.sexo,
    y.raza,
    x.fechaegreuci,
    x.fechainguci,
    (x.fechaegreuci - x.fechainguci) AS estadia
   FROM public.pacienteinguci x,
    public.paciente y
  WHERE (x.id_pacuci = y.id_pac);
    DROP VIEW public.estadiauci;
       public          postgres    false    216    216    216    217    217    217            �            1259    18507 	   evolucion    VIEW     �   CREATE VIEW public.evolucion AS
 SELECT x.id_pac,
    x.sexo,
    x.raza,
    x.edad,
        CASE
            WHEN (x.sala_muerte IS NULL) THEN 'vivo'::text
            ELSE 'fallecido'::text
        END AS evolucion
   FROM public.paciente x;
    DROP VIEW public.evolucion;
       public          postgres    false    216    216    216    216    216            �           0    0    TABLE evolucion    ACL     /   GRANT SELECT ON TABLE public.evolucion TO adm;
          public          postgres    false    224            �            1259    18511    por_defuncion    TABLE     �   CREATE TABLE public.por_defuncion (
    id_pacd integer NOT NULL,
    salad character varying(50) NOT NULL,
    causad public.enfermedad NOT NULL,
    tipo_causad character varying(20) NOT NULL
);
 !   DROP TABLE public.por_defuncion;
       public         heap    postgres    false    905            �            1259    18516    por_necropsia    TABLE     �   CREATE TABLE public.por_necropsia (
    id_pacn integer NOT NULL,
    salan character varying(50) NOT NULL,
    causan public.enfermedad NOT NULL,
    tipo_causan character varying(20) NOT NULL
);
 !   DROP TABLE public.por_necropsia;
       public         heap    postgres    false    905            �            1259    18521    fallecimiento    VIEW     L  CREATE VIEW public.fallecimiento AS
 SELECT x.id_pac,
    x.sala_muerte,
    x.fechaegreso,
    d.causad,
    d.tipo_causad,
    n.causan,
    n.tipo_causan
   FROM public.paciente x,
    public.por_necropsia n,
    public.por_defuncion d
  WHERE ((x.fechaegreso IS NOT NULL) AND (x.id_pac = d.id_pacd) AND (x.id_pac = n.id_pacn));
     DROP VIEW public.fallecimiento;
       public          postgres    false    226    216    226    226    225    216    216    225    225    905    905            �            1259    18525    informacionpersonal    VIEW     �   CREATE VIEW public.informacionpersonal AS
 SELECT paciente.id_pac,
    paciente.edad,
    paciente.sexo,
    paciente.raza
   FROM public.paciente;
 &   DROP VIEW public.informacionpersonal;
       public          postgres    false    216    216    216    216            �            1259    18529    ingresos    VIEW       CREATE VIEW public.ingresos AS
 SELECT x.id_pac,
    x.fechaingreso,
    y.fechainguci,
    w.enfermedaduci
   FROM public.paciente x,
    public.pacienteinguci y,
    public.en_uci_se_realiza w
  WHERE ((x.id_pac = y.id_pacuci) AND (y.id_pacuci = w.id_pacdt))
  ORDER BY x.id_pac;
    DROP VIEW public.ingresos;
       public          postgres    false    220    220    217    216    217    216    905            �            1259    18533 
   mortalidad    VIEW     l   CREATE VIEW public.mortalidad AS
 SELECT paciente.id_pac,
    paciente.mort_oculta
   FROM public.paciente;
    DROP VIEW public.mortalidad;
       public          postgres    false    216    216            �            1259    18537    pac_defuncion    VIEW     �   CREATE VIEW public.pac_defuncion AS
 SELECT por_defuncion.id_pacd,
    por_defuncion.salad,
    por_defuncion.causad,
    por_defuncion.tipo_causad
   FROM public.por_defuncion
  ORDER BY por_defuncion.id_pacd;
     DROP VIEW public.pac_defuncion;
       public          postgres    false    225    225    225    225    905            �            1259    18541    pac_necropsia    VIEW     �   CREATE VIEW public.pac_necropsia AS
 SELECT por_necropsia.id_pacn,
    por_necropsia.salan,
    por_necropsia.causan,
    por_necropsia.tipo_causan
   FROM public.por_necropsia
  ORDER BY por_necropsia.id_pacn;
     DROP VIEW public.pac_necropsia;
       public          postgres    false    226    226    226    226    905            �            1259    18545    pacientefallecido    TABLE     y   CREATE TABLE public.pacientefallecido (
    id_pacf integer NOT NULL,
    sala_muertef character varying(50) NOT NULL
);
 %   DROP TABLE public.pacientefallecido;
       public         heap    postgres    false            �            1259    18548    pacientes_ingresadoshosp    VIEW     �   CREATE VIEW public.pacientes_ingresadoshosp AS
 SELECT paciente.id_pac,
    paciente.sexo,
    paciente.raza,
    paciente.fechaingreso,
    paciente.mort_oculta,
    paciente.edad
   FROM public.paciente
  WHERE (paciente.fechaegreso IS NULL);
 +   DROP VIEW public.pacientes_ingresadoshosp;
       public          postgres    false    216    216    216    216    216    216    216            �            1259    18552    pacientes_ingresadosuci    VIEW     �  CREATE VIEW public.pacientes_ingresadosuci AS
 SELECT pacienteinguci.apache,
    pacienteinguci.limitacion,
    pacienteinguci.fechainguci,
    pacienteinguci.fechaegreuci,
    pacienteinguci.id_pacuci,
    pacienteinguci.sala_egreso,
    pacienteinguci.tiempovam,
    pacienteinguci.tipo_via,
    pacienteinguci.clasif_via
   FROM public.pacienteinguci
  WHERE ((pacienteinguci.fechaegreuci IS NULL) AND (pacienteinguci.fechainguci IS NOT NULL));
 *   DROP VIEW public.pacientes_ingresadosuci;
       public          postgres    false    217    217    217    217    217    217    217    217    217            �            1259    18556    procedimiento    TABLE     A  CREATE TABLE public.procedimiento (
    causaproc public.enfermedad NOT NULL,
    tipo_causaproc character varying(20) NOT NULL,
    CONSTRAINT check_tipo CHECK (((tipo_causaproc)::text = ANY (ARRAY[('directa'::character varying)::text, ('intermedia'::character varying)::text, ('basica'::character varying)::text])))
);
 !   DROP TABLE public.procedimiento;
       public         heap    postgres    false    905            �            1259    18562    sala    TABLE     N   CREATE TABLE public.sala (
    especialidad character varying(50) NOT NULL
);
    DROP TABLE public.sala;
       public         heap    postgres    false            �            1259    18565    utiliza_vam_por    TABLE     n   CREATE TABLE public.utiliza_vam_por (
    id_pacp integer NOT NULL,
    nombrec public.enfermedad NOT NULL
);
 #   DROP TABLE public.utiliza_vam_por;
       public         heap    postgres    false    905            �            1259    18570    todofallecido    VIEW     �  CREATE VIEW public.todofallecido AS
 SELECT paciente.id_pac,
    paciente.sexo,
    paciente.raza,
    paciente.fechaingreso,
    paciente.fechaegreso,
    paciente.mort_oculta,
    paciente.sala_muerte,
    paciente.edad,
    pacienteinguci.apache,
    pacienteinguci.limitacion,
    pacienteinguci.fechainguci,
    pacienteinguci.fechaegreuci,
    pacienteinguci.sala_egreso,
    pacienteinguci.tiempovam,
    pacienteinguci.tipo_via,
    pacienteinguci.clasif_via,
    en_uci_se_realiza.enfermedaduci,
    por_defuncion.causad,
    por_defuncion.tipo_causad,
    por_necropsia.causan,
    por_necropsia.tipo_causan,
    post_uci_se_realiza.enfermedadpost,
    utiliza_vam_por.nombrec,
    causa.tipo_causa
   FROM ((((((((public.paciente
     JOIN public.pacienteinguci ON ((paciente.id_pac = pacienteinguci.id_pacuci)))
     JOIN public.en_uci_se_realiza ON ((pacienteinguci.id_pacuci = en_uci_se_realiza.id_pacdt)))
     JOIN public.pacientefallecido ON ((en_uci_se_realiza.id_pacdt = pacientefallecido.id_pacf)))
     JOIN public.por_defuncion ON ((pacientefallecido.id_pacf = por_defuncion.id_pacd)))
     JOIN public.por_necropsia ON ((por_defuncion.id_pacd = por_necropsia.id_pacn)))
     JOIN public.post_uci_se_realiza ON ((por_necropsia.id_pacn = post_uci_se_realiza.id_pacpost)))
     JOIN public.utiliza_vam_por ON ((post_uci_se_realiza.id_pacpost = utiliza_vam_por.id_pacp)))
     JOIN public.causa ON (((utiliza_vam_por.nombrec)::text = (causa.nombre)::text)));
     DROP VIEW public.todofallecido;
       public          postgres    false    214    226    226    225    225    225    220    220    218    218    217    217    217    217    216    217    217    217    216    216    216    216    217    217    216    216    214    216    238    238    233    226    905    905    905    905    905            �           0    0    TABLE todofallecido    ACL     3   GRANT SELECT ON TABLE public.todofallecido TO adm;
          public          postgres    false    239            �            1259    18575    todovivo    VIEW     *  CREATE VIEW public.todovivo AS
 SELECT paciente.id_pac,
    paciente.sexo,
    paciente.raza,
    paciente.fechaingreso,
    paciente.fechaegreso,
    paciente.mort_oculta,
    paciente.edad,
    pacienteinguci.apache,
    pacienteinguci.limitacion,
    pacienteinguci.fechainguci,
    pacienteinguci.fechaegreuci,
    pacienteinguci.sala_egreso,
    pacienteinguci.tiempovam,
    pacienteinguci.tipo_via,
    pacienteinguci.clasif_via,
    en_uci_se_realiza.enfermedaduci,
    post_uci_se_realiza.enfermedadpost,
    utiliza_vam_por.nombrec
   FROM ((((public.paciente
     JOIN public.pacienteinguci ON ((paciente.id_pac = pacienteinguci.id_pacuci)))
     JOIN public.en_uci_se_realiza ON ((pacienteinguci.id_pacuci = en_uci_se_realiza.id_pacdt)))
     JOIN public.post_uci_se_realiza ON ((en_uci_se_realiza.id_pacdt = post_uci_se_realiza.id_pacpost)))
     JOIN public.utiliza_vam_por ON ((post_uci_se_realiza.id_pacpost = utiliza_vam_por.id_pacp)))
  WHERE (NOT (paciente.id_pac IN ( SELECT pacientefallecido.id_pacf
           FROM public.pacientefallecido)));
    DROP VIEW public.todovivo;
       public          postgres    false    216    216    216    216    217    217    217    217    217    217    217    217    217    218    218    220    220    233    238    238    216    216    216    905    905    905            �           0    0    TABLE todovivo    ACL     .   GRANT SELECT ON TABLE public.todovivo TO adm;
          public          postgres    false    240            �            1259    18692    vistatodoslospacientes    VIEW     �  CREATE VIEW public.vistatodoslospacientes AS
 SELECT todofallecido.id_pac AS idpaciente,
    'fallecido'::text AS evolucion,
    todofallecido.sexo AS sexop,
    todofallecido.raza AS razap,
    todofallecido.edad AS edadp,
    todofallecido.fechaingreso AS fechai,
    todofallecido.fechaegreso AS fechae,
    todofallecido.mort_oculta AS mortalidad,
    todofallecido.sala_muerte AS salam,
    todofallecido.apache AS apachell,
    todofallecido.limitacion AS limitacionp,
    todofallecido.fechainguci AS fechauciin,
    todofallecido.fechaegreuci AS fechaucieg,
    todofallecido.sala_egreso AS salae,
    todofallecido.nombrec AS nombrecvam,
    todofallecido.tiempovam AS timevam,
    todofallecido.tipo_via AS tipovia,
    todofallecido.clasif_via AS clasif,
    todofallecido.enfermedaduci AS enfermedadpre,
    todofallecido.causad AS cdefuncion,
    todofallecido.tipo_causad AS tipodefuncion,
    todofallecido.causan AS cnecro,
    todofallecido.tipo_causan AS tiponecro,
    todofallecido.enfermedadpost,
    todofallecido.tipo_causa AS motivovam
   FROM public.todofallecido
UNION ALL
 SELECT todovivo.id_pac AS idpaciente,
    'vivo'::text AS evolucion,
    todovivo.sexo AS sexop,
    todovivo.raza AS razap,
    todovivo.edad AS edadp,
    todovivo.fechaingreso AS fechai,
    todovivo.fechaegreso AS fechae,
    todovivo.mort_oculta AS mortalidad,
    NULL::character varying AS salam,
    todovivo.apache AS apachell,
    todovivo.limitacion AS limitacionp,
    todovivo.fechainguci AS fechauciin,
    todovivo.fechaegreuci AS fechaucieg,
    todovivo.sala_egreso AS salae,
    todovivo.nombrec AS nombrecvam,
    todovivo.tiempovam AS timevam,
    todovivo.tipo_via AS tipovia,
    todovivo.clasif_via AS clasif,
    todovivo.enfermedaduci AS enfermedadpre,
    NULL::character varying AS cdefuncion,
    NULL::character varying AS tipodefuncion,
    NULL::character varying AS cnecro,
    NULL::character varying AS tiponecro,
    todovivo.enfermedadpost,
    NULL::character varying AS motivovam
   FROM public.todovivo;
 )   DROP VIEW public.vistatodoslospacientes;
       public          postgres    false    240    239    239    240    240    239    239    239    240    239    239    239    240    240    240    240    239    240    239    239    239    239    239    239    240    240    240    240    240    240    239    239    239    239    239    239    240    240    239    239    239    240    905    905    905            �           0    0    TABLE vistatodoslospacientes    ACL     <   GRANT SELECT ON TABLE public.vistatodoslospacientes TO adm;
          public          postgres    false    241            �          0    18457    causa 
   TABLE DATA           3   COPY public.causa (nombre, tipo_causa) FROM stdin;
    public          postgres    false    214   h      �          0    18463    diagnostico 
   TABLE DATA           1   COPY public.diagnostico (enfermedad) FROM stdin;
    public          postgres    false    215   �      �          0    18490    en_uci_se_realiza 
   TABLE DATA           D   COPY public.en_uci_se_realiza (id_pacdt, enfermedaduci) FROM stdin;
    public          postgres    false    220   	      �          0    18468    paciente 
   TABLE DATA           q   COPY public.paciente (id_pac, sexo, raza, fechaingreso, fechaegreso, mort_oculta, sala_muerte, edad) FROM stdin;
    public          postgres    false    216   J      �          0    18545    pacientefallecido 
   TABLE DATA           B   COPY public.pacientefallecido (id_pacf, sala_muertef) FROM stdin;
    public          postgres    false    233         �          0    18475    pacienteinguci 
   TABLE DATA           �   COPY public.pacienteinguci (apache, limitacion, fechainguci, fechaegreuci, id_pacuci, sala_egreso, tiempovam, tipo_via, clasif_via) FROM stdin;
    public          postgres    false    217   =      �          0    18511    por_defuncion 
   TABLE DATA           L   COPY public.por_defuncion (id_pacd, salad, causad, tipo_causad) FROM stdin;
    public          postgres    false    225   �      �          0    18516    por_necropsia 
   TABLE DATA           L   COPY public.por_necropsia (id_pacn, salan, causan, tipo_causan) FROM stdin;
    public          postgres    false    226   c      �          0    18481    post_uci_se_realiza 
   TABLE DATA           I   COPY public.post_uci_se_realiza (id_pacpost, enfermedadpost) FROM stdin;
    public          postgres    false    218   �      �          0    18556    procedimiento 
   TABLE DATA           B   COPY public.procedimiento (causaproc, tipo_causaproc) FROM stdin;
    public          postgres    false    236   8      �          0    18562    sala 
   TABLE DATA           ,   COPY public.sala (especialidad) FROM stdin;
    public          postgres    false    237   �      �          0    18565    utiliza_vam_por 
   TABLE DATA           ;   COPY public.utiliza_vam_por (id_pacp, nombrec) FROM stdin;
    public          postgres    false    238   �                 2606    18580    pacienteinguci check_apache    CHECK CONSTRAINT     v   ALTER TABLE public.pacienteinguci
    ADD CONSTRAINT check_apache CHECK (((apache < 68) AND (apache > 0))) NOT VALID;
 @   ALTER TABLE public.pacienteinguci DROP CONSTRAINT check_apache;
       public          postgres    false    217    217                       2606    18581    pacienteinguci check_fecha    CHECK CONSTRAINT     r   ALTER TABLE public.pacienteinguci
    ADD CONSTRAINT check_fecha CHECK ((fechainguci <= fechaegreuci)) NOT VALID;
 ?   ALTER TABLE public.pacienteinguci DROP CONSTRAINT check_fecha;
       public          postgres    false    217    217    217    217                        2606    18582    paciente check_fecha    CHECK CONSTRAINT     l   ALTER TABLE public.paciente
    ADD CONSTRAINT check_fecha CHECK ((fechaingreso <= fechaegreso)) NOT VALID;
 9   ALTER TABLE public.paciente DROP CONSTRAINT check_fecha;
       public          postgres    false    216    216    216    216            
           2606    18584    causa pk_causa 
   CONSTRAINT     P   ALTER TABLE ONLY public.causa
    ADD CONSTRAINT pk_causa PRIMARY KEY (nombre);
 8   ALTER TABLE ONLY public.causa DROP CONSTRAINT pk_causa;
       public            postgres    false    214                       2606    18586    por_defuncion pk_defuncion 
   CONSTRAINT     y   ALTER TABLE ONLY public.por_defuncion
    ADD CONSTRAINT pk_defuncion PRIMARY KEY (id_pacd, salad, causad, tipo_causad);
 D   ALTER TABLE ONLY public.por_defuncion DROP CONSTRAINT pk_defuncion;
       public            postgres    false    225    225    225    225                       2606    18588    diagnostico pk_diagnostico 
   CONSTRAINT     `   ALTER TABLE ONLY public.diagnostico
    ADD CONSTRAINT pk_diagnostico PRIMARY KEY (enfermedad);
 D   ALTER TABLE ONLY public.diagnostico DROP CONSTRAINT pk_diagnostico;
       public            postgres    false    215                       2606    18590    en_uci_se_realiza pk_enuci 
   CONSTRAINT     m   ALTER TABLE ONLY public.en_uci_se_realiza
    ADD CONSTRAINT pk_enuci PRIMARY KEY (id_pacdt, enfermedaduci);
 D   ALTER TABLE ONLY public.en_uci_se_realiza DROP CONSTRAINT pk_enuci;
       public            postgres    false    220    220                       2606    18592    pacienteinguci pk_inguci 
   CONSTRAINT     ]   ALTER TABLE ONLY public.pacienteinguci
    ADD CONSTRAINT pk_inguci PRIMARY KEY (id_pacuci);
 B   ALTER TABLE ONLY public.pacienteinguci DROP CONSTRAINT pk_inguci;
       public            postgres    false    217                       2606    18594    por_necropsia pk_necropsia 
   CONSTRAINT     y   ALTER TABLE ONLY public.por_necropsia
    ADD CONSTRAINT pk_necropsia PRIMARY KEY (id_pacn, salan, causan, tipo_causan);
 D   ALTER TABLE ONLY public.por_necropsia DROP CONSTRAINT pk_necropsia;
       public            postgres    false    226    226    226    226                       2606    18596    paciente pk_paciente 
   CONSTRAINT     V   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT pk_paciente PRIMARY KEY (id_pac);
 >   ALTER TABLE ONLY public.paciente DROP CONSTRAINT pk_paciente;
       public            postgres    false    216                       2606    18598 &   pacientefallecido pk_pacientefallecido 
   CONSTRAINT     w   ALTER TABLE ONLY public.pacientefallecido
    ADD CONSTRAINT pk_pacientefallecido PRIMARY KEY (id_pacf, sala_muertef);
 P   ALTER TABLE ONLY public.pacientefallecido DROP CONSTRAINT pk_pacientefallecido;
       public            postgres    false    233    233                        2606    18600    utiliza_vam_por pk_pesenta 
   CONSTRAINT     f   ALTER TABLE ONLY public.utiliza_vam_por
    ADD CONSTRAINT pk_pesenta PRIMARY KEY (id_pacp, nombrec);
 D   ALTER TABLE ONLY public.utiliza_vam_por DROP CONSTRAINT pk_pesenta;
       public            postgres    false    238    238                       2606    18602    post_uci_se_realiza pk_postuci 
   CONSTRAINT     t   ALTER TABLE ONLY public.post_uci_se_realiza
    ADD CONSTRAINT pk_postuci PRIMARY KEY (id_pacpost, enfermedadpost);
 H   ALTER TABLE ONLY public.post_uci_se_realiza DROP CONSTRAINT pk_postuci;
       public            postgres    false    218    218                       2606    18604    procedimiento pk_procedimiento 
   CONSTRAINT     s   ALTER TABLE ONLY public.procedimiento
    ADD CONSTRAINT pk_procedimiento PRIMARY KEY (causaproc, tipo_causaproc);
 H   ALTER TABLE ONLY public.procedimiento DROP CONSTRAINT pk_procedimiento;
       public            postgres    false    236    236                       2606    18606    sala pk_sala 
   CONSTRAINT     T   ALTER TABLE ONLY public.sala
    ADD CONSTRAINT pk_sala PRIMARY KEY (especialidad);
 6   ALTER TABLE ONLY public.sala DROP CONSTRAINT pk_sala;
       public            postgres    false    237            �           2618    18607 $   todofallecido insertarvistafallecido    RULE       CREATE RULE insertarvistafallecido AS
    ON INSERT TO public.todofallecido DO INSTEAD ( INSERT INTO public.paciente (id_pac, sexo, raza, fechaingreso, fechaegreso, mort_oculta, sala_muerte, edad)
  VALUES (new.id_pac, new.sexo, new.raza, new.fechaingreso, new.fechaegreso, new.mort_oculta, new.sala_muerte, new.edad);
 INSERT INTO public.pacienteinguci (apache, limitacion, fechainguci, fechaegreuci, id_pacuci, sala_egreso, tiempovam, tipo_via, clasif_via)
  VALUES (new.apache, new.limitacion, new.fechainguci, new.fechaegreuci, new.id_pac, new.sala_egreso, new.tiempovam, new.tipo_via, new.clasif_via);
 INSERT INTO public.en_uci_se_realiza (id_pacdt, enfermedaduci)
  VALUES (new.id_pac, new.enfermedaduci);
 INSERT INTO public.utiliza_vam_por (id_pacp, nombrec)
  VALUES (new.id_pac, new.nombrec);
 INSERT INTO public.post_uci_se_realiza (id_pacpost, enfermedadpost)
  VALUES (new.id_pac, new.enfermedadpost);
 INSERT INTO public.pacientefallecido (id_pacf, sala_muertef)
  VALUES (new.id_pac, new.sala_muerte);
 INSERT INTO public.por_defuncion (id_pacd, salad, causad, tipo_causad)
  VALUES (new.id_pac, new.sala_muerte, new.causad, new.tipo_causad);
 INSERT INTO public.por_necropsia (id_pacn, salan, causan, tipo_causan)
  VALUES (new.id_pac, new.sala_muerte, new.causan, new.tipo_causan);
);
 :   DROP RULE insertarvistafallecido ON public.todofallecido;
       public          postgres    false    239    216    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    239    238    238    233    233    226    226    226    226    225    225    225    225    220    220    218    218    217    217    217    217    217    217    217    217    217    216    216    216    216    216    216    216            �           2618    18609    todovivo insertarvistavivo    RULE     �  CREATE RULE insertarvistavivo AS
    ON INSERT TO public.todovivo DO INSTEAD ( INSERT INTO public.paciente (id_pac, sexo, raza, fechaingreso, fechaegreso, mort_oculta, sala_muerte, edad)
  VALUES (new.id_pac, new.sexo, new.raza, new.fechaingreso, new.fechaegreso, new.mort_oculta, NULL::character varying, new.edad);
 INSERT INTO public.pacienteinguci (apache, limitacion, fechainguci, fechaegreuci, id_pacuci, sala_egreso, tiempovam, tipo_via, clasif_via)
  VALUES (new.apache, new.limitacion, new.fechainguci, new.fechaegreuci, new.id_pac, new.sala_egreso, new.tiempovam, new.tipo_via, new.clasif_via);
 INSERT INTO public.en_uci_se_realiza (id_pacdt, enfermedaduci)
  VALUES (new.id_pac, new.enfermedaduci);
 INSERT INTO public.post_uci_se_realiza (id_pacpost, enfermedadpost)
  VALUES (new.id_pac, new.enfermedadpost);
 INSERT INTO public.utiliza_vam_por (id_pacp, nombrec)
  VALUES (new.id_pac, new.nombrec);
);
 0   DROP RULE insertarvistavivo ON public.todovivo;
       public          postgres    false    240    240    240    240    240    240    240    240    240    240    240    240    240    240    240    240    240    240    240    240    238    238    220    220    218    218    217    217    217    217    217    217    217    217    217    216    216    216    216    216    216    216    216            /           2620    18611    pacienteinguci insertarfechauci    TRIGGER     �   CREATE TRIGGER insertarfechauci BEFORE INSERT ON public.pacienteinguci FOR EACH ROW EXECUTE FUNCTION public.fechas_pac_pacuci();
 8   DROP TRIGGER insertarfechauci ON public.pacienteinguci;
       public          postgres    false    264    217            -           2606    18612    utiliza_vam_por fk_tocausa    FK CONSTRAINT     �   ALTER TABLE ONLY public.utiliza_vam_por
    ADD CONSTRAINT fk_tocausa FOREIGN KEY (nombrec) REFERENCES public.causa(nombre) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.utiliza_vam_por DROP CONSTRAINT fk_tocausa;
       public          postgres    false    238    3338    214            %           2606    18617 "   en_uci_se_realiza fk_todiagnostico    FK CONSTRAINT     �   ALTER TABLE ONLY public.en_uci_se_realiza
    ADD CONSTRAINT fk_todiagnostico FOREIGN KEY (enfermedaduci) REFERENCES public.diagnostico(enfermedad) ON UPDATE CASCADE ON DELETE CASCADE;
 L   ALTER TABLE ONLY public.en_uci_se_realiza DROP CONSTRAINT fk_todiagnostico;
       public          postgres    false    220    215    3340            $           2606    18622 $   post_uci_se_realiza fk_todiagnostico    FK CONSTRAINT     �   ALTER TABLE ONLY public.post_uci_se_realiza
    ADD CONSTRAINT fk_todiagnostico FOREIGN KEY (enfermedadpost) REFERENCES public.diagnostico(enfermedad) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY public.post_uci_se_realiza DROP CONSTRAINT fk_todiagnostico;
       public          postgres    false    218    3340    215            )           2606    18627    por_necropsia fk_tofallecido    FK CONSTRAINT     �   ALTER TABLE ONLY public.por_necropsia
    ADD CONSTRAINT fk_tofallecido FOREIGN KEY (id_pacn, salan) REFERENCES public.pacientefallecido(id_pacf, sala_muertef) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.por_necropsia DROP CONSTRAINT fk_tofallecido;
       public          postgres    false    226    226    3354    233    233            '           2606    18632    por_defuncion fk_tofallecido    FK CONSTRAINT     �   ALTER TABLE ONLY public.por_defuncion
    ADD CONSTRAINT fk_tofallecido FOREIGN KEY (id_pacd, salad) REFERENCES public.pacientefallecido(id_pacf, sala_muertef) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.por_defuncion DROP CONSTRAINT fk_tofallecido;
       public          postgres    false    225    225    3354    233    233            +           2606    18637    pacientefallecido fk_topaciente    FK CONSTRAINT     �   ALTER TABLE ONLY public.pacientefallecido
    ADD CONSTRAINT fk_topaciente FOREIGN KEY (id_pacf) REFERENCES public.paciente(id_pac) ON UPDATE CASCADE ON DELETE CASCADE;
 I   ALTER TABLE ONLY public.pacientefallecido DROP CONSTRAINT fk_topaciente;
       public          postgres    false    233    3342    216            "           2606    18642    pacienteinguci fk_topaciente    FK CONSTRAINT     �   ALTER TABLE ONLY public.pacienteinguci
    ADD CONSTRAINT fk_topaciente FOREIGN KEY (id_pacuci) REFERENCES public.paciente(id_pac) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.pacienteinguci DROP CONSTRAINT fk_topaciente;
       public          postgres    false    217    3342    216            &           2606    18647    en_uci_se_realiza fk_topacuci    FK CONSTRAINT     �   ALTER TABLE ONLY public.en_uci_se_realiza
    ADD CONSTRAINT fk_topacuci FOREIGN KEY (id_pacdt) REFERENCES public.pacienteinguci(id_pacuci) ON UPDATE CASCADE ON DELETE CASCADE;
 G   ALTER TABLE ONLY public.en_uci_se_realiza DROP CONSTRAINT fk_topacuci;
       public          postgres    false    220    3344    217            .           2606    18652    utiliza_vam_por fk_topacuci    FK CONSTRAINT     �   ALTER TABLE ONLY public.utiliza_vam_por
    ADD CONSTRAINT fk_topacuci FOREIGN KEY (id_pacp) REFERENCES public.pacienteinguci(id_pacuci) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.utiliza_vam_por DROP CONSTRAINT fk_topacuci;
       public          postgres    false    238    3344    217            *           2606    18657     por_necropsia fk_toprocedimiento    FK CONSTRAINT     �   ALTER TABLE ONLY public.por_necropsia
    ADD CONSTRAINT fk_toprocedimiento FOREIGN KEY (causan, tipo_causan) REFERENCES public.procedimiento(causaproc, tipo_causaproc) ON UPDATE CASCADE ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.por_necropsia DROP CONSTRAINT fk_toprocedimiento;
       public          postgres    false    3356    226    236    236    226            (           2606    18662     por_defuncion fk_toprocedimiento    FK CONSTRAINT     �   ALTER TABLE ONLY public.por_defuncion
    ADD CONSTRAINT fk_toprocedimiento FOREIGN KEY (causad, tipo_causad) REFERENCES public.procedimiento(causaproc, tipo_causaproc) ON UPDATE CASCADE ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.por_defuncion DROP CONSTRAINT fk_toprocedimiento;
       public          postgres    false    236    225    225    3356    236            !           2606    18667    paciente fk_tosala    FK CONSTRAINT     ~   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT fk_tosala FOREIGN KEY (sala_muerte) REFERENCES public.sala(especialidad);
 <   ALTER TABLE ONLY public.paciente DROP CONSTRAINT fk_tosala;
       public          postgres    false    237    3358    216            ,           2606    18672    pacientefallecido fk_tosala    FK CONSTRAINT     �   ALTER TABLE ONLY public.pacientefallecido
    ADD CONSTRAINT fk_tosala FOREIGN KEY (sala_muertef) REFERENCES public.sala(especialidad) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY public.pacientefallecido DROP CONSTRAINT fk_tosala;
       public          postgres    false    3358    237    233            #           2606    18677    pacienteinguci fk_tosala    FK CONSTRAINT     �   ALTER TABLE ONLY public.pacienteinguci
    ADD CONSTRAINT fk_tosala FOREIGN KEY (sala_egreso) REFERENCES public.sala(especialidad) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.pacienteinguci DROP CONSTRAINT fk_tosala;
       public          postgres    false    3358    237    217            �   H   x��K-����L�,J-.�,J,�/�L�rr	F	qv���W@KN,-N,VH�()J,(�����P���� �O%�      �   9   x�s��M�
qvU(N-K-��r��/JN��L�+�W��K��-�I-��s��qqq �?      �   1   x�3�t��M�2�qvU(N-K-��2C� �9�\���!T� ^i	      �   �   x����
�0�ϻ�쏱���[�^R�h|�C75�
{�7�������	�D��U�Q8���s��t���0R粹ũ	�?�k߅6�>�Lp��楌,�R6���hſ���;�_���2ʮ���UZ�жTuY��EJ��bŃm��;�L��ߞ�Y"      �   )   x�3�tN,J����O�L�2��MM�L��K�2F������ ;�U      �   �   x��ѱ
�0���+���%�:�����%6Q�k�����C����7T"����*G���}䖯с,�p�"t�S��Cp-�+^'�E'��8�%U�X�|lb�`7�����hx9P-h�K~E9Z���o�i��U(d����7���x�����i%�x�Е�      �   b   x�3�tN,J����O�L���+.M�L�L�K�LTH�$&'rf敤�9\&(�C\8S2�R�K�e\��9��3���8}�z�3�P5������ ��2;      �   o   x�3�tN,J����O�L���+.M�L�L�K�LTH�$&'rf敤�9\&x��d%���R2�R�K�5��;s&%g&'r�q��L��K�q�k0Ʃ!F��� �4;�      �   F   x�3�t��M�2�t��/JN��L�+�W��K��-�I-��2�)c���P�Z�Z��e��1�j�b���� ; �      �   `   x�U���0c_T�MX��^�$�qH��M��� ۑf�/u_���D�V7:�߉��M�)
_E`i�?;ARb�Q����S�OƘ����%*�      �   ,   x��MM�L��K��KM+���O�L�rN,JɄ�3�JAt� v�      �   %   x�3�qv�2�f`�Ѐ�1�%��B�C�=... ���     