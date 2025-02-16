SELECT 
    c.cust_name AS "Customer Name",
    c.city AS "Customer City",
    s.name AS "Salesman",
    s.city AS "Salesman City",
    s.commission
FROM 
    customer c
JOIN 
    salesman s ON c.salesman_id = s.salesman_id
WHERE 
    c.city <> s.city
    AND s.commission > 0.12;