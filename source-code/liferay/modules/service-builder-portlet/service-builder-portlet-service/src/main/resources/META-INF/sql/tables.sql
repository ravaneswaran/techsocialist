create table poster_register (
	id_ LONG not null primary key,
	productionHouseId LONG,
	name VARCHAR(75) null,
	content BLOB,
	type_ VARCHAR(75) null,
	status VARCHAR(75) null,
	publishDateTime LONG,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	modifiedDate DATE null,
	createdDate DATE null
);

create table production_house_register (
	id_ LONG not null primary key,
	userId LONG,
	name VARCHAR(75) null,
	cin VARCHAR(75) null,
	logo BLOB,
	banner BLOB,
	landline VARCHAR(75) null,
	websiteUrl VARCHAR(75) null,
	addressLine1 VARCHAR(75) null,
	addressLine2 VARCHAR(75) null,
	addressLine3 VARCHAR(75) null,
	place VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	pincode VARCHAR(75) null,
	status VARCHAR(75) null,
	contactPersonFirstName VARCHAR(75) null,
	contactPersonLastNameName VARCHAR(75) null,
	contactPersonMobile VARCHAR(75) null,
	contactPersonEmail VARCHAR(75) null,
	userName VARCHAR(75) null,
	password_ VARCHAR(75) null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);,
	userId LONG,
	name VARCHAR(75) null,
	cin VARCHAR(75) null,
	logo BLOB,
	banner BLOB,
	landline VARCHAR(75) null,
	websiteUrl VARCHAR(75) null,
	addressLine1 VARCHAR(75) null,
	addressLine2 VARCHAR(75) null,
	addressLine3 VARCHAR(75) null,
	place VARCHAR(75) null,
	state_ VARCHAR(75) null,
	country VARCHAR(75) null,
	pincode VARCHAR(75) null,
	status VARCHAR(75) null,
	contactPersonFirstName VARCHAR(75) null,
	contactPersonLastNameName VARCHAR(75) null,
	contactPersonMobile VARCHAR(75) null,
	contactPersonEmail VARCHAR(75) null,
	userName VARCHAR(75) null,
	password_ VARCHAR(75) null,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);

create table ticket_price_register (
	id_ LONG not null primary key,
	price LONG,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);

create table ticket_register (
	id_ LONG not null primary key,
	userId LONG,
	videoId LONG,
	ticketPriceId LONG,
	ticketTaxId LONG,
	status VARCHAR(75) null,
	purchaseTime DATE null,
	soldTime DATE null,
	createdDate DATE null,
	modifiedDate DATE null
);

create table ticket_tax_register (
	id_ LONG not null primary key,
	percent LONG,
	enabled BOOLEAN,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);

create table video_register (
	id_ LONG not null primary key,
	userId LONG,
	productionHouseId LONG,
	name VARCHAR(75) null,
	thumbnail BLOB,
	content BLOB,
	type_ VARCHAR(75) null,
	status VARCHAR(75) null,
	ticketPrice DOUBLE,
	publishDateTime LONG,
	createdBy VARCHAR(75) null,
	modifiedBy VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);