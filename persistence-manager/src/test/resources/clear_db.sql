DROP SEQUENCE public.purchaseorderline_id_seq RESTRICT;
DROP SEQUENCE public.purchaseorder_id_seq RESTRICT;
DROP SEQUENCE public.client_id_seq RESTRICT;
DROP SEQUENCE public.purchaseorderheader_id_seq RESTRICT;

DROP SEQUENCE public.bd_cubicle_id_seq RESTRICT;
DROP SEQUENCE public.bd_employee_id_seq RESTRICT;

DROP SEQUENCE public.bd_department2_id_seq RESTRICT;
DROP SEQUENCE public.bd_employee2_id_seq RESTRICT;

DROP SEQUENCE public.bd_project3_id_seq RESTRICT;
DROP SEQUENCE public.bd_employee3_id_seq RESTRICT;

DROP SEQUENCE public.project4_id_seq RESTRICT;
DROP SEQUENCE public.employee4_id_seq RESTRICT;

DROP TABLE public.purchaseorder_purchaseorderline;
DROP TABLE public.purchaseorderline;
DROP TABLE public.purchaseorder;
DROP TABLE public.purchaseorderheader;
DROP TABLE public.client;

DROP TABLE bd_employee;
DROP TABLE bd_cubicle;

DROP TABLE bd_employee2;
DROP TABLE bd_department2;

DROP TABLE public.bd_project3_bd_employee3;
DROP TABLE public.bd_project3;
DROP TABLE public.bd_employee3;

DROP TABLE public.employee4_project4;
DROP TABLE public.project4;
DROP TABLE public.employee4;





