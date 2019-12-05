CREATE DEFINER=`root`@`localhost` PROCEDURE `search`(IN loc varchar(20),IN expStart decimal(20),IN expEnd decimal(20),
IN domain varchar(20),IN empType varchar(20),IN empStatus varchar(20),IN skills varchar(100),IN endClient varchar(100),IN name varchar(255))
BEGIN
declare whereVariable varchar(2300)  default '';


set whereVariable = concat(whereVariable,'select * from edms.professional where ');

if(loc is not null) then
	set whereVariable = concat(whereVariable,'location_id = ''',loc,''' and ');
end if;

if(expStart is not null) then
	set whereVariable = concat(whereVariable,'total_experience BETWEEN (',expStart,') AND ');
end if;

if(expEnd is not null) then
	set whereVariable = concat(whereVariable,'(',expEnd,') and ');
end if;

if(endClient is not null) then
	set whereVariable = concat(whereVariable,'end_client_id =''',endClient,''' and ');
end if;

if(skills is not null) then
	set whereVariable = concat(whereVariable,'(general_skills like (''',skills,''') OR specific_skills like (''',skills,''')) and ');
end if;

if(domain is not null) then
	set whereVariable = concat(whereVariable,'client_domain_id = ''',domain,''' and ');
end if;

if(empType is not null) then
	set whereVariable = concat(whereVariable,'employee_id IN (select id from edms.employee where
emp_type_id = ''',empType,''' and ');
end if;

if(empStatus is not null) then
	if(empType is null) then
		set whereVariable = concat(whereVariable,'employee_id IN (select id from edms.employee where');
	end if;
    set whereVariable = concat(whereVariable,' status_id = ''',empStatus,''' and ');
end if;
    
if(name is not null) then
if(empType is null and empStatus is null) then
		set whereVariable = concat(whereVariable,'employee_id IN (select id from edms.employee where');
end if;
	set whereVariable = concat(whereVariable,'(full_name like (''',name,''') OR first_name like (''',name,''') OR last_name like (''',name,'''))) and ');
elseif(empType is not null or empStatus is not null) then
	set whereVariable = concat(whereVariable,'0<1) and ');
end if;

set whereVariable = concat(whereVariable,' 0<1 ');
SET @_stmt= whereVariable;
     PREPARE dynquery FROM @_stmt;
     EXECUTE dynquery;
    DEALLOCATE PREPARE dynquery;
END