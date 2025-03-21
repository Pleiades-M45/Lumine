SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE calculate_total(
    p_student_id IN NUMBER
) IS
    v_total_marks NUMBER;
BEGIN

    SELECT (sub1 + sub2 + sub3) 
    INTO v_total_marks
    FROM sessional_exam
    WHERE student_id = p_student_id;

    UPDATE sessional_exam
    SET total_marks = v_total_marks
    WHERE student_id = p_student_id;

    COMMIT;
END calculate_total;
/

DECLARE
    sid NUMBER;
BEGIN
    sid := &sid;
    calculate_total(sid);
    
    DBMS_OUTPUT.PUT_LINE('Total marks for student ID ' || sid || ' have been updated.');
END;
/