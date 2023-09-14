package com.sinensia.primerprograma.serializacion;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionDemo {
    public static void main(String[] args) {

        final Logger LOGGER = Logger.getLogger(EncryptionDemo.class.getName());
        // Objeto a serializar
        Person person = new Person("Juan", 30);

        try (// Serialización del objeto
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);

        ) {

            objectStream.writeObject(person);
            byte[] serializedData = byteStream.toByteArray();
            byte[] iv = "iv".getBytes();
            // Clave de encriptación (debe mantenerse segura) nuca dejarla en el
            // código fuente. Sólo proósito de demostración
            GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
            SecretKeySpec secretKey = new SecretKeySpec(
                    "L_@·AUT_Veniam@aut_Facia.mAA_###".getBytes(), "AES");

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

            // Ahora tienes el objeto desencriptado
            System.out.println("Nombre: " + deserializedPerson.getName());
            System.out.println("Edad: " + deserializedPerson.getAge());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error: Genérico encriptación serialización - Investigar", e);
        }
    }
}
