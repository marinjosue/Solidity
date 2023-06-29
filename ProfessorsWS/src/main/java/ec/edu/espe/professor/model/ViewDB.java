/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.professor.model;

import com.mongodb.client.FindIterable;
import org.bson.Document;

/**
 *
 * @author Yeshua Chiliquinga, JSons; DCCO-ESPE
 */
public class ViewDB extends ConectDB{
    public static void mostrarDatos() {
        // Obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        System.out.println("Datos en la base de datos:");
        for (Document documento : documentos) {
            // Convertir el documento a JSON y mostrarlo en la consola
            String json = documento.toJson();
            System.out.println(json);
            
        }

        // Obtener la cantidad de documentos en la colección
        long cantidad = collection.countDocuments();
        System.out.println("Cantidad de datos: " + cantidad);
    }
}
