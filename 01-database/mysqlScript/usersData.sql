USE `reactmovieplanetdatabase`;
SET SQL_SAFE_UPDATES = 0;

DELETE FROM `users`;
INSERT INTO `users` (`user_id`,`user_email`,`user_name`,`password`,`role`) VALUES 
(200001, '909565441@qq.com', 'silence', '1234', 'VIP'),
(200002, 'example2@example.com', 'user001', 'password123', 'VIP'),
(200003, 'test002@testmail.net', 'AliceSmith', 'qwerty', '普通用户'),
(200004, 'random.user003@gmail.com', 'BobJohnson', 'letmein123', 'VIP'),
(200005, 'user004@demo.org', 'CharlieBrown', 'password1', '普通用户'),
(200006, 'example.user005@domain.io', 'DavidWilson', 'p@ssw0rd', 'VIP'),
(200007, 'user006@example.email', 'EvaTaylor', 'securepass', '普通用户'),
(200008, 'test.user007@internet.biz', 'FrankMoore', 'password12', 'VIP'),
(200009, 'randomuser008@webmail.co', 'GraceAdams', 'secret123', '普通用户'),
(200010, 'user009@examplemail.net', 'HenryMiller', 'password!', 'VIP'),
(200011, 'demo.user010@service.com', 'IsabellaWhite', 'p@ssword123', '普通用户'),
(200012, 'user12@example.com', 'AlexWong', 'password123', '普通用户'),
(200013, 'johndoe13@163.com', 'JohnDoe', 'qwerty123', 'VIP'),
(200014, 'sarahjane14@google.com', 'SarahJane', 'letmein', '普通用户'),
(200015, 'michaelbrown15@qq.com', 'MichaelBrown', 'p@ssword', 'VIP'),
(200016, 'emilyclark16@163.com', 'EmilyClark', 'securePwd', '普通用户'),
(200017, 'davidlee17@google.com', 'DavidLee', 'passw0rd!', 'VIP'),
(200018, 'laurarichards18@example.com', 'LauraRichards', 's3cur3P@ss', '普通用户'),
(200019, 'robertmartin19@163.com', 'RobertMartin', 'pa$$word12', 'VIP'),
(200020, 'elizabethharris20@google.com', 'ElizabethHarris', 'mySecurePass', '普通用户'),
(200021, 'williamanderson21@example.com', 'WilliamAnderson', 'safeP@ss123', 'VIP'),
(200022, 'rachelmoore22@163.com', 'RachelMoore', 'p@ssw0rd2023', '普通用户'),
(200023, 'matthewtaylor23@google.com', 'MatthewTaylor', 'secureP@sswd', 'VIP'),
(200024, 'ashleyparker24@example.com', 'AshleyParker', 'password#12', '普通用户'),
(200025, 'brianjohnson25@163.com', 'BrianJohnson', 's3cureP@ss', 'VIP'),
(200026, 'oliviawright26@google.com', 'OliviaWright', 'myP@ssword1', '普通用户'),
(200027, 'ethanwilliams27@example.com', 'EthanWilliams', 'safeP@ssw0rd', 'VIP'),
(200028, 'adaevans28@163.com', 'AdaEvans', 'secureP@sswrd12', '普通用户'),
(200029, 'liamdavis29@google.com', 'LiamDavis', 'p@ssword_2023', 'VIP'),
(200030, 'alice30@qq.com', 'Alice', '5445723', 'VIP'),
(200031, 'noahmoore31@example.com', 'NoahMoore', 'P@ssw0rd!', '普通用户'),
(200032, 'isabellawalker32@163.com', 'IsabellaWalker', 's3CuReP@ss', 'VIP'),
(200033, 'lucasandrews33@google.com', 'LucasAndrews', 'myS3curePwd', '普通用户'),
(200034, 'maddisoncampbell34@example.com', 'MaddisonCampbell', 'Pa$$w0rd123', 'VIP'),
(200035, 'benjaminwright35@163.com', 'BenjaminWright', 'SecureP@ss!', '普通用户'),
(200036, 'avaevans36@google.com', 'AvaEvans', 'P@ssw0rd_2023', 'VIP'),
(200037, 'sebastianharris37@example.com', 'SebastianHarris', 'SafeP@ssw0rd', '普通用户'),
(200038, 'ameliajones38@163.com', 'AmeliaJones', 'SecurePwd#1', 'VIP'),
(200039, 'liamwilson39@google.com', 'LiamWilson', 'MyP@ssword!', '普通用户'),
(200040, 'oliverbrown40@example.com', 'OliverBrown', 'S3curePass12', 'VIP'),
(200041, 'charlottegreen41@163.com', 'CharlotteGreen', 'P@$$word!', '普通用户'),
(200042, 'jamesphillips42@google.com', 'JamesPhillips', 'SecureP@sswd1', 'VIP'),
(200043, 'sophiacarter43@example.com', 'SophiaCarter', 'MySecurePwd', '普通用户'),
(200044, 'jacksonturner44@163.com', 'JacksonTurner', 'P@ssw0rd_123', 'VIP'),
(200045, 'emmataylor45@google.com', 'EmmaTaylor', 'SecurePass!', '普通用户'),
(200046, 'ethanwood46@example.com', 'EthanWood', 'S3cureP@ssw0rd', 'VIP'),
(200047, 'gracecooper47@163.com', 'GraceCooper', 'MyP@ssword12', '普通用户'),
(200048, 'leowatson48@google.com', 'LeoWatson', 'SecurePwd#2023', 'VIP'),
(200049, 'lucycampbell49@example.com', 'LucyCampbell', 'P@ssword!', '普通用户'),
(200050, 'michilejame50@qq.com', 'MichileJame', '2244654414', 'VIP');

INSERT INTO `users` (`user_id`,`user_email`,`user_name`,`password`,`role`) VALUES 
(2000051, 'testuser@email.com', 'test', 'hjw040305', '普通用户');

INSERT INTO `users` (`user_id`,`user_email`,`user_name`,`password`,`role`) VALUES 
(2000054, 'admin01@email.com', 'admin', 'hjw040305', 'admin');