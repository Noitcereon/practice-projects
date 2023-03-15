@ECHO OFF

REM is a comment and stands for "Remark"
REM I used the following article for help: https://dzone.com/articles/keytool-commandutility-to-generate-a-keystorecerti 
REM keytool is connected to the JVM. Official documentation can be found here: https://docs.oracle.com/javase/8/docs/technotes/tools/unix/keytool.html

REM Command flags
REM -keystore x.jks specifies the file name of the keystore.
REM -alias is an option to mention an Alias Name for your key entry
REM -keyalg specifies the algorithm to be used to generate the key pair
REM -keysize specifies the size of each key to be generated
REM -sigalg specifies the algorithm that should be used to sign the self-signed certificate; this algorithm must be compatible with keyalg.
REM -validity specifies how many days the keystore is valid for.



REM The below command generates a keystore called keystore.jks with the alias noitcereon-keystore.
REM The algorithm used for encryption is RSA with the specific SHA256withRSA algorithm. The keystore is valid for 365 days and the keysize is 2048 bit
keytool -genkey -keystore keystore.jks -alias noitcereon-keystore -keyalg RSA -sigalg SHA256withRSA -validity 365 -keysize 2048