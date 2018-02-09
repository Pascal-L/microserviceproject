
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)
	VALUES('DES','symétrique','64','56',1975,'IBM','schéma de Feistel','cryptanalyse linéaire,cryptanalyse différentielle, attaque par force brute',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)
	VALUES('3DES','symétrique','64','112-168',1999,'IBM','schéma de Feistel','rencontre au milieu, attaque de van Oorschot et Wiener,attaque de Stefan Lucks',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)	
	VALUES('AES','symétrique','128','128-192-256',2000,'Joan Daemen, Vincent Rijmen','Réseau de substitution/permutation','Une attaque par clé apparentée casse 9 tours de AES-256. Une attaque par texte clair choisi casse 8 tours de AES-192 et 256, ou 7 tours de AES-128 (Ferguson et al, 2000).',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)	
	VALUES('Blowfish','symétrique','64','32-448',1993,'Bruce Scheiner','schéma de Feistel','Attaque sur quatre tours (Rijmen, 1997). Vulnérabilité statistique avec des clés faibles démontrée par Serge Vaudenay sur 14 tours en 1996.',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)	
	VALUES('RC5','symétrique','32-64-128','40-2024',1994,'Ron Rivest','rotations dépendantes des données','-',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)
	VALUES('RC6','symétrique','128','0-2048',1998,'Ron Rivest, Matt Robshaw,Ray Sidney,Yiqun Lisa Yin','rotations dépendantes des données','-',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)	
	VALUES('MISTY1','symétrique','64','128',1995,'Misturu','schéma de Feistel','Une attaque complète avec recouvrement total de la clef en 263,9999 chiffrés choisis et en temps 279 ou en 264 chiffrés choisis et en temps 269.5 opérations',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)	
	VALUES('RSA','asymétrique',null,'-',1978,' Ronald Rivest, Adi Shamir, Leonard Adleman','-','Attaque de Wiener,Attaque de Hastad, Attapque par chronométrage, Attaque à chiffrées choisis...',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)	
	VALUES('Elliptic Curve Cryptography','asymétrique',null,'-',1992,'Scott Vanstone','-','-',now(),now(),'PASCAL-L','PASCAL-L');
INSERT INTO Algorythm (NAME,TYPE,BLOC,KEY_LENGTH,CREATIONYEAR,CREATEDBY,STRUCTURE,KNOWN_ATTACKS,CreatedDate,ModifiedDate,UserCreation,UserModification)	
	VALUES('ElGamal','asymétrique',null,'-',1984,'Taher Elgamal','-','Attaque à chiffré choisi',now(),now(),'PASCAL-L','PASCAL-L');