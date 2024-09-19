create table users1(
	username varchar(50) not null primary key,
	password varchar(500) not null
);

create table admins (
	username varchar(50) not null,
	authority varchar(50) not null
);
