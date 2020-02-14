INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (1, 0, 0, 'roomImages/SINGLE.jpg', 'Suite 01', 200 ,0, "AVAILABLE", 'SINGLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (1, 0, 0, 'roomImages/SINGLE.jpg', 'Suite 02', 200, 0, "AVAILABLE", 'SINGLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (1, 0, 0, 'roomImages/SINGLE.jpg', 'Suite 02', 200, 0, "AVAILABLE", 'SINGLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (2, 0, 0, 'roomImages/DOUBLE.jpg', 'Safari', 300, 0, 'UNAVAILABLE', 'DOUBLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (4, 0, 0, 'roomImages/DOUBLE.jpg', 'Aquarium', 400, 0, 'AVAILABLE', 'DOUBLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (6, 1, 1, 'roomImages/PENTHOUSE.jpg', 'Bird Watchers', 500, 1, 'AVAILABLE',  'PENTHOUSE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (1, 0, 0, 'roomImages/SINGLE.jpg', 'Suite 02', 200, 0, "AVAILABLE", 'SINGLE');

INSERT INTO GUEST(first_name, infix, last_name, email, password, creditcard, street_name1, address_number, birthday, country, city, zipcode, phone_number, mobile_number) VALUES ('Klaas', '', 'Janssen', 'klaas.janssen@capgemini.com', 'monkeys', 53435, "biltstraat", "22A", "1996-02-16", "Netherlands", "Utrecht", "12345", "+31611215359", "+31611215359" );
INSERT INTO GUEST(first_name, infix, last_name, email, password, creditcard, street_name1, street_name2, address_number, birthday, country, city, zipcode, phone_number, mobile_number) VALUES ('Joey', 'de', 'Groot', 'joey-de-groot@capgemini.com', 'bananas', 1231, "Grote", "Haag", "50", "1996-02-16", "Netherlands", "Utrecht", "12345", "+316231453127", "+31611215359");
INSERT INTO GUEST(first_name, last_name, email, password, creditcard, street_name1, street_name2, street_name3, address_number, birthday, country, city, zipcode, phone_number, mobile_number) VALUES ('Noortje', 'Wittink', 'noortje-wittink@capgemini.com', 'grapes', 31231, "Coole straat", "ade", "FXX", "17", "1996-02-16", "Netherlands", "Utrecht", "12345", "+31621165405", "+31621165405");

INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status, userid) VALUES(2,1,STR_TO_DATE( '2020-02-11', '%Y-%m-%d'), STR_TO_DATE( '2020-02-14', '%Y-%m-%d'), 50, true, "BOOKED", 1);
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status, userid) VALUES(2,1,STR_TO_DATE( '2020-02-12', '%Y-%m-%d'), STR_TO_DATE( '2020-02-14', '%Y-%m-%d'), 55, true, "BOOKED", 2);
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status, userid) VALUES(2,1,STR_TO_DATE( '2020-02-13', '%Y-%m-%d'), STR_TO_DATE( '2020-02-14', '%Y-%m-%d'), 60, true, "BOOKED", 3);
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status, userid) VALUES(2,1,STR_TO_DATE( '2020-03-10', '%Y-%m-%d'), STR_TO_DATE( '2020-03-12', '%Y-%m-%d'), 50, true, "BOOKED", 1);
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status, userid) VALUES(2,1,STR_TO_DATE( '2020-03-11', '%Y-%m-%d'), STR_TO_DATE( '2020-03-13', '%Y-%m-%d'), 55, true, "BOOKED", 2);
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status, userid) VALUES(2,1,STR_TO_DATE( '2020-03-12', '%Y-%m-%d'), STR_TO_DATE( '2020-03-13', '%Y-%m-%d'), 60, true, "BOOKED", 3);
--INSERT INTO BOOKING(adults, userid, children) VALUES (2, 2, 2);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (1,1);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (2,4);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (3,2);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (3,3);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (4,4);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (5,2);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (6,3);