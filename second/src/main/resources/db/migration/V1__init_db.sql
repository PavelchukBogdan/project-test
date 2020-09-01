create table user_message
(
	id bigserial not null,
	message varchar not null,
	user_name varchar not null,
	hash int not null,
	timestamp int8 not null
);

create unique index user_message_id_uindex
	on user_message (id);