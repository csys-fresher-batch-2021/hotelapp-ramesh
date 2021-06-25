
create table hoteltype(
	hotel_id  serial primary key,
	hotel_name varchar(100) not null,
	contact_no varchar(100) not null,
	city_name varchar(100) not null,
	district_name varchar(100) not null,
	rooms varchar(10) not null,
	unique(contact_no,city_name,district_name)
);
create table hotel(
	hotel_id serial primary key,
	hotels varchar(100) not null unique
);
create table payment(
	hotel_name varchar(100) not null,
	amount varchar(3000) not null,
	status varchar(100) not null,
	payment_id  serial primary key,
	user_name varchar(100) not null
	
);