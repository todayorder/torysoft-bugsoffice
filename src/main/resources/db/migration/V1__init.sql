
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

-- Space
drop table if exists `Space`;
create table `Space` (
  `spaceId` 		varchar(255) 	NOT NULL,
  `spaceName` 		varchar(255)	DEFAULT NULL,
  `spaceDesc` 		varchar(255) 	DEFAULT NULL,
  `spaceType` 		varchar(255) 	DEFAULT NULL,
  `uuid`	 		varchar(255) 	DEFAULT NULL,
  `saveUser` 		varchar(255) 	DEFAULT NULL,
  `saveTime` 		datetime 		DEFAULT NULL,
  `updateUser` 		varchar(255) 	DEFAULT NULL,
  `updateTime` 		datetime 		DEFAULT NULL,
  `isDeleted` 		varchar(255) 	DEFAULT 'N',
  PRIMARY KEY (`spaceId`),
  CONSTRAINT `FK_SPACE_SPACEOWNER` FOREIGN KEY (`uuid`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_SPACE_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_SPACE_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);

-- Member
drop table if exists `Member`;
create table `Member` (
  `memberId` 		varchar(255) 	NOT NULL,
  `spaceId`	 		varchar(255)	DEFAULT NULL,
  `memberRole`	 	varchar(255)	DEFAULT NULL,
  `uuid`	 		varchar(255)	DEFAULT NULL,
  `saveUser` 		varchar(255) 	DEFAULT NULL,
  `saveTime` 		datetime 		DEFAULT NULL,
  `updateUser` 		varchar(255) 	DEFAULT NULL,
  `updateTime` 		datetime 		DEFAULT NULL,
  `isDeleted` 		varchar(255) 	DEFAULT 'N',
  PRIMARY KEY (`memberId`),
  CONSTRAINT `FK_MEMBER_SPACE` FOREIGN KEY (`spaceId`) REFERENCES `Space` (`spaceId`),
  CONSTRAINT `FK_MEMBER_USER` FOREIGN KEY (`uuid`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_MEMBER_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_MEMBER_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);

-- Project
drop table if exists `Project`;
create table `Project` (
  `projectId` 		varchar(255) 	NOT NULL,
  `spaceId`		 	varchar(255)	DEFAULT NULL,
  `projectName`	 	varchar(255)	DEFAULT NULL,
  `projectDesc`	 	varchar(255)	DEFAULT NULL,
  `uuid`			varchar(255)	DEFAULT NULL,
  `saveUser` 		varchar(255) 	DEFAULT NULL,
  `saveTime` 		datetime 		DEFAULT NULL,
  `updateUser` 		varchar(255) 	DEFAULT NULL,
  `updateTime` 		datetime 		DEFAULT NULL,
  `isDeleted` 		varchar(255) 	DEFAULT 'N',
  PRIMARY KEY (`projectId`),
  CONSTRAINT `FK_PROJECT_SPACE` FOREIGN KEY (`spaceId`) REFERENCES `Space` (`spaceId`),
  CONSTRAINT `FK_PROJECT_OWNER` FOREIGN KEY (`uuid`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_PROJECT_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_PROJECT_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);

-- Member
drop table if exists `Tester`;
create table `Tester` (
  `testerId` 		varchar(255) 	NOT NULL,
  `projectId`	 	varchar(255)	DEFAULT NULL,
  `testerRole`	 	varchar(255)	DEFAULT NULL,
  `uuid`	 		varchar(255)	DEFAULT NULL,
  `saveUser` 		varchar(255) 	DEFAULT NULL,
  `saveTime` 		datetime 		DEFAULT NULL,
  `updateUser` 		varchar(255) 	DEFAULT NULL,
  `updateTime` 		datetime 		DEFAULT NULL,
  `isDeleted` 		varchar(255) 	DEFAULT 'N',
  PRIMARY KEY (`testerId`),
  CONSTRAINT `FK_TESTER_PROJECT` FOREIGN KEY (`projectId`) REFERENCES `Project` (`projectId`),
  CONSTRAINT `FK_TESTER_USER` FOREIGN KEY (`uuid`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_TESTER_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_TESTER_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);

-- Release
drop table if exists `Release`;
create table `Release` (
  `releaseId` 		varchar(255) 	NOT NULL,
  `projectId`	 	varchar(255)	DEFAULT NULL,
  `releaseVersion`	varchar(255)	DEFAULT NULL,
  `releaseContent`	varchar(255)	DEFAULT NULL,
  `saveUser` 		varchar(255) 	DEFAULT NULL,
  `saveTime` 		datetime 		DEFAULT NULL,
  `updateUser` 		varchar(255) 	DEFAULT NULL,
  `updateTime` 		datetime 		DEFAULT NULL,
  `isDeleted` 		varchar(255) 	DEFAULT 'N',
  PRIMARY KEY (`releaseId`),
  CONSTRAINT `FK_RELEASE_PROJECT` FOREIGN KEY (`projectId`) REFERENCES `Project` (`projectId`),
  CONSTRAINT `FK_RELEASE_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_RELEASE_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);

-- Release
drop table if exists `Case`;
create table `Case` (
  `caseId` 			varchar(255) 	NOT NULL,
  `releaseId`	 	varchar(255)	DEFAULT NULL,
  `caseName`		varchar(255)	DEFAULT NULL,
  `preCondition`	varchar(255)	DEFAULT NULL,
  `caseContent`		varchar(255)	DEFAULT NULL,
  `expectResult`	varchar(255)	DEFAULT NULL,
  `resultComment`	longtext		DEFAULT NULL,
  `result`			varchar(255)	DEFAULT NULL,
  `testerId`		varchar(255)	DEFAULT NULL,
  `saveUser` 		varchar(255) 	DEFAULT NULL,
  `saveTime` 		datetime 		DEFAULT NULL,
  `updateUser` 		varchar(255) 	DEFAULT NULL,
  `updateTime` 		datetime 		DEFAULT NULL,
  `isDeleted` 		varchar(255) 	DEFAULT 'N',
  PRIMARY KEY (`caseId`),
  CONSTRAINT `FK_CASE_RELEASE` FOREIGN KEY (`releaseId`) REFERENCES `Release` (`releaseId`),
  CONSTRAINT `FK_CASE_TESTER` FOREIGN KEY (`testerId`) REFERENCES `Tester` (`testerId`),
  CONSTRAINT `FK_CASE_SAVEUSER` FOREIGN KEY (`saveUser`) REFERENCES `User` (`uuid`),
  CONSTRAINT `FK_CASE_UPDATEUSER` FOREIGN KEY (`updateUser`) REFERENCES `User` (`uuid`)
);







