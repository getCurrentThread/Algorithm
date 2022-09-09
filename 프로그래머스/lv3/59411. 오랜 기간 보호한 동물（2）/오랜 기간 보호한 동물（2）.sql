SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS as `ins`
    INNER JOIN ANIMAL_OUTS as `outs`
    ON ins.ANIMAL_ID = outs.ANIMAL_ID 
ORDER BY (ins.DATETIME - outs.DATETIME)
LIMIT 2 
;