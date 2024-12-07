create table PetClinic_Appointment (
	appointmentId LONG not null primary key,
	petId LONG,
	vetId LONG,
	date_ DATE null,
	description VARCHAR(75) null
);

create table PetClinic_Owner (
	ownerId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	telephone VARCHAR(75) null
);

create table PetClinic_Pet (
	petId LONG not null primary key,
	ownerId LONG,
	name VARCHAR(75) null,
	birthDate DATE null,
	type_ VARCHAR(75) null
);

create table PetClinic_Specialty (
	specialtyId LONG not null primary key,
	name VARCHAR(75) null
);

create table PetClinic_Vet (
	vetId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	specialties VARCHAR(75) null
);