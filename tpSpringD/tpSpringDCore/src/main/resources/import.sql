-- fichier import.sql (dans src/main/resources du projet ...Core)
-- est spécifique a hibernate
-- il est utilisé au démarrage (juste apres la céation des tables)
-- si <property name="hibernate.hbm2ddl.auto" value="create" />
-- dans META-INF/persistence.xml ou config équivalente
INSERT INTO Client(numero,nom) VALUES(1,'client1');
INSERT INTO Client(numero,nom) VALUES(2,'client2');

INSERT INTO Compte(numero,label,solde,id_client) VALUES(1,'compte A',20.0,1);
INSERT INTO Compte(numero,label,solde,id_client) VALUES(2,'compte B',40.0,1);

INSERT INTO Compte(numero,label,solde,id_client) VALUES(3,'compte C',80.0,2);