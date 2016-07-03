
-- User
drop table if exists `User`;
create table `User` (
  `uuid` 		varchar(255)	NOT NULL,
  `userId` 		varchar(255) 	DEFAULT NULL,
  `userName` 	varchar(255) 	DEFAULT NULL,
  `password` 	varchar(255) 	DEFAULT NULL,
  `email` 		varchar(255) 	DEFAULT NULL,
  `gender` 		varchar(255) 	DEFAULT NULL,
  `birthday` 	datetime 		DEFAULT NULL,
  `photoUrl` 	varchar(255) 	DEFAULT NULL,
  `userType` 	varchar(255) 	DEFAULT NULL,
  `cellPhone` 	varchar(255) 	DEFAULT NULL,
  `tel` 		varchar(255) 	DEFAULT NULL,
  `postCode` 	varchar(255) 	DEFAULT NULL,
  `addrMain` 	varchar(255) 	DEFAULT NULL,
  `addrDetail` 	varchar(255) 	DEFAULT NULL,
  `saveUser` 	varchar(255) 	DEFAULT NULL,
  `saveTime` 	datetime 		DEFAULT NULL,
  `updateUser` 	varchar(255) 	DEFAULT NULL,
  `updateTime` 	datetime 		DEFAULT NULL,
  `isDeleted` 	varchar(255) 	DEFAULT 'N',
  
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `UK_USER_EMAIL` (`email`),
  UNIQUE KEY `UK_USER_USER_ID` (`userId`),
  CONSTRAINT `FK_USER_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_USER_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);

-- Code
drop table if exists Code;
create table `Code` (
  `codeId` 			varchar(255) 	NOT NULL,
  `pCodeId` 		varchar(255)	DEFAULT NULL,
  `category` 		varchar(255) 	DEFAULT NULL,
  `codeKey` 		varchar(255) 	DEFAULT NULL,
  `codeValue` 		varchar(255) 	DEFAULT NULL,
  `comment` 		varchar(255) 	DEFAULT NULL,
  `lang` 			varchar(255) 	DEFAULT NULL,
  `saveUser` 		varchar(255) 	DEFAULT NULL,
  `saveTime` 		datetime 		DEFAULT NULL,
  `updateUser` 		varchar(255) 	DEFAULT NULL,
  `updateTime` 		datetime 		DEFAULT NULL,
  `isDeleted` 		varchar(255) 	DEFAULT 'N',
  PRIMARY KEY (`codeId`),
  CONSTRAINT `FK_CODE_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_CODE_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);

