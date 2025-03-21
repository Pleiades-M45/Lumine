SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE count_employees (
    p_department_name IN VARCHAR2, 
    p_employee_count OUT NUMBER  
) IS
BEGIN

    SELECT COUNT(*) 
    INTO p_employee_count
    FROM employeess
    WHERE department = p_department_name;
    
END count_employees;
/

DECLARE
    v_employee_count NUMBER;
    dep VARCHAR2(20);
BEGIN
    dep := '&dep';
    count_employees(dep, v_employee_count);
    
    DBMS_OUTPUT.PUT_LINE('Number of employees in ' || dep || ': ' || v_employee_count);
END;
/
