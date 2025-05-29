-- -----------------------------------------------------
-- Consulta para conocer el volumen solicitado de transporte
-- por complejo industrial y fecha
-- -----------------------------------------------------

select ci.razonSocial, nt.fecha, dt.volumensolicitado
from complejoindustrial as ci, nominaciontpte as nt, detallenomtpte as dt
where ci.CodigoCI = nt.codigoCI and
nt.numero = dt.numeroNom

-- -----------------------------------------------------
-- Consulta para conocer el volumen solicitado de inyeccion
-- por complejo industrial y fecha
-- -----------------------------------------------------

select ci.razonSocial, nt.fecha, dt.volumensolicitado
from complejoindustrial as ci, nominacioniny as nt, detallenominy as dt
where ci.CodigoCI = nt.CodigoCI and
nt.numeroiny = dt.numeronom

-- -----------------------------------------------------
-- Consulta para conocer los contratos vigentes que cada complejo 
-- industrial tiene y con que proveedor
-- -----------------------------------------------------

select ci.razonSocial, pr.razonsocial, co.fechadesde, co.fechahasta
from complejoindustrial as ci, proveedor as pr, contrato as co
where ci.CodigoCI = co.codigoCI and
pr.codigoProveedor = co.codigoProveedor
