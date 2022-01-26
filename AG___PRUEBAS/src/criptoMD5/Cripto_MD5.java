package criptoMD5;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Cripto_MD5 {

    public static void main(String[] args) {

        String res = getMD5("admin");
        System.out.println(res);
        res = getMD5("Hola, esto es un texto");
        System.out.println(res);
        res = getMD5("1234");
        System.out.println(res);
        res = getMD5("usu1");
        System.out.println(res);
        res = getMD5("pepe");
        System.out.println(res);
        res = getMD5("paco");
        System.out.println(res);


    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}


class CifrarConHASH {

    public static void main(String[] args) {
        // MD5 permite encriptar una frase, pero no permite desencriptarla.
        // Es útil para guardar password con encriptación MD5 en una base de datos.
        // Cuando un usuario introduce su clave, el código la encripta con MD5
        // y compara con la que hay en base de datos.
        // De esta forma, la clave en claro no está almacenada en ningún sitio y tampoco
        // es posible
        // recuperarla a partir de la encriptada.
        String res = aplicarHashMD5_v1("paco en la luna");
        System.out.println(res);

    }

    public static String aplicarHashMD5_v1(String mensaje_original) {

        try {
            // Creamos un objeto MessageDigest asociado al algoritmo de encriptado a
            // utilizar (HASH-MD5 de 64 bits en este caso)
            // MessageDigest y las clases siguientes de procesado de encriptación son clases
            // que ofrece Java como parte de las Extensiones Criptográficas Java (JCE)

            // El primer parametro de getInstance() es el nombre del algoritmo digest a
            // usar:"MD5", "MD4", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512",
            // "RIPEMD128", "RIPEMD160"...
            // Puede haber un segundo parametro con el proveedor de seguridad
            MessageDigest md = MessageDigest.getInstance("MD5");

            // crear el resumen con el método digest();
            // el resumen es un array de 16 bytes
            byte[] messageDigest = md.digest(mensaje_original.getBytes());

            // convertimos el array de bytes en un numero (muy grande, de 39 digitos o asi)
            // con signo positivo (eso dice el parámetro con valor 1)
            BigInteger number = new BigInteger(1, messageDigest);

            // convertimos el numero grande a hexadecimal
            // el resutlado es un string de longitud 32
            String hashtexthexadecimal = number.toString(16);

            // si no han salido 32 chars, añadimos ceros por delante hasta
            // que la longitud sea 32
            while (hashtexthexadecimal.length() < 32) {
                hashtexthexadecimal = "0" + hashtexthexadecimal;
            }
            return hashtexthexadecimal;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void aplicarHashMD5_v2() {
        try {

            // Esta version 2 lee un fichero con varias lineas
            // y crea un resumen de todas ellas

            MessageDigest md = MessageDigest.getInstance("MD5");

            // abrimos un fichero para leer su contenido
            File file = new File("sinencriptarHASH.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Leemos linea a linea el fichero,
            // y las vamos almacenando acumulándolas en el objeto MessageDigest
            String linea;
            linea = br.readLine();
            while (linea != null) {
                md.update(linea.getBytes());
                linea = br.readLine();
            }
            // crear el resumen con el método digest();
            byte[] resumen = md.digest();

            // De modo distinto al otro ejemplo previo, aqui no convertimos el resumen en
            // string
            // sino que lo escribimos directamente en pantalla
            for (byte b : resumen) {
                System.out.print(Integer.toHexString(0xFF & b));
            }

        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}


class CifrarConDES {
    public static void main(String[] args) throws Exception {
        CifrarConDES c = new CifrarConDES();
        c.cifrarConDES();
//        c.descifrarConDES();
    }

    public void cifrarConDES() throws Exception {
		// Creamos un objeto KeyGenerator asociado al algoritmo de encriptado a utilizar (DES en este caso, algoritmo simétrico)
		// KeyGenerator y las clases siguientes de encriptación son clases que ofrece Java como parte de las Extensiones Criptográficas Java (JCE)
		KeyGenerator obKeyGenerator;
		obKeyGenerator = KeyGenerator.getInstance("DES");

		// Generamos la clave con el método generateKey()
		SecretKey obSecretKey = obKeyGenerator.generateKey();

		// Se crea un objeto Cipher, para efectuar encriptados y desencriptados.
		// Se crea asociándolo al algoritmo de encriptado a utilizar (DES en este caso, algoritmo simétrico)
		Cipher obCipher = Cipher.getInstance("DES");

		// Se configura el objeto Cipher, indicándole el modo (encriptar/desencriptar,
		// encriptar en este caso) y pasándole como parámetro la clave de encriptacion creada anteriormente.
		obCipher.init(Cipher.ENCRYPT_MODE, obSecretKey);

		// Abrimos el fichero fuente que deseamos encriptar y creamos un stream para su lectura
		File fileEntrada = new File("sinencriptarDES.txt");
		FileInputStream fisEntrada = new FileInputStream(fileEntrada);

		// Abrimos el fichero destino donde escribiremos el fichero fuente encriptado y creamos un stream para su escritura
		File fileSalida = new File("encriptadoDES.txt");
		if (!fileSalida.exists()) fileSalida.createNewFile();
		FileOutputStream fosSalida = new FileOutputStream(fileSalida);

		// Leemos todo el contenido del fichero de entrada,
		// para lo cual se define un tamaño de bloque de lectura de 8 bytes y se recorre el fichero de entrada bloque a bloque.
		// Para cada bloque, se efectúa la escritura del mismo ya encriptada usado el método doFinal() del objeto Cypher
		byte[] buffer = new byte[8];
		int leidos = fisEntrada.read(buffer);
		while (leidos != -1) {
			fosSalida.write(obCipher.doFinal(buffer, 0, leidos));
			leidos = fisEntrada.read(buffer);
		}
		// Se procede a crear un fichero con la clave de encriptado usada.
		// Para ello se crea primero un objeto de la factoría de claves SecretKeyFactory
		SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");

		// Con el objeto anterior, y con su método getKeySpec se obtiene la información de
		// la especificación de la clave usada, que se guarda en un objeto de DESKeySpec
		DESKeySpec obDESKeySpec = (DESKeySpec) keyfac.getKeySpec(obSecretKey, DESKeySpec.class);

		// Se crea un fichero para escribir la clave,
		File fichclave = new File("claveDES.txt");
		if (!fichclave.exists()) fichclave.createNewFile();
		FileOutputStream fosclave = new FileOutputStream(fichclave);

		// Se escribe dicha clace tras obtenerla a través de la especificación obtenida en el objeto DESKeySpec, con su método getKey()
		fosclave.write(obDESKeySpec.getKey());

		System.out.println("Cifrado completo¡");
	}


    public void cifrarConAES() throws Exception {

        ///////////////////////////////////////////////////////////////////////////
        // Cifrado y descifrado sencillo de un solo mensaje de texto
        // usamos ahora AES en vez de DES, son ambos simetricos

        // Generaremos una clave de 128 bits adecuada para AES
        // Primero crearemos un generador de claves y le decimos que el bloque que cree sera de 128 bis
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);

        // OPCION 1, la clave se crea aleatoriamente y directamente con el metodo generateKey()
        Key key = keyGenerator.generateKey();
        // Alternativamente, una clave que queramos que tenga al menos 16 bytes
        // OPCION 2, la clave se crea a partir de una cadenasde texto
        // Se crea un array de bytes desde ua cadena de texto cualquiera
        byte[] valoresEnbytes = "una clave de 16 bytes".getBytes();
        // y se elije crear con el array una clave, desde un bloqeu de 16 chars (0 a 16)
        key = new SecretKeySpec(valoresEnbytes, 0, 16, "AES");

        // Texto a encriptar
        String mensajeoriginal = "Este es el texto que queremos encriptar";

        // Se obtiene un cifrador AES
        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Se inicializa para encriptacion y se encripta el texto,
        // que debemos pasar como array de bytes.
        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] mensajeCifrado = aes.doFinal(mensajeoriginal.getBytes());

        // Se iniciliza el cifrador para desencriptar, con la
        // misma clave y se desencripta
        aes.init(Cipher.DECRYPT_MODE, key);
        byte[] mensajeDesencripado = aes.doFinal(mensajeCifrado);

        // Texto obtenido, igual al original.
        System.out.println("Mensaje original; " + mensajeoriginal.toLowerCase());
        // mensajecifrado es un array de bytes, asi se convierte en un String
        String mensa = new String(mensajeCifrado);
        System.out.println("Mensaje cifrado; " + mensa);
        System.out.println("Mensaje cifrado en hexadecimal; ");
        for (byte b : mensajeCifrado) {
            System.out.print(Integer.toHexString(0xFF & b));
        }
        System.out.println();
        // mensajedesencriptado tambien era un array de bytes, asi se convierte en un String
        System.out.println("Mensaje desencriptado; " + new String(mensajeDesencripado));
    }



	public void cifrarConRSA() throws Exception {
		// Generar el par de claves
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PublicKey obClavePublica = keyPair.getPublic();
		PrivateKey obClavePrivada = keyPair.getPrivate();

		// Se salva y recupera de fichero la clave publica
		guardarClave(obClavePublica, "clavePublica.dat");
		obClavePublica = leerClavePublicaDeFichero("publickey.dat");

		// Se salva y recupera de fichero la clave privada
		guardarClave(obClavePrivada, "clavePrivada.dat");
		obClavePrivada = leerClavePrivadaDeFichero("privatekey.dat");

		// Obtener la clase para encriptar/desencriptar
		Cipher obCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

		// Texto a encriptar
		String mensajeoriginal = "Texto que queremos encriptar";

		// Se encripta
		obCipher.init(Cipher.ENCRYPT_MODE, obClavePublica);
		byte[] mensajeCifrado = obCipher.doFinal(mensajeoriginal.getBytes());

		// Se desencripta
		obCipher.init(Cipher.DECRYPT_MODE, obClavePrivada);
		byte[] bytesDesencriptados = obCipher.doFinal(mensajeCifrado);
		String mensajeDesencripado = new String(bytesDesencriptados);


		// Texto obtenido, igual al original.
		System.out.println("Mensaje original; " + mensajeoriginal);
		System.out.println("Mensaje cifrado; " + new String(mensajeCifrado));
		System.out.println("Mensaje cifrado en hexadecimal; ");
		for (byte b : mensajeCifrado) {
			System.out.print(Integer.toHexString(0xFF & b));
		}
		System.out.println();
		System.out.println("Mensaje desencriptado; " + new String(mensajeDesencripado));
	}

	private static PublicKey leerClavePublicaDeFichero (String fileName) throws Exception {
		FileInputStream fis = new FileInputStream (fileName);
		int numBtyes = fis.available ();
		byte[] bytes = new byte[numBtyes];
		fis.read (bytes);
		fis.close ();

		KeyFactory keyFactory = KeyFactory.getInstance ("RSA");
		KeySpec keySpec = new X509EncodedKeySpec(bytes);
		PublicKey keyFromBytes = keyFactory.generatePublic (keySpec);
		return keyFromBytes;
	}

	private static PrivateKey leerClavePrivadaDeFichero (String fileName) throws Exception {
		FileInputStream fis = new FileInputStream (fileName);
		int numBtyes = fis.available ();
		byte[] bytes = new byte[numBtyes];
		fis.read (bytes);
		fis.close ();

		KeyFactory keyFactory = KeyFactory.getInstance ("RSA");
		KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
		PrivateKey keyFromBytes = keyFactory.generatePrivate (keySpec);
		return keyFromBytes;
	}

	private static void guardarClave (Key key, String fileName) throws Exception {
		byte[] publicKeyBytes = key.getEncoded ();
		FileOutputStream fos = new FileOutputStream (fileName);
		fos.write (publicKeyBytes);
		fos.close ();
	}
}



class EscuchadorBoton1 implements ActionListener {
	@Override
	public void actionPerformed (ActionEvent ev) {
		// AQUI VIENE EL CÓDIGO A EJECUTAR CUANDO SE PINCHE EN EL BOTON
		JOptionPane.showMessageDialog (null, "Ha pulsado un boton !", "Atención", JOptionPane.INFORMATION_MESSAGE);
	}
}