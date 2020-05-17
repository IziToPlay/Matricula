INSERT INTO  users(enabled,password,user_name) VALUES(true,'$2a$10$sr2ZuTYlZ.LsliI6sv.HqeH39WsA.gz9Fdr.S0CyCBByyPQ8TObvS','admin');
INSERT INTO  users(enabled,password,user_name) VALUES(true,'$2a$10$ZoqMrCUHNN8lE2g1zssyuucNhExlYwN06kM/Jo6vEBhyTQduQ7iCy','jefe');

INSERT INTO authorities(authority,user_id) VALUES('ROLE_ADMIN',1);
INSERT INTO authorities(authority,user_id) VALUES('ROLE_USER',2);
