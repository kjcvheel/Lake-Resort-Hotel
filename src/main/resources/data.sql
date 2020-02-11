INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (1, 0, 0, 'roomImages/SINGLE.jpg', 'Suite 01', 200 ,0, "AVAILABLE", 'SINGLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (2, 0, 0, 'roomImages/DOUBLE.jpg', 'Safari', 300, 0, 'UNAVAILABLE', 'DOUBLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (4, 0, 0, 'roomImages/DOUBLE.jpg', 'Aquarium', 400, 0, 'AVAILABLE', 'DOUBLE');
INSERT INTO ROOM (adult, children, disabled, image, name, price, smoking, status, type) VALUES (6, 1, 1, 'roomImages/PENTHOUSE.jpg', 'Bird Watchers', 500, 1, 'AVAILABLE',  'PENTHOUSE');

INSERT INTO GUEST(first_name, infix, last_name, email, password, creditcard) VALUES ('kevin', 'van', 'heel', 'kevinvanheel@capgemini.com', 'monkeys', 53435);
INSERT INTO GUEST(first_name, infix, last_name, email, password, creditcard) VALUES ('joey', 'de', 'groot', 'joey-de-groot@capgemini.com', 'bananas', 1231);
INSERT INTO GUEST(first_name, last_name, email, password, creditcard) VALUES ('nootje', 'wittink', 'noortje-wittink@capgemini.com', 'grapes', 31231);

INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status) VALUES(2,1,STR_TO_DATE( '2020-02-11', '%Y-%m-%d'), STR_TO_DATE( '2020-02-14', '%Y-%m-%d'), 50, true, "BOOKED");
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status) VALUES(2,1,STR_TO_DATE( '2020-02-12', '%Y-%m-%d'), STR_TO_DATE( '2020-02-14', '%Y-%m-%d'), 55, true, "BOOKED");
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status) VALUES(2,1,STR_TO_DATE( '2020-02-13', '%Y-%m-%d'), STR_TO_DATE( '2020-02-14', '%Y-%m-%d'), 60, true, "BOOKED");
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status) VALUES(2,1,STR_TO_DATE( '2020-02-10', '%Y-%m-%d'), STR_TO_DATE( '2020-02-12', '%Y-%m-%d'), 50, true, "BOOKED");
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status) VALUES(2,1,STR_TO_DATE( '2020-02-11', '%Y-%m-%d'), STR_TO_DATE( '2020-02-13', '%Y-%m-%d'), 55, true, "BOOKED");
INSERT INTO BOOKING(adults, children, start_date, end_date, invoiceid, payment_status, status) VALUES(2,1,STR_TO_DATE( '2020-02-12', '%Y-%m-%d'), STR_TO_DATE( '2020-02-13', '%Y-%m-%d'), 60, true, "BOOKED");
--INSERT INTO BOOKING(adults, userid, children) VALUES (2, 2, 2);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (1,1);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (2,4);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (3,2);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (3,3);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (4,4);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (5,2);
INSERT INTO BOOKING_ROOMS(booking_id, rooms_id) values (6,3);