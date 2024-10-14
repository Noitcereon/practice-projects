
INSERT INTO `Actor` (`id`, `firstName`, `lastName`, `birthYear`) VALUES
                                                                     (1,	'Unknown',	'the Unknown',	2000),
                                                                     (2,	'Unknown',	'the Unknown',	2000),
                                                                     (3,	'Viggo',	'Mortensen',	1957),
                                                                     (4,	'Another',	'Actors-son',	2022),
                                                                     (5,	'Tom',	'Holland',	1996);

INSERT INTO `Movie` (`id`, `title`, `releaseYear`) VALUES
                                                       (1,	'Lord of the Rings: Fellowship of the Ring',	2001),
                                                       (2,	'Lord of the Rings: The Two Towers',	2002),
                                                       (3,	'Lord of the Rings: Return of the King',	2004);

INSERT INTO `MovieActor` (`id`, `fkActorId`, `fkMovieId`) VALUES
                                                              (1,	2,	1),
                                                              (2,	3,	1),
                                                              (3,	2,	2),
                                                              (4,	3,	2),
                                                              (5,	2,	3),
                                                              (6,	3,	3),
                                                              (7,	1,	3);