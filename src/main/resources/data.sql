--RECORDS INITIALIZATION
INSERT INTO facility (id, name, price, area, description) VALUES (1, 'fabryka czekolady', 500, 1000, 'opis fabryki czekolady');
INSERT INTO facility (id, name, price, area, description) VALUES (2, 'biuro', 100, 50, 'w biurowcu');
INSERT INTO facility (id, name, price, area, description) VALUES (3, 'dom agroturystyczny', 250, 400, 'gdzieś na Mazurach');

INSERT INTO landlord(id,name) VALUES (1, 'Aleks Wynajmujący');
INSERT INTO landlord(id,name) VALUES (2, 'Piotr Wynajmówicz');
INSERT INTO landlord(id,name) VALUES (3, 'Genowefa Wynajczyk');

INSERT INTO tenant (id, name) VALUES (1, 'Lucy Najemcowicz');
INSERT INTO tenant (id, name) VALUES (2, 'Janusz Najemca');
INSERT INTO tenant (id, name) VALUES (3, 'Bartek Najemicz');