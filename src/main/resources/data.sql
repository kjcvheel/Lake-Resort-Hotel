INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES ('1', '0', 0, 'test', 'Chimpansee', 200 ,0, 0, 'Single');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES ('2', '0', 0, 'test', 'Gorilla', 300, 0, 'Unavailable', 'Double');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES ('4', '0', 0, 'test', 'Baboon', 400, 0, 'Available', 'Double');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES ('6', '1', 1, 'test', 'The Orang-Utan', 500, 1, 'Available',  'Penthouse');

INSERT INTO GUEST(first_name, last_name, email, password, creditcard) VALUES ('kevin', 'van heel', 'kevinvanheel@capgemini.com', 'monkeys', 53435);
INSERT INTO GUEST(first_name, last_name, email, password, creditcard) VALUES ('joey', 'de groot', 'joey-de-groot@capgemini.com', 'bananas', 1231);
INSERT INTO GUEST(first_name, last_name, email, password, creditcard) VALUES ('nootje', 'wittink', 'noortje-wittink@capgemini.com', 'grapes', 31231);

INSERT INTO BOOKING(adults, userid) VALUES (2, 2);
INSERT INTO BOOKING_ROOMS(bookings_id, rooms_id) values (1,2);