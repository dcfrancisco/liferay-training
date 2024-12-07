create index IX_25DEC21D on PetClinic_Appointment (petId);
create index IX_634425A3 on PetClinic_Appointment (vetId);

create index IX_3098BBD6 on PetClinic_Owner (lastName[$COLUMN_LENGTH:75$]);

create index IX_6E9F7BF1 on PetClinic_Pet (ownerId);