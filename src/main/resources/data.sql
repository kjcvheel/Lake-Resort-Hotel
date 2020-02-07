INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (1, 0, 0, 'roomImages/SINGLE.jpg', 'Suite 01', 200 ,0, "AVAILABLE", 'SINGLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (2, 0, 0, 'roomImages/DOUBLE.jpg', 'Safari', 300, 0, 'UNAVAILABLE', 'DOUBLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (4, 0, 0, 'roomImages/DOUBLE.jpg', 'Aquarium', 400, 0, 'AVAILABLE', 'DOUBLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (6, 1, 1, 'roomImages/PENTHOUSE.jpg', 'Bird Watchers', 500, 1, 'AVAILABLE',  'PENTHOUSE');

INSERT INTO GUEST(first_name, last_name, email, password, creditcard) VALUES ('kevin', 'van heel', 'kevinvanheel@capgemini.com', 'monkeys', 53435);
INSERT INTO GUEST(first_name, last_name, email, password, creditcard) VALUES ('joey', 'de groot', 'joey-de-groot@capgemini.com', 'bananas', 1231);
INSERT INTO GUEST(first_name, last_name, email, password, creditcard) VALUES ('nootje', 'wittink', 'noortje-wittink@capgemini.com', 'grapes', 31231);

--INSERT INTO BOOKING(adults, userid, children) VALUES (2, 2, 2);
--INSERT INTO BOOKING_ROOMS(bookings_id, rooms_id) values (1,2);