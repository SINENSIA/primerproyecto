package com.sinensia.primerprograma.serializacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Ejemplo de serialización y encriptación de objetos.
 * Se incluye como explicación de la clase de serialización y para ilustrar
 * el uso de la clase Cipher.
 * Suppression of SonarLint warning about the password
 * 
 */
public class EncryptionDemo {
    /**
     * Suppress SonarLint warning sobre la contraseña.
     *
     * @param args argumentos de la línea de comandos
     **/
    @SuppressWarnings("java:S6437")
    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(EncryptionDemo.class.getName());
        // Objeto a serializar
        Person person = new Person("Juan", 30);

        try (// Serialización del objeto
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);

        ) {

            objectStream.writeObject(person);
            SecureRandom random = new SecureRandom();
            byte[] serializedData = byteStream.toByteArray();
            byte[] iv = new byte[12];
            random.nextBytes(iv); // Random 96 bit IV
            // Clave de encriptación (debe mantenerse segura) nuca dejarla en el
            // código fuente. Sólo proósito de demostración
            GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
            /*
             * See coment above. This password has no use!.
             * Just for demo purposes and to illustrate in the code
             * That PASSWORD SHOULD NEVE RBE IN THE SOURCE CODE!!
             * Sólo con el propósito de illustrar en el código
             * que la contraseña NUNCA DEBE ESTAR EN EL CÓDIGO FUENTE!!
             */
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] key = sha.digest("L_@·AUT_Veniam@aut_Facia.mAA_###".getBytes("UTF-8"));
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            /*
             * See coment above. This password has no use!
             * In a real application, you would store the key in a PROTECTED
             * NOT EXPOSED file or in a keystore.
             * 
             */
            // Inicializar el cifrado
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

            // Encriptar la secuencia de bytes
            byte[] encryptedData = cipher.doFinal(serializedData);
            System.out.println("Encrypted data: " + encryptedData);
            // Aquí guardarías o transmitirías "encryptedData"

            // Para desencriptar:
            cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Deserializar los bytes desencriptados
            ByteArrayInputStream decryptedByteStream = new ByteArrayInputStream(decryptedData);
            ObjectInputStream decryptedObjectStream = new ObjectInputStream(decryptedByteStream);
            Person deserializedPerson = (Person) decryptedObjectStream.readObject();
            System.out.println("Deserialized (y desencriptado) data: " + deserializedPerson);
            // Ahora tienes el objeto desencriptado
            System.out.println("Nombre: " + deserializedPerson.getName());
            System.out.println("Edad: " + deserializedPerson.getAge());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error: Genérico encriptación serialización - Investigar", e);
        }
    }
}
