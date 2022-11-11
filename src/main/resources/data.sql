--RECORDS INITIALIZATION

INSERT INTO landlord(id,name) VALUES (1, 'Aleks Wynajmujący');
INSERT INTO landlord(id,name) VALUES (2, 'Piotr Wynajmówicz');
INSERT INTO landlord(id,name) VALUES (3, 'Genowefa Wynajczyk');

INSERT INTO facility (id, name, price, area, description, landlord_id) VALUES (1, 'fabryka czekolady', 500, 1000, 'opis fabryki czekolady', 1);
INSERT INTO facility (id, name, price, area, description, landlord_id) VALUES (2, 'biuro', 100, 50, 'w biurowcu', 2);
INSERT INTO facility (id, name, price, area, description, landlord_id) VALUES (3, 'dom agroturystyczny', 250, 400, 'gdzieś na Mazurach', 3);

INSERT INTO tenant (id, name) VALUES (1, 'Lucy Najemcowicz');
INSERT INTO tenant (id, name) VALUES (2, 'Janusz Najemca');
INSERT INTO tenant (id, name) VALUES (3, 'Bartek Najemicz');